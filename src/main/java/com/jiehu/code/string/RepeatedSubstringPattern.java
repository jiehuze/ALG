package com.jiehu.code.string;

import java.util.Arrays;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }


    /**
     * 利用KMP算法，比暴力算法要更优化：使用next存储最长前缀结尾字符下标，
     * 重复字符串为：len-next[len-1]-1
     */
    public boolean kmp(String s) {
        int len = s.length();
        int[] next = new int[len];

        //全部填充为-1
        Arrays.fill(next, -1);
        for (int i = 1; i < len; i++) {
            int j = next[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = next[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                next[i] = j + 1;
            }
        }

        return next[len - 1] != -1 && len % len - next[len - 1] - 1 == 0;
    }


}




































