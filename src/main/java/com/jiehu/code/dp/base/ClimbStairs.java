package com.jiehu.code.dp.base;

/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 提示：
 * 1 <= n <= 45
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        //1。 定义dp[i], 爬到i层时，有多少种方法
        int[] dp = new int[n + 1];
        /**2。 递推公式
         两种状态：
         1. 跳一个台阶上来， dp[i] = dp[i-1]
         2. 跳两个台阶上来， dp[i] = dp[i-2]
         所以： dp[i] = dp[i-1] + dp[i-2]
         */
        /**
         * 3. 初始化，dp[0]和dp[1]
         */
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
