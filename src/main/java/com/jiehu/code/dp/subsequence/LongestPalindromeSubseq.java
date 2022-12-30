package com.jiehu.code.dp.subsequence;

/**
 * 516. 最长回文子序列
 * https://leetcode.cn/problems/longest-palindromic-subsequence/
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        /**
         * 1。 定义： dp[i][j]，在区间【i， j】中，最大回文字串长度为dp[i][j]
         */
        int[][] dp = new int[s.length()][s.length()];

        /**
         * 2. 推导公式：两个状态
         *      1） s[i] == s[j] ： dp[i][j] = dp[i+1][j-1] + 2
         *      2)  s[i] != s[j] : 有分为几个操作：
         *          A：加入s[i]，回文字串的长度： dp[i][j] = dp[i][j-1]
         *          B: 加入s[j],回文字串的长度： dp[i][j] = dp[i+1][j]
         *        所以取最大值： dp[i][j] = max(A, B)
         *
         * 3. 初始化： 所以的单个字符都是长度为1，初始化为1
         * 4， 同样的由于推导公式中，有从下往上推导，所以遍历顺序为： i从后往前，j从前往后
         */

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }

        //返回值是：【0，len-1】的最大回文串数
        return dp[0][s.length() - 1];
    }
}
