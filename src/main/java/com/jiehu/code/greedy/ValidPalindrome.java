package com.jiehu.code.greedy;

/**
 * 680. 验证回文字符串 Ⅱ
 * https://leetcode-cn.com/problems/valid-palindrome-ii/submissions/
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1:
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * 示例 3:
 * 输入: s = "abc"
 * 输出: false
 */
public class ValidPalindrome {
    /**
     * 贪心算法，使用左右指针，移动的方式，
     */
    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, false);
    }

    public boolean valid(String s, int start, int end, boolean isDeep) {
        while (start < end) {
            int a = s.charAt(start);
            int b = s.charAt(end);
            if (a != b) {
                if (isDeep) return false;

                //往右走，和往左走
                return valid(s, start + 1, end, true) || valid(s, start, end - 1, true);
            }

            start++;
            end--;
        }

        return true;
    }
}
