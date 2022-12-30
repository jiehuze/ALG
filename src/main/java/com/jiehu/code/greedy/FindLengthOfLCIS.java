package com.jiehu.code.greedy;

/**
 * 674. 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * 示例 1：
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 */
public class FindLengthOfLCIS {
    /**
     * 贪心算法
     */
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        int l = 0, r = 1;
        while (r < nums.length) {
            if (nums[r - 1] < nums[r]) {
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                l = r;
            }
            r++;
        }

        return maxLen;
    }

    /**
     * 方法2： 动态规划算法
     * 内层消耗和执行时间都不如 贪心算法
     */
    public int findLengthOfLCIS2(int[] nums) {
        //1。 定义dp[i], 下标为i时的最大连续字串长度
        int[] dp = new int[nums.length];
        /**
         * 2. 推动公式： 有两种状态
         *    1） nums[i] > nums[i-1] dp[i] = dp[i-1]+1
         *    2) nums[i] <= nums[i-1] dp[i] = 1
         * 3. 初始化，每个dp初始都为1
         * 4. 遍历顺序，i遍历从0-i
         */

        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) dp[i] = 1;
            else dp[i] = dp[i - 1] + 1;

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
