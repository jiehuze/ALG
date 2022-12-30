package com.jiehu.code.dp.subsequence;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class MaxSubArray {
    /**
     * 1. 动态规划
     */
    public int maxSubArray(int[] nums) {
        /**
         * 1.定义： dp[i] 在下标为i时，j从0--i-1 之间最大和
         */
        int[] dp = new int[nums.length];
        /**
         * 2. 推导公式： 两个状态：
         *   1）前一个最大值 + nums[i]
         *   2) 当前nums[i]
         *   dp[i] = max（dp[i-1]+nums[i] , nums[i]）
         *
         *  result = max(dp[i][j], result)
         *
         * 3。 初始化： 第一行为：从0-i的和
         * 4。 正向遍历
         */
        int result = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
