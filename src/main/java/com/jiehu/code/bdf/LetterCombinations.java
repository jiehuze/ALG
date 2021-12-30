package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */

public class LetterCombinations {
    private Character[][] CH = new Character[][]{{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        ArrayList<String> lists = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

//        dfs(digits, digits.length(), 0, sb, lists);
        dfs2(digits, digits.length(), 0, "", lists);

        return lists;
    }

    /**
     * 回溯算法
     */
    public void dfs(String digits, int len, int dep, StringBuffer sb, ArrayList<String> lists) {
        if (dep > len || len == 0) return;
        if (dep == len) {
            lists.add(new String(sb));
            return;
        }

        int digit = digits.charAt(dep) - '0';
        int l = CH[digit].length;
        for (int j = 0; j < l; j++) {
            sb.append(CH[digit][j]);
            dfs(digits, len, dep + 1, sb, lists);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    /**
     * 回溯算法
     * 这个里面又一个可以优化，将第一个dfs中的stringbuffer修改为string，减少存储，放在临时遍历，就不需要回归时删除了
     */
    public void dfs2(String digits, int len, int dep, String combination, ArrayList<String> lists) {
        if (dep > len || len == 0) return;
        if (dep == len) {
            lists.add(combination);
            return;
        }

        int digit = digits.charAt(dep) - '0';
        int l = CH[digit].length;
        for (int j = 0; j < l; j++) {
            dfs2(digits, len, dep + 1, combination + Character.toString(CH[digit][j]), lists);
        }

    }
}
