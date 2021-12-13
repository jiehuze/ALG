package com.jiehu.code.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 767. 重构字符串
 * https://leetcode-cn.com/problems/reorganize-string/
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class ReorganizeString {
    //解法说明： https://leetcode-cn.com/problems/reorganize-string/solution/zhong-gou-zi-fu-chuan-by-leetcode-solution/
    //计数法要比堆的贪心算法性能高

    /**
     * 基于堆的贪心算法
     * 该堆为priorityQueue
     */
    public String reorganizeString(String s) {
        int maxCount = Integer.MIN_VALUE;
        if (s.length() < 2) return s;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            maxCount = Math.max(counts[s.charAt(i) - 'a'], maxCount);
        }

        //如果maxcount的个数 > len+1/2,说明肯定会重复
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }

        //构建最大堆
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2 - 'a'] - counts[o1 - 'a'];
            }
        });
        //写入堆中
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }

        StringBuffer buf = new StringBuffer();
        //开始拼接字符串,将头部的两个最大字符取出拼接，一次类推
        while (queue.size() > 1) {
            Character l1 = queue.poll();
            Character l2 = queue.poll();
            buf.append(l1);
            buf.append(l2);
            counts[l1 - 'a']--;
            counts[l2 - 'a']--;

            if (counts[l1 - 'a'] > 0) {
                queue.offer(l1);
            }

            if (counts[l2 - 'a'] > 0) {
                queue.offer(l2);
            }
        }

        if (queue.size() > 0) {
            buf.append(queue.poll());
        }

        return buf.toString();
    }

    /**
     * 基于计数的贪心算法
     */
    public String reorganizeString2(String s) {
        int length = s.length();
        int maxCount = Integer.MIN_VALUE;
        if (s.length() < 2) return s;
        int[] counts = new int[26];
        for (int i = 0; i < length; i++) {
            counts[s.charAt(i) - 'a']++;
            maxCount = Math.max(counts[s.charAt(i) - 'a'], maxCount);
        }

        //如果maxcount的个数 > len+1/2,说明肯定会重复
        if (maxCount > (length + 1) / 2) {
            return "";
        }

        char[] reorganizeArray = new char[length];
        //偶数下标
        int evenIndex = 0;
        //奇数下标
        int oddIndex = 1;
        int halfLength = length / 2;

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            //先往奇数下标上写
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                counts[i]--;
                reorganizeArray[oddIndex] = c;
                oddIndex += 2;
            }

            while (counts[i] > 0) {
                counts[i]--;
                reorganizeArray[evenIndex] = c;
                evenIndex += 2;
            }
        }

        return new String(reorganizeArray);
    }
}
