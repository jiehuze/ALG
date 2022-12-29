package com.jiehu.code.dp.profit;

/**
 * 188. 买卖股票的最佳时机 IV
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1：
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * 提示：
 * 0 <= k <= 100
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 */
public class ProfitIV {
    /**
     * 这个就是股票3的升级版本，将交易次数规定为K次，而股票3中的2次其实就是其中的一个子类
     * 分析： 股票无非就是由几个状态：
     * 1）不操作
     * 2）买入
     * 3）卖出
     * 所以我们只需要定义基数为买入， 偶数为卖出，最后的卖出次数不超过K即可
     */
    public int maxProfit(int k, int[] prices) {
        /**
         * 1。 定义： dp[i][j]; 含义： 在第 i 天 状态为j时的最大现金数
         */
        int[][] dp = new int[prices.length][2 * k + 1];
        /**
         * 2. 递推公式：
         *  1) j为基数时（持有股票），可以由两种状态
         *      A： 在i-1 天时持有股票，i也持有股票： dp[i][j] = dp[i-1][j]
         *      B: 在 i-1 天时不持有股票，i买入股票： dp[i][j] = dp[i-1][j-1] - prices[i]
         *      所有： dp[i][j] = max( dp[i-1][j], dp[i-1][j-1] - prices[i])
         *  2) j为偶数时 （不持有股票），可以由两种状态
         *      A: 在 i-1 天时持有股票，i天卖出股票： dp[i][j] = dp[i-1][j-1] + prices[i]
         *      B：在 i-1 天时不持有股票，j天同样不持有股票： dp[i][j] = dp[i-1][j]
         *      所以： dp[i][j] = max( dp[i-1][j-1] + prices[i], dp[i-1][j])
         *
         *  3. 初始化： 基数时为第一天卖出的数
         *  4： 遍历： 从1开始，从小到大遍历
         */

        for (int j = 1; j <= 2 * k; j += 2) {
            dp[0][j] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2 * k; j += 2) {
                //j为基数
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                //即为偶数
                dp[i][j + 1] = Math.max(dp[i - 1][j] + prices[i], dp[i - 1][j + 1]);
            }
        }

        return dp[prices.length - 1][2 * k];
    }
}
