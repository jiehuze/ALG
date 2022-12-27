package com.jiehu.code.dp.bag.bagall;

/**
 * 279. 完全平方数
 * https://leetcode.cn/problems/perfect-squares/
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 提示：
 * 1 <= n <= 104
 */
public class NumSquares {
    public int numSquares(int n) {
        /**
         * 先分析： 因为是求总的N，使用的数是1往上的自然数，并且个数不限制，所以可以将总和认为是背包，1往上的数为物品，所以就是完全背包问题
         * 求最少数量就是： dp[j] = main(dp[j], dp[j-nums[i]]+1)
         * nums[i] = i * i;
         */
        /**
         * 1. dp[j]: 含义为和为j的完全平方数的最少个数
         */
        int[] dp = new int[n + 1];
        /**
         * 2. 递推公式： dp[j] = main(dp[j], dp[j-nums[i]]+1)
         *          * nums[i] = i * i;
         * 3。 初始化： dp[0] = 1, 其他为最大数
         * 4。 遍历：因为是组合方式，所以先物品，后背包
         */

        for (int i = 0; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) { //物品
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n];
    }
}
