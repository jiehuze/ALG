package com.jiehu.code.dp.subsequence;

/**
 * 300. 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * 提示：
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * 进阶：
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        /**
         * 1。 定义dp[i], 下标为i时的最长子序列；
         */
        int[] dp = new int[nums.length];
        /**
         * 2。 推导公式：
         * 分析： 当j在0--j-1之间，当nums[i]>nums[j]时，有两种状态：
         *    1）加入，那么就需要+1， dp[i] = dp[j]+1
         *    2）不加入，初始值不变, dp[i] = dp[i]
         *    所以： dp[i] = Math.max(dp[i-1]+1, dp[i-1])
         * 3. 初始化：dp[0-i] = 1
         * 4. 遍历顺序：从小到大遍历, 遍历i在外层，遍历j在内层
         */
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            /**
             * 最后取dp中最大的数
             */
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}


























