package com.jiehu.code.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 670. 最大交换
 * https://leetcode-cn.com/problems/maximum-swap/
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 示例 1 :
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 */
public class MaximumSwap {
    //使用最大堆的贪心算法
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int[] ints = new int[s.length()];

        //保存数字和数组下标
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //以最大数排序，当数相同是以最大下标排序
                return o2[0] - o1[0] != 0 ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; num != 0; i++) {
            ints[s.length() - 1 - i] = num % 10;
            int[] ind = new int[]{num % 10, s.length() - 1 - i};
            queue.offer(ind);
            num /= 10;
        }

        for (int i = 0; i < s.length(); i++) {
            int[] tt = queue.peek();

            //说明已经跳过去，丢弃掉，比较后面的最大值
            while (!queue.isEmpty() && queue.peek()[1] <= i) {
                int[] pp = queue.peek();
                queue.poll();
            }

            if (!queue.isEmpty() && queue.peek()[0] > ints[i]) {
                //下标
                int index = queue.peek()[1];
                int tmp = ints[i];
                ints[i] = ints[index];
                ints[index] = tmp;
                break;
            }
        }

        int rs = 0;
        for (int i = 0; i < ints.length; i++) {
            rs = rs * 10 + ints[i];
        }

        return rs;
    }
}





























