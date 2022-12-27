package com.jiehu.code.dp.bag.bag01;

/**
 * 1049. 最后一块石头的重量 II
 * https://leetcode.cn/problems/last-stone-weight-ii/
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * 示例 1：
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
public class LastStoneWeightII {
    /**
     * 二维数组方式计算
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        int target = sum / 2;
        return dp1(stones, sum, target);
    }

    public int dp1(int[] stones, int sum, int target) {
        //1. 定义dp[i][j],遍历到第i个石头背包容量为j时，最多可以被多种的重量
        //数组长度为总石头重量的一半，不大于一半，最后输出的为dp[target]的最大重量
        int[][] dp = new int[stones.length][target + 1];

        /**2。 递推公式：状态：
         *  1） 不粉碎： dp[i][j] = dp[i-1][j]
         *  2) 粉碎： dp[i][j] = dp[i-1][j-stones[i]] + stones[i]
         *  最终的结果时：取1）和2）的最大值
         */
        /**
         * 3。 初始化dp数组,无物品时最大重量
         */
        for (int i = 0; i <= target; i++) {
            dp[0][i] = stones[0];
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= stones[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return sum - 2 * dp[stones.length - 1][target];
    }

    public int dp2(int[] stones, int sum, int target) {
        //1. 定义dp[j],背包容量为j时，最多可以被多种的重量
        //数组长度为总石头重量的一半，不大于一半，最后输出的为dp[target]的最大重量
        int[] dp = new int[target + 1];
        /**
         * 2。 推导公式：根据状态，
         *  1） 放 dp[j] = dp[j-stones[i]] + stones[i]
         *  2）不放： dp[j] = dp[j]
         *  所以取最大： dp[j] = max(dp[j], dp[j-stones[i]] + stones[i])
         */
        //3。 初始化dp数组，为0

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) { //背包， 01背包，从大到小遍历
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[target];
    }


}
