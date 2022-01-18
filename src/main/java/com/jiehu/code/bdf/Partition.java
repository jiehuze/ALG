package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class Partition {
    List<List<String>> lists = new ArrayList<>();

    /**
     * 回溯法，
     * 第一种方式（过渡方法）：使用回溯法，构建隐式树结构，每次移动都判断下是不是回文数，判断会导致时间复杂度比较高
     * <p>
     * 第二种方式：先进行回文数的比较，减小时间复杂度
     * 第一步：先将所有的回文串标记出来，使用归纳法
     * 第二步：使用回溯法，一棵隐式树结构，将不是回文串的进行剪枝，最终得到的就是最终的结果
     */
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len]; //记录left->right是不是回文串
        ArrayList<String> list = new ArrayList<>();
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        dfs(s, len, 0, dp, list);

        return lists;
    }

    /**
     * 标准的回溯算法
     */
    public void dfs(String s, int len, int index, boolean[][] dp, ArrayList<String> list) {
        if (index == len) {
            lists.add(new ArrayList<>(list));
            return;
        }

        //逐级往后推移
        for (int i = index; i < len; i++) {
            //判断是不是回文串，不是直接剪枝跳过
            if (dp[index][i]) {
                list.add(s.substring(index, i + 1));
                dfs(s, len, i + 1, dp, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
