package com.jiehu.code.StackAndQueue;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 提示：
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * <p>
 * 优先队列：PriorityQueue讲解,二叉堆
 * https://www.cnblogs.com/Elliott-Su-Faith-change-our-life/p/7472265.html
 * 内嵌函数：compare
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest2(nums, k);
    }

    /**
     * 这个方法利用了数组api，做两个事情
     * 1.对数组进行排序: 排序有很多种，：快速排序，二分法排序，冒泡排序等
     * 2。读取第K个元素输出
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k - 1];
    }

    /**
     * 方法二：使用堆栈的方式存储，不使用api
     * 知识点：使用最大根堆，最大根堆的特点是：根节点大于叶子节点，根结点为最大数
     */
    public int findKthLargest2(int[] nums, int k) {
        int headsize = nums.length;
        buildMaxheap(nums, nums.length);

        System.out.println(Arrays.toString(nums));

        //题需要，因为根节点的数，即为这个数组的最大值，所以只需要计算减去k次后，根结点的值即为所需要的值
        for (int i = 0; i < k - 1; i++) {
            //删除根上的最大值，用叶子节点的最后一个值替代
            nums[0] = nums[headsize - 1];
            headsize--;
            maxHeapify(nums, 0, headsize);
        }

        return nums[0];
    }

    /**
     * 构建最大跟堆
     */
    public void buildMaxheap(int[] nums, int headsize) {
        //从叶子节点开始进行交互，层高为：headsize/2
        for (int i = headsize / 2; i >= 0; i--) {
            maxHeapify(nums, i, headsize);
        }
    }

    /**
     * 层高：  parentNo = headsize/2;
     * 该根结点的两个自节点为,父子节点之间的关系：
     * lNo = 2*i+1
     * rNo = 2*i+2
     * parentNo = (nodeNo-1)/2
     */
    public void maxHeapify(int[] nums, int i, int headsize) {
        //这个计算公式很重要，一定要记住
        int l = 2 * i + 1, r = 2 * i + 2, largest = i;
        if (l < headsize && nums[l] > nums[largest]) {
            largest = l;
        }

        if (r < headsize && nums[r] > nums[largest]) {
            largest = r;
        }

        //这时候如果largest不为i了，说明有比这个值大的了，需要交互数据
        if (largest != i) {
            swap(nums, i, largest);
            //继续把他下面的节点一并交互数据
            maxHeapify(nums, largest, headsize);
        }

    }

    public void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
