package com.jiehu.code.dp.base;

/**
 * 62. 不同路径
 * https://leetcode.cn/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        /**
         * 1。 定义dp[i][j]到达 第i,j格子需要的路径和
         * 2。推导公式：
         * 状态：由两个方向而来：
         * 从上往下： dp[i][j] = dp[i-1][j]
         * 从左向右： dp[i][j] = dp[i][j-1]
         * 所以从两个方向来的总和为：dp[i][j] = dp[i-1][j] + dp[i][j-1]
         * 3. 初始化，因为路径只能从左到右，从上到下，所以第一行和第一列只有一种路径
         * 4. 遍历顺序， 从第二行第二列开始
         */
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}





























