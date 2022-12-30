package com.jiehu.code.dp.subsequence;

/**
 * 1143. 最长公共子序列 与1035 不相交的线  是一样的
 * https://leetcode.cn/problems/longest-common-subsequence/
 * https://leetcode.cn/problems/uncrossed-lines/
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * 提示：
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 */
public class LongestCommonSubsequence {
    /**
     * 1. 动态规划，不连续字串
     * 但效率不高
     */
    public int longestCommonSubsequence(String text1, String text2) {
        /**
         * 1。 dp[i][j] 第i行j列格的最长公告子序列
         */
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        /**
         * 2. 推导公式：
         * *                     a   c    e
         *          *   ----------------------
         *          *    |   0   0   0    0         1     1
         *          *  a |   0   1   1    1         ｜ \  ｜
         *          *  b |   0   1   1    1         ｜  \ ｜
         *          *  c |   0   1   2    2         ｜  _\/
         *          *  d |   0   1   2    2         1     2
         *          *  e |   0   1   2    3
         *          *   ----------------------
         *   分析： 到dp[i][j]有两种情况，
         *   1） text1[i-1] == text2[j-1] dp[i][j] 由左上对角+1得来； dp[i][j] = dp[i-1][j-1] + 1
         *   2)  text1[i-1] != text2[j-1] dp[i][j]从两个方向推导而来：
         *      A：左侧： dp[i][j] = dp[i][j-1]
         *      B: 上边： dp[i][j] = dp[i-1][j]
         *      所以： dp[i][j] = max(dp[i][j-1], dp[i-1][j])
         *
         *  3. 初始化： 都为0即可
         *  4。 遍历顺序，因为只有从左到右从上到下顺序推导而来，所以只能是从小到大遍历
         */

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
