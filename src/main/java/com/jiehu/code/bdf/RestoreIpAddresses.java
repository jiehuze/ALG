package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/submissions/
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> lists = new ArrayList<>();

        dfs(s, s.length(), 0, 0, "", lists);

        return lists;
    }

    public void dfs(String s, int len, int index, int num, String combination, ArrayList<String> lists) {
        if (index == len) {
            if (num == 4)
                lists.add(combination.substring(0, combination.length() - 1));
            return;
        }

        for (int i = index; i < len; i++) {
            String tmp = combination + s.substring(index, i + 1) + ".";
            String[] sp = tmp.split("\\.");
            if (!isDigits(sp[sp.length - 1])) {
                break;
            }
            int tn = num + 1;
            if (tn == 3 && i + 1 < len) {
                if (!isDigits(s.substring(i + 1, len)))
                    continue;
            }
            if (tn > 4) break;

            dfs(s, len, i + 1, tn, tmp, lists);
        }
    }

    //判断是不是合肥的整数，不包含前导0
    public boolean isDigits(String s) {
        if (s.length() > 1 && s.charAt(0) == '0' || s.length() > 3) return false;

        Integer digits = Integer.valueOf(s);

        if (digits >= 0 && digits <= 255)
            return true;
        else
            return false;
    }
}
