package com.jiehu.code.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 * https://leetcode-cn.com/problems/longest-palindrome/
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {
    /**
     * 贪心算法
     */
    public int longestPalindrome(String s) {
        return longestPalindrome1(s);
    }

    /**
     * 使用hash或者数组都可以,数组会更快
     * hash
     */
    public int longestPalindrome1(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            h.put(s.charAt(i), h.getOrDefault(s.charAt(i), 0) + 1);
        }

        int all = 0;
        for (Map.Entry<Character, Integer> entries : h.entrySet()) {
            Integer value = entries.getValue();
            all += value & 0xFFFE;

            if (value % 2 == 1 && all % 2 == 0) {
                all += 1;
            }
        }

        return all;
    }

    /**
     * 使用hash或者数组都可以,数组会更快
     * <p>
     * 数组方式
     */
    public int longestPalindrome2(String s) {
        int[] ints = new int[128];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)]++;
        }

        int all = 0;
        for (int v : ints) {

            all += v & 0xFFFE;

            if (v % 2 == 1 && all % 2 == 0) {
                all += 1;
            }
        }

        return all;
    }
}
