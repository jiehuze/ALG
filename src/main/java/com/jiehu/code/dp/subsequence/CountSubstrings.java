package com.jiehu.code.dp.subsequence;

/**
 * 647. 回文子串
 * https://leetcode.cn/problems/palindromic-substrings/
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 示例 1：
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * 提示：
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 */
public class CountSubstrings {
    /**
     * 1.动态规划法
     * 2。 中心扩展法
     */
    public int countSubstrings(String s) {
        /**
         * 1。 定义：dp[i][j]： 在范围[i, j]之间的字串是否为回文串，是：dp[i][j] = true，否则为 false
         */
        boolean[][] dp = new boolean[s.length()][s.length()];

        /**
         * 2。 推导公式： 分为两种状态：
         *    1） s[i] != s[j] 说明不是回文串  dp[i][j] = false
         *    2） s[i] == s[j]  有几种情况：
         *       A：下标i与j相同，肯定时回文串： dp[i][j] = true
         *       B: 下标i与j相差1，如aa, 也是回文串： dp[i][j] = true
         *       C: 下标i与j相差大于1，那么就需要判断 dp[i+1][j-1]为true时，dp[i][j] = true，否则为false
         *
         *  3. 初始化，默认单个都是false
         *  4. 因为推导公式中有；dp[i+1][j-1]，那么dp[i][j]就不是从左到右，从上到下的，而是从下到上，从左到右的；
         *      所有i的顺序应该时倒序的，j的顺序时正序的；
         *
         */

        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
