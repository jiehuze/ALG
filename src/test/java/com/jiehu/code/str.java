package com.jiehu.code;

import com.jiehu.code.string.BracketNum;
import com.jiehu.code.string.LongestPalindrome;
import com.jiehu.code.string.Match;
import com.jiehu.code.string.MaxStrLen;

public class str {
    public static void main(String[] args) {
        /**
         * 测试1： 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
         */
        maxStrLen();

        /**
         * 测试2：给你一个字符串 s，找到 s 中最长的回文子串。
         */
        longestPalindrome();

        /**
         * 测试3： 正则匹配
         */
        isMatch();

        /**
         * 测试4： 括号匹配，输出组合
         */
        bracketnum();
    }

    public static void maxStrLen() {
        String s = "ddddd";

        MaxStrLen maxStrLen = new MaxStrLen();
        int maxLen = maxStrLen.lengthOfLongestSubstring(s);
        System.out.println(maxLen);
    }

    public static void longestPalindrome() {
        String s = "bbb";

        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String rest = longestPalindrome.longestPalindrome(s);
        System.out.println(rest);
    }

    public static void isMatch() {

        String s = "abacb";
        String p = "*a?cb";
        Match match = new Match();
        boolean ismatch = match.isMatch(s, p);
        System.out.println(ismatch);

    }

    public static void bracketnum(){
        BracketNum bracketNum = new BracketNum();

        System.out.println(bracketNum.bracketNum(2));

    }
}
