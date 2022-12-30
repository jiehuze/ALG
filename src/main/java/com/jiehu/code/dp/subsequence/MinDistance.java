package com.jiehu.code.dp.subsequence;

/**
 * 583. 两个字符串的删除操作
 * https://leetcode.cn/problems/delete-operation-for-two-strings/
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 * 示例 1：
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * 示例  2:
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 * 提示：
 * 1 <= word1.length, word2.length <= 500
 * word1 和 word2 只包含小写英文字母
 */
public class MinDistance {
    /**
     * 1. 动态规划方式：
     * 2。 可以使用1143中最长公告字串方式，最后用 word1.len + word2.len - 2*lcs(最长公共字串)
     */
    public int minDistance(String word1, String word2) {
        /**
         * 1. 定义dp[i][j], 以i-1为结尾的word1，和以j-1为结尾的word2想要达到相等，最少要删除元素的最小步数
         */
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        /**
         * 2. 推导公式：还是两种状态
         *   1）word1[i-1] == word2[j-1] : 相等就合上一个相等,不用删除： dp[i][j] = dp[i-1][j-1]
         *   2) word1[i-1] != word2[j-1]
         *      A： 删除 word1中的i-1： dp[i][j] = dp[i-1][j] + 1
         *      B: 删除 word2中的j-1， dp[i][j] = dp[i][j-1] + 1
         *      C: 同时删除word1和word2中的i-1和j-1： dp[i][j] = dp[i-1][j-1] + 2
         *      所以取A，B，C中的最小的数；
         *      因为 C可以被剔除，所以计算A，B的最小值即可
         * 3。 初始化：
         *    1）当word1没有，那么word2对于的dp[0][j]就是对应的j个步数
         *    2）当word2没有，那么word1对应的dp[i][0]就是对应的i个步数
         * 4. 循环：
         *     因为都从左到右，从上到下，所以内层和外层，遍历那个都可以
         */
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }

        return dp[word1.length()][word2.length()];

    }
}
