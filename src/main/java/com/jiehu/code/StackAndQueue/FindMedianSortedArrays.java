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
     * 使用归并排序来完成两个数组的合并，通过merge两个数组完成
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
}















