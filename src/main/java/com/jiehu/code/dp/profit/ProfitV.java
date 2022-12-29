package com.jiehu.code.dp.profit;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * 输入: prices = [1]
 * 输出: 0
 * 提示：
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
public class ProfitV {
    public int maxProfit(int[] prices) {
        /**
         * 1. 定义：dp[i][j] 第i天不同状态j下的现金
         * j有4中状态：
         *  1）状态一：达到买入股票状态 j=0
         *  2）不持有股票状态：包括两个：
         *      A： 状态二： 今天卖出股票  j=1
         *      B： 状态三：两天前就卖出了股票，度过了冷冻期，保持不持有股票状态 j = 2
         *  3）状态四： 冷冻期状态，只能有一天 j=3
         */
        int[][] dp = new int[prices.length][4];

        /**
         * 2。 推动公式
         *  1） 状态一：达到买入状态下，今天有两个操作
         *      A: 操作1： 一直持有股票（状态2）  dp[i][0] = dp[i-1][0]
         *      B: 操作2：
         *          a：前一天冷冻期后，今天可以购买（状态四）： dp[i][0] = dp[i-1][3] - prices[i]
         *          b：前一天就一直为卖出状态（状态二, 今天购买： dp[i][0] = dp[i-1][2] - prices[i]
         *          所以： max(dp[i-1][3] - prices[i], dp[i-1][2] - prices[i])
         *      所以： dp[i][0] = max(dp[i-1][0], max(dp[i-1][3] - prices[i], dp[i-1][2] - prices[i]))
         *  2)  状态二：今天卖出状态，只有一种情况： 就是昨天已经过了冷冻期，直接卖出： dp[i][1] = dp[i-1][0] + prices[i]
         *  3)  状态三； 已经过了冷冻期，可以卖出状态股票了
         *      A： 操作1： 前一天就是卖出状态： dp[i][2] = dp[i-1][2]
         *      B: 操作2： 前一天为冷冻期 dp[i][1] = dp[i-1][3]
         *      所以： dp[i][2] = max(dp[i-1][2], dp[i-1][3])
         *  4） 状态四： 为冷冻期，只有一个状态，前一天把股票卖了： dp[i][3] = dp[i-1][1]
         *
         *  3. 初始化： 第一天时买入股票现金为负，其他都为0
         */
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i-1][2] - prices[i]));
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            dp[i][3] = dp[i - 1][1];
        }

        return Math.max(dp[prices.length - 1][3], Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]));
    }
}
