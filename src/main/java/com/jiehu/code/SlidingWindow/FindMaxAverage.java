package com.jiehu.code.SlidingWindow;

/**
 * 643. 子数组最大平均数 I     另一个平均数2重点看下
 * 阿里面试
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * 示例 1：
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 */
public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        return findMaxAverage1(nums, k);
    }

    public double findMaxAverage1(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k - 1) continue;
            if (i >= k) {
                sum -= nums[i - k];
            }
            max = Math.max(sum, max);
        }

        return (double) max / k;
    }
}
