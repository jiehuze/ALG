package com.jiehu.code.dp.base;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode.cn/problems/unique-binary-search-trees/
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 */
public class NumTrees {
    public int numTrees(int n) {
        //1。 定义dp[i], 含义：为i时的dp种数
        int[] dp = new int[n + 1];

        /**
         *2。 推导公式，因为是树，所以分为左右子树，通过规律可以看到
         * 比如n =3
         * 1）当根为1时， 左子树为0个元素搜索树数 * 右子树为 2 个元素的搜索树数
         * 2）当根为2时， 左子树为1个元素搜索树数 * 右子树为 1 个元素的搜索树数
         * 3）当根为3时， 左子树为2个元素搜索树数 * 右子树为 0 个元素的搜索树数
         * 所以dp[3] = dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0]
         *
         * 递推公式：当根节点为j时， 左子树为 j-1个元素搜索树数 * 右子树为 i-j个元素的搜索树数 递推到i，做累加
         * dp[i] += dp[j-1] * dp[i-j]
         */
        /**
         * 3. 初始化dp公式，dp[0] = 1
         * 4. 遍历数序，i从1开始，j从1开始
         */
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}































