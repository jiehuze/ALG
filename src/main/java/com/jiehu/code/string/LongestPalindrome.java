package com.jiehu.code.string;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        return func(s);
    }

    /**
     * 方法1： 暴力法
     */
    public String func(String s) {

        String res = s.substring(0, 1);

        char[] chars = s.toCharArray();
        //游标方式
        int start = 0, end = 1;
        int max = 0;

        for (start = 0; start < s.length(); start++) {
            for (end = s.length() - 1; end >= start; end--) {
                for (int i = 0; i <= (end - start) / 2; i++) {
                    if (chars[start + i] != chars[end - i]) {
                        break;
                    }
                    if (i == (end - start) / 2) {
                        if (max < end - start) {
                            res = s.substring(start, end + 1);
                            max = end - start;
                        }
                    }
                }
            }
        }

        return res;
    }

    /**
     * 方法2： 中心扩散法，效率更高
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 寻找长度为奇数的回文子串(以当前元素向两边扩散)
            int len1 = expandAroundCenter(s, i, i);
            // 寻找长度为偶数的回文子串(以s[i],s[i + 1])向两边扩散
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 向两边扩算
     */
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
