package com.jiehu.code.StackAndQueue;

import java.util.PriorityQueue;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianSortedArrays {
    //使用优先队列的方式，使用最小堆和最大堆，最小堆根存最大数，最大堆根存最小数，最小堆size>=最大堆size，但不超过1个
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> queMin = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> queMax = new PriorityQueue<>((a, b) -> a - b);

        int len1 = nums1.length;
        int len2 = nums2.length;
        int maxLen = Math.max(len1, len2);

        for (int i = 0; i < maxLen; i++) {
            if (i < len1) {
                addQueue(nums1[i], queMin, queMax);
            }

            if (i < len2) {
                addQueue(nums2[i], queMin, queMax);
            }
        }

        if (queMin.size() > queMax.size())
            return queMin.peek();
        else {
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }

    public void addQueue(int num, PriorityQueue<Integer> queMin, PriorityQueue<Integer> queMax) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            //必须保持平衡，min最多比max多一个数，否则就需要将min中的最大数推出给max
            if (queMin.size() > queMax.size() + 1) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    /**
     * 二：使用归并排序来完成两个数组的合并，通过merge两个数组完成
     * 这个速度快，只需要2ms
     * 优先队列那个需要8ms
     * 内存消耗一样
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        merge(arr, nums1, nums2);

        int mid = arr.length / 2;
        if (arr.length == 0) {
            return 0;
        } else if (arr.length % 2 == 1) {
            return arr[mid];
        } else {
            return (arr[mid] + arr[mid - 1]) / 2.0;
        }
    }

    public void merge(int[] arr, int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int t = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                arr[t++] = nums2[j++];
            } else {
                arr[t++] = nums1[i++];
            }
        }

        while (i < nums1.length) {
            arr[t++] = nums1[i++];
        }

        while (j < nums2.length) {
            arr[t++] = nums2[j++];
        }
    }

    /**
     * 三：二分查找
     * 不需要合并两个有序数组，只要找到中位数的位置即可。由于两个数组的长度已知，因此中位数对应的两个数组的下标之和也是已知的。
     * 维护两个指针，初始时分别指向两个数组的下标 00 的位置，每次将指向较小值的指针后移一位（如果一个指针已经到达数组末尾，
     * 则只需要移动另一个数组的指针），直到到达中位数的位置。
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}




























