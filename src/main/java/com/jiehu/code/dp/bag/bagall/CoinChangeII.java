package com.jiehu.code.dp.bag.bagall;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/submissions/
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChangeII {
    /**
     * 先分析： 这个硬币个数时无限的，背包为amount，所以时完全背包问题
     */
    public int coinChange(int[] coins, int amount) {
        /**
         * 1. dp定义： dp[j] 含义 容量为j时的背包最小个数
         */
        int[] dp = new int[amount + 1];
        /**
         * 2. 递推公式： 因为时种类： dp[j] = min(dp[j], dp[j-cons[i]]+1)
         * 3. 初始化： dp[0] = 1, 其他为最大值
         * 4. 遍历顺序： 因为是组合问题，不要求顺序，所以使用组合方式，先遍历物品后背包
         */
        for (int j = 0; j <= amount; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) return -1;

        return dp[amount];
    }
}
