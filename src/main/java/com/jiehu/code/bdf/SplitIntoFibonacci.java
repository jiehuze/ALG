package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * 示例 1：
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 */
public class SplitIntoFibonacci {
    //标准的回溯算法+剪枝
    public List<Integer> splitIntoFibonacci(String num) {
        ArrayList<Integer> list = new ArrayList<>();

        dfs(num.toCharArray(), list, 0);

        return list;
    }

    public boolean dfs(char[] ch, ArrayList<Integer> list, int index) {
        if (index == ch.length && list.size() >= 3) {
            return true;
        }

        for (int i = index; i < ch.length; i++) {
            //先判断如果数字第一个字符是0的话跳过
            if (ch[index] == '0' && i > index) {
                break;
            }

            long num = subDigit(ch, index, i + 1);
            //如果截取的数字大于int的最大值，则终止截取
            if (num > Integer.MAX_VALUE) {
                break;
            }

            int size = list.size();
            //按照斐波那契数列要求，当前数=上一个数+上上一个数，如果这两个数<当前数，说明这个数超出了，不能再往下继续了
            if (size >= 2 && list.get(size - 2) + list.get(size - 1) < num) {
                break;
            }

            if (size <= 1 || num == list.get(size - 2) + list.get(size - 1)) {
                //将数字写入list
                list.add((int) num);
                //如果找到了就直接返回
                if (dfs(ch, list, i + 1)) {
                    return true;
                }

                //如果没有找到，就回溯到上一个
                list.remove(list.size() - 1);
            }
        }

        return false;
    }

    public long subDigit(char[] ch, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + ch[i] - '0';
        }

        return res;
    }
}
