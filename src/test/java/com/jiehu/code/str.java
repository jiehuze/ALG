package com.jiehu.code;

import com.jiehu.code.string.*;

public class str {
    public static void main(String[] args) {
        /**
         * 测试1： 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
         */
//        maxStrLen();

        /**
         * 测试2：给你一个字符串 s，找到 s 中最长的回文子串。
         */
//        longestPalindrome();

        /**
         * 测试3： 正则匹配
         */
//        isMatch();

        /**
         * 测试4： 括号匹配，输出组合
         */
//        bracketnum();

        /**
         * 测试5：校验是否为utf8
         */
//        validUtf8();

        /**
         * 测试6；检查版本号
         */
//        compareVersion();

        /**
         * 测试7： z字型输出
         */
        convertZ();
    }

    public static void convertZ() {
        String s = "PAYPALISHIRING";
        int n = 3;
        ConvertZ convertZ = new ConvertZ();
        System.out.println(convertZ.convert(s, 3));
    }

    public static void compareVersion() {
        String v1 = "0.1";
        String v2 = "1.1";
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compareVersion(v1, v2));
    }

    public static void validUtf8() {
//        int[] data = {194,155,231,184,185,246,176,131,161,222,174,227,162,134,241,154,168,185,218,178,229,187,139,246,178,187,139,204,146,225,148,179,245,139,172,134,193,156,233,131,154,240,166,188,190,216,150,230,145,144,240,167,140,163,221,190,238,168,139,241,154,159,164,199,170,224,173,140,244,182,143,134,206,181,227,172,141,241,146,159,170,202,134,230,142,163,244,172,140,191};
//        int[] data = {145};
        int[] data = {115, 100, 102, 231, 154, 132, 13, 10};
        ValidUtf8 validUtf8 = new ValidUtf8();
        System.out.println(validUtf8.validUtf8(data));

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

    public static void bracketnum() {
        BracketNum bracketNum = new BracketNum();

        System.out.println(bracketNum.bracketNum(2));

    }
}
