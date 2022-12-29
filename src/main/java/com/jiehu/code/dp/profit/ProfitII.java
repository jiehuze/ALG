package com.jiehu.code.dp.profit;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * 示例 1：
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 总利润为 4 。
 * 示例 3：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 * 提示：
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 */
public class ProfitII {
    /**
     * 1。 动态规划
     * 可以多次购买，还是同样的道理，获取最后一天的所得最多现金
     * 不是最优解法
     */
    public int maxProfit(int[] prices) {
        /**
         * 1. dp[i][0]: 第i天持有股票的最多现金
         *    dp[i][1]: 第i天不持有股票的最多现金
         */
        int[][] dp = new int[prices.length][2];
        /**
         * 2. 递推公式：根据状态
         *   1）如果第 i 天持有股票，可以由 2 个状态推导而来
         *      A: 第 i-1 天持有股票： dp[i][0] = dp[i-1][0]
         *      B: 第 i-1 天不持有股票： dp[i][0] = dp[i-1][1] - prices[i]
         *      所以： dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i])
         *   2) 如果第 i 天不持有股票，可以由 2 个状态推导而来
         *      A: 第 i-1 天持有股票： dp[i][1] = dp[i-1][0] + prices[i]
         *      B: 第 i-1 天不持有股票： dp[i][1] = dp[i-1][1]
         *      所有： dp[i][1] = max(dp[i-1][0] + prices[i], dp[i-1][1])
         *
         *  3。 初始化：
         *      持有股票的现金  ： dp[0][0] = -prices[0]
         *      不持有股票的现金： dp[0][1] = 0
         *  4. 遍历顺序： 从1开始遍历
         */
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }

        return dp[prices.length - 1][1];
    }

    /**
     * 2。 最优解法为： 只需要获得每天的正利润便可
     */
    public int maxProfit2(int[] prices) {
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }

        return result;
    }
}
