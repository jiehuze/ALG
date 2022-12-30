package com.jiehu.code.dp.subsequence;

/**
 * 392. 判断子序列
 * https://leetcode.cn/problems/is-subsequence/
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * 致谢：
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * 提示：
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 */
public class IsSubsequence {
    /**
     * 方法1： 动态规划
     */
    public boolean isSubsequence(String s, String t) {
        //1。 初始化dp[i], 在s下标为i时，是否时字串
        boolean[] dp = new boolean[s.length() + 1];

        /**
         * 2. 推导公式： 只有当s[i] == t[j],并且dp[i-1]为true，dp[i] 为true
         * 3. 初始化为false
         * 4） 从小到大遍历,外层为j顺序，内层为i顺序
         */
        int k = 0;
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = k; i < t.length(); i++) {
                if (s.charAt(j - 1) == t.charAt(i) && dp[j - 1] == true) {
                    k = i + 1;
                    dp[j] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    /**
     * 方法2： 双指针
     */
    public boolean isSubsequence2(String s, String t) {
        int m = s.length();
        int n = t.length();

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
            i++;
        }

        return m == j;
    }
}
