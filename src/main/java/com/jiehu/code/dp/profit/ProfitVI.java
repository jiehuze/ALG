package com.jiehu.code.dp.profit;

/**
 * 714. 买卖股票的最佳时机含手续费
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 示例 1：
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * 示例 2：
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 * 提示：
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 */
public class ProfitVI {
    public int maxProfit(int[] prices, int fee) {
        /**
         * 1, 定义： dp[i][j] 第i天两种j状态下的现金
         *  状态1： j=0， 持有股票状态
         *  状态2： j=1， 不持有股票状态
         */
        int[][] dp = new int[prices.length][2];

        /**
         * 2. 推导公式： 两个状态：
         *    1） 今日持有股票状态： dp[i][0],有两个状态而来：
         *      A： 今日买入股票,那么昨天肯定是不持有了： dp[i][0] = dp[i-1][1] - prices[i]
         *      B: 昨天就已经买入股票： dp[i][0] = dp[i-1][0]
         *      所以： dp[i][0] = Math.max(dp[i-1][1] - prices[i], dp[i-1][0])
         *    2)  今日不持有股票, dp[i][1],由两个状态而来
         *      A: 昨天就已经不持有股票： dp[i][1] = dp[i-1][1]
         *      B: 昨天持有股票，今日卖出: dp[i][1] = dp[i-1][0] + prices[i] - fee
         *      所以： dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee)
         *
         *  3. 初始化： 买入为负数
         */
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return dp[prices.length - 1][1];
    }
}
