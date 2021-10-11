package com.jiehu.code.string;

import java.util.ArrayList;

/**
 * 345. 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * <p>
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出："leotcede"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由 可打印的 ASCII 字符组成
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    indexList.add(i);
            }
        }

        int left = 0, right = indexList.size();
        char[] ss = s.toCharArray();
        while (left <= right) {
            char tmp = ss[indexList.get(left)];
            ss[indexList.get(left)] = ss[indexList.get(right)];
            ss[indexList.get(right)] = tmp;
            left++;
            right--;
        }

        return String.valueOf(ss);
    }

}




























