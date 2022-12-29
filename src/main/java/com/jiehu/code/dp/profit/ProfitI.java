package com.jiehu.code.dp.profit;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 提示：
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class ProfitI {
    /**
     * 分析： 这个是只能买一次股票的方式，所以我们可以设定在某个下标下持有股票所得的现金
     * 持有：不代表当天就购买，也可能时之前购买，所以对于当天有两种状态：买或者没买
     * 这种方式不是最优解，最好使用贪心算法，算出左边最小或右边最大的数
     */
    public int maxProfit(int[] prices) {
        /**
         * 1. dp[i][j] : i为在下标为i时，有两种j，0为持有股票，1为不持有股票情况下的现金
         */
        int[][] dp = new int[prices.length][2];

        /**
         * 2。 递推公式： 两种状态：
         *  1）持有股票：由两种状态推导而来：
         *      A：第i-1天不持有股票，那就是第i天买了股票，所以： dp[i][0] = -prices[i]
         *      B：第i-1天也持有股票，那么就和前一天相同： dp[i-1][0]
         *      所以： dp[i][0] = max(dp[i-1][0], -prices[i])
         *  2) 不持有股票： 也有两个状态推导而来
         *      A: 第i-1天不持有股票，那就是相同： dp[i][1] = dp[i-1][1]
         *      B: 第i-1天持有股票,那么第i天就需要卖掉股票： dp[i][1] = dp[i-1][0] + prices[i]
         *      所以： dp[i][1] = max(dp[i-1][1], dp[i-1][0]+prices[i])
         *
         *  3. 初始化：
         *      第一天持有股票： dp[0][0] = -price[0]
         *      第一天不持有股票： dp[0][1] = 0
         */
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        //返回最后一天不持有股票时的总现金数
        return dp[prices.length - 1][1];
    }

    /**
     * 贪心算法： 算出左边最小或右边最大的数
     */
    public int maxProfit2(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            result = Math.max(result, prices[i] - low); //取差值最大的数
        }

        return result;
    }
}























