package com.jiehu.code.bdf;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 45. 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class Jump {
    public int min = Integer.MAX_VALUE;

    public int jump(int[] matrix) {
        ArrayList<Integer> path = new ArrayList<>();

        dfs(matrix, 0, path);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //深度扫描
    public void dfs(int[] matrix, int index, ArrayList<Integer> path) {
        if (index == matrix.length - 1) {
            min = Math.min(min, path.size());
            return;
        }

        for (int i = 1; i < matrix[index]; i++) {
            if (index + i >= matrix.length) continue;
            path.add(i);
            dfs(matrix, index + i, path);
            path.remove(path.size() - 1); //加了，退出时，必须remove
        }
    }

    //bfs 广度搜索

    /**
     * 数组：2，1，1，3，1，4
     * 一层：2             level = 0，queue存储下次层数据+上条数
     * 二层：1，1           level = 1，
     * 三层：1，3           level = 2，
     * 四层：3，1，4
     * 五层：1，4
     */
    public int bfs(int[] matrix) {
        if (matrix.length <= 1) return 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(0); //向第一个队列中写入0
        int level = 0; //跳的层级，也就是跳的步数，最少的
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int jumpIndex = deque.poll(); //matirx的下标
                if (jumpIndex == matrix.length - 1) return level;
                for (int j = 1; j <= matrix[jumpIndex]; j++) {//将要的跳跃步数对应的下标，如3： 1+3+jumpindex，2+3+jumpindex，3+3+jumpindex
                    deque.offer(jumpIndex + j); //将下一层的标记写入到queue中
                }
            }
            level++;
        }
        return 0;
    }


    /**
     * 贪心算法：
     */
    public int jumptanxin(int[] matrix) {
        int start = 0, end = 0, steps = 0;
        int maxPos = 0;

        //第一种
//        while (end < matrix.length) {
//            int maxPos = 0;
//            for (int i = start; i <= end; i++) {
//                maxPos = Math.max(matrix[i], maxPos);
//            }
//            start = end + 1;
//            end = maxPos;
//            steps++;
//        }

        //第二钟优化
        for (int i = 0; i < matrix.length - 1; i++) {
            maxPos = Math.max(matrix[i] + i, maxPos);
            if (i == end) {
                steps++;
                end = maxPos;
            }
        }

        return steps;
    }
}
