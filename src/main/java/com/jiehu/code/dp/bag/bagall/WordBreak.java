package com.jiehu.code.dp.bag.bagall;

import java.util.List;

/**
 * 139. 单词拆分
 * https://leetcode.cn/problems/word-break/
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 提示：
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * 分析： wordDirc中的元素即为物品，而s为背包中的容量，而wordDirc中的物品可以任意多个，所以是完全背包问题
         * 1。 dp[j] 含义： 容量为j的背包中是可以被wordDirc中单词组合
         */
        boolean[] dp = new boolean[s.length() + 1];
        /**
         * 2. 递推公式：
         *  分析： 如果dp[i]为true，那么dp[j-i]的单词在wordDirc中存在，才能保证dp[j]为true;
         * 3. 初始化：因为递推公式是从dp[0]递推过来的，所以必须保证dp[0]为true才可以；
         * 4。 顺序： 因为是排列问题，所以顺序为： 先背包在物品
         */
        dp[0] = true;

        for (int j = 0; j <= s.length(); j++) {
            for (String str : wordDict) {
                int len = str.length();
                if (j - len >= 0 && dp[j - len] && str.equals(s.substring(j - len, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
