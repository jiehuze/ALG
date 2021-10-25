package com.jiehu.code.StackAndQueue;

import java.util.LinkedList;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 * 提示：
 * <p>
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 * <p>
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        //增加哨兵模式，防止栈为空，并且可以少判断
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;
        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            //当前高度小于栈顶高度是，需要出栈计算栈中的最大面积
            while (heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int weith = i - stack.peek() - 1;
                area = Math.max(area, height * weith);
            }
            stack.push(i);
        }

        return area;
    }
}
