package com.jiehu.code.string;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 解题方式：
 * 1.使用游标的方式，标记开始和结束位置
 */
public class MaxStrLen {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        return maxStrLen(s);
    }

    public int maxStrLen(String s) {
        int max = 0;
        int start = 0, end = 0;
        char[] chars = s.toCharArray();
        for (end = 1; end < chars.length; end++) {
            max = Math.max(max, end - start);
            for (int i = start; i < end; i++) {
                if (chars[i] == chars[end]) {
                    start = i + 1;
                }
            }
        }
        max = Math.max(max, end - start);

        return max;
    }
}
