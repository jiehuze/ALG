package com.jiehu.code.array.oneDimensionArray;

/**
 * 189. 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class Rotate {
    public void rotate(int[] nums, int k) {

    }

    //方法一：粗暴方式，真的进行数组的k次旋转
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int c1 = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int c2 = nums[j];
                nums[j] = c1;
                c1 = c2;
            }
        }
    }

    /**
     * 方法二：
     * 1）先对数组进行反转
     * 2）取K个数位置，前后区间数据进行反转，即为旋转的数据
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了 100.00%的用户
     * 内存消耗：55.2 MB, 在所有 Java 提交中击败了68.70%的用户
     */
    public void rotate2(int[] nums, int k) {
        //如果k>nums.len，那么就需要取余数即可
        k %= nums.length;
        //第一次翻转：为全部反转：
        reverse(nums, 0, nums.length - 1);

        //第二次翻转，以k为分界，两侧翻转
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            start++;
            end--;
        }
    }

    /**
     * 方法三：额外数组
     */

    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
