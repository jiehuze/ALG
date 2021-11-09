package com.jiehu.code.SlidingWindow;

/**
 * 209. 长度最小的子数组
 * 字节跳动
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class MinSubArrayLen {
    /**
     * 方法一：使用类似双向队列方式，按照下标递增存储
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                minLen = Math.min(right - left, minLen);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    /**
     * 方法二：二分法，暂时不会
     */
}
