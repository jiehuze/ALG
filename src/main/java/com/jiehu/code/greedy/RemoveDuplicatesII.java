package com.jiehu.code.greedy;

/**
 * 1209. 删除字符串中的所有相邻重复项 II
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 * 在执行完所有删除操作后，返回最终得到的字符串。
 * 本题答案保证唯一。
 * 示例 1：
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * 示例 2：
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 * 示例 3：
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 */
public class RemoveDuplicatesII {
    /**
     * 利用数组存储字符，但是时间复杂比较高，因为需要第二次循环
     */
    public String removeDuplicates(String s, int k) {
        char[] chars = new char[s.length()];
        int c = -1;

        for (int i = 0; i < s.length(); i++) {
            chars[++c] = s.charAt(i);
            if (c >= k - 1) {
                int t = c;
                while (t >= 0) {
                    if (chars[t] == s.charAt(i)) {
                        t--;
                    } else {
                        break;
                    }
                    if (c - t == k) {
                        c = t;
                        break;
                    }
                }
            }
        }

        return new String(chars, 0, c + 1);
    }

    /**
     * 数组方式：结合方法一，使用计数数组,方法很巧妙，避免了二次循环
     */
    public String removeDuplicates2(String s, int k) {
        StringBuffer sb = new StringBuffer(s);
        int[] counts = new int[s.length()];

        //只记录最后一个值的连续个数
        int num = 1;
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts[i] = 1;
            } else {
                if (sb.charAt(i) == sb.charAt(i - 1)) {
                    counts[i] = counts[i - 1] + 1;
                }

                if (counts[i] == k) {
                    //左闭又开
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }

        return sb.toString();
    }
}
