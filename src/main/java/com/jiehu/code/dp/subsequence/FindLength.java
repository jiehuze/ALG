package com.jiehu.code.dp.subsequence;

/**
 * 718. 最长重复子数组
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * 示例 1：
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 */
public class FindLength {
    /**
     * 1. 动态规划方法
     */
    public int findLength(int[] nums1, int[] nums2) {
        /**
         * 1. dp[i][j]： 在数组nums1下标为i-1时，nums2下标为j-1时的重复子数组长度
         */
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        /**
         * 2. 推导公式：
         *         3   2   1   4   7
         *   -----------------------
         *    ｜ 0  0  0   0   0   0
         *   1｜ 0  0  0   1   0   0
         *   2｜ 0  0  1   0   0   0         1
         *   3｜ 0  1  0   0   0   0          \
         *   2｜ 0  0  2   0   0   0          _\/
         *   1｜ 0  0  0   3   0   0            2
         *  当两个数组中的字符相等时，当前的dp值就只有从一个方向：可以从左上角推导而来：这就是连续
         *  nums1[i-1] == nums2[j-1] dp[i][j] = dp[i-1][j-1] + 1
         * 3。 初始化全部为0
         * 4。 遍历顺序，从i；1-m， j：1-n
         */
        int result = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;

                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
