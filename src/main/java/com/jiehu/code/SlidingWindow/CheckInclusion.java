package com.jiehu.code.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 字节、迅雷、阿里
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        return checkInclusion2(s1, s2);
    }

    /**
     * 滑动窗口方式，并使用hash保存字符
     * 使用hash方式，效率不是很高，每次都需要进行hash比较
     */
    public boolean checkInclusion1(String s1, String s2) {
        //用来存储s1的字符和个数,或者用字符数组
        HashMap<Character, Integer> thash = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            thash.put(s1.charAt(i), thash.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int left = 0, right = left + s1.length(); right <= s2.length(); left++, right++) {
            if (check(thash, s2.substring(left, right)))
                return true;
        }

        return false;
    }

    public boolean check(HashMap<Character, Integer> thash, String sub) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < sub.length(); i++) {
            hash.put(sub.charAt(i), hash.getOrDefault(sub.charAt(i), 0) + 1);
        }
        if (thash.equals(hash))
            return true;
        else
            return false;

    }

    /**
     * 方法二：数组方式存储,
     * 这个太快了，比第一种方式
     */
    public boolean checkInclusion2(String s1, String s2) {
        //用来存储s1的字符和个数,或者用字符数组
        int[] cnt1 = new int[128];
        int[] cnt2 = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i)]++;
        }

        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (cnt1[s2.charAt(i)] > 0) {
                cnt2[s2.charAt(i)]++;
            }
            if (i - left + 1 == s1.length()) {
                if (Arrays.equals(cnt1, cnt2))
                    return true;

                if (cnt1[s2.charAt(left)] > 0) {
                    cnt2[s2.charAt(left)]--;
                }
                left++;
            }
        }

        return false;
    }

}





































