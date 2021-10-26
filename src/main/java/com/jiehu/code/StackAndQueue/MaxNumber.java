package com.jiehu.code.StackAndQueue;

/**
 * 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * 示例 1:
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * <p>
 * 示例 2:
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * <p>
 * 示例 3:
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * <p>
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 */
public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int start = Math.max(0, k - l2);
        int end = Math.min(k, l1);
        int[] maxSub = new int[k];

        for (int i = start; i <= end; i++) {
            int[] sub1 = maxSubsequence(nums1, i);
            int[] sub2 = maxSubsequence(nums2, k - i);
            int[] merge = merge(sub1, sub2);
            if (compare(maxSub, 0, merge, 0) < 0) {
                System.arraycopy(merge, 0, maxSub, 0, k);
            }
        }

        return maxSub;
    }

    //数组中找到k个最大的数组序列
    public int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        int top = -1;
        int remain = len - k; //剩余多少位置
        int[] stack = new int[k]; //要返回的数组栈
        //遍历数组
        for (int i = 0; i < len; i++) {

            while (top >= 0 && nums[i] > stack[top] && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = nums[i];
            } else {
                remain--;
            }
        }

        return stack;
    }

    //将两个数组进行合并，按照大小顺序
    public int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] rest = new int[len1 + len2];

        if(len1 == 0){
            return nums2;
        }
        if(len2 == 0){
            return nums1;
        }

        int t1 = 0, t2 = 0;
        for (int i = 0; i < len1 + len2; i++) {
            if (compare(nums1, t1, nums2, t2) > 0) {
                rest[i] = nums1[t1++];
            } else {
                rest[i] = nums2[t2++];
            }
        }
        return rest;
    }

    //判断数组的大小
    public int compare(int[] nums1, int index1, int[] nums2, int index2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        while (index1 < len1 && index2 < len2) {
            int diff = nums1[index1] - nums2[index2];
            if (diff != 0) {
                return diff;
            }

            index1++;
            index2++;
        }

        return (len1 - index1) - (len2 - index2);
    }
}
