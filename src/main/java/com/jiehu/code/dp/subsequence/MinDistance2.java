package com.jiehu.code.dp.subsequence;

/**
 * 72. 编辑距离
 * https://leetcode.cn/problems/edit-distance/
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 提示：
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
public class MinDistance2 {
    public int minDistance(String word1, String word2) {
        /**
         * 1。 定义dp[i][j], 在word1为i-1结尾 和 word2为下标j-1结尾时，最近距离为dp[i][j]
         */
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        /**
         * 2。 推导公式： 根据前面的规律，有两种状态：
         *    1） word1[i-1] == word2[j-1]
         *          那么就不需要进行任何操作： 所以： dp[i][j] = dp[i-1][j-1]
         *    2) 当不相等时：有几个步骤：
         *          操作A：对word1删除一个字符： dp[i][j] = dp[i-1][j] + 1
         *          操作B：对word2删除一个字符： dp[i][j] = dp[i][j-1] + 1
         *          操作C：替换一个字符，也就是当前word1[i-1]== word2[j-1], dp[i][j] = dp[i-1][j-1] + 1
         *         这里面为什么没有插入字符呢，因为插入一个字符，其实和删除相对应word的时相同的道理
         *        因为求最少距离：所以取三个操作的最小数： dp[i][j] = min(A, B, C)
         * 3. 初始化：
         *    1）当word1无字符时： dp[0][j] = j
         *    2) 当word2无字符时：dp[i][0] = i
         *  4. 遍历顺序： 因为时从左到右，从上到下，所以顺序不限
         */
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
