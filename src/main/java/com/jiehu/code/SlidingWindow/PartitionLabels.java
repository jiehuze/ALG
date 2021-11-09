package com.jiehu.code.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间 *****
 * https://leetcode-cn.com/problems/partition-labels/submissions/
 * 华为、美团、携程、字节
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个
 * 字符串片段的长度的列表。
 * 示例：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class PartitionLabels {
    /**
     * 方法一：滑动窗口的方式,贪心算法
     * 1. 将所有字符的最大下标保存在字符数组中
     * 2。 根据窗口的方式判断当前的字符串的长度
     */
    public List<Integer> partitionLabels(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] = i;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //end问最大的下标
            end = Math.max(end, chars[s.charAt(i) - 'a']);
            //如果长度正好等于i的话，说明是一个滑动窗口
            if (end == i) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }

        return ans;
    }

}
