package com.jiehu.code.StackAndQueue;

/**
 * 316. 去除重复字母    402，321，1081
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 */
public class DuplicateLetters {
    public String removeDuplicateLetters(String s) {

        //使用单调栈解决这个这个问题
        //先记录这个字符出现次数，如果出现次数为1，则为最后一个了，否则按照字典序进行栈操作，如果当前为s[i]>栈顶，说明是按照字典序，否则舍弃
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        //作为单调栈使用
        StringBuffer restBuf = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']--;
            //如果栈中已存在，则访问下一个字符，这一点很重要
            if (vis[s.charAt(i) - 'a']) continue;
            while (restBuf.length() != 0 && s.charAt(i) < restBuf.charAt(restBuf.length() - 1) && num[restBuf.charAt(restBuf.length() - 1) - 'a'] > 0) {
                vis[restBuf.charAt(restBuf.length() - 1) - 'a'] = false;
                restBuf.deleteCharAt(restBuf.length() - 1);
            }

            restBuf.append(s.charAt(i));
            vis[s.charAt(i) - 'a'] = true;

        }


        return restBuf.toString();
    }
}
