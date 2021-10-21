package com.jiehu.code.StackAndQueue;

import java.util.LinkedList;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */
public class Trap {
    public int trap(int[] height) {
        return trapByStack(height);
    }

    /**
     * 方法一：单调栈算法，
     * 2ms
     */
    public int trapByStack(int[] height) {
        int sum = 0;
        //单调递减栈，存储数组下标
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                //计算宽和高，高度要获取最低的，这样水是从这个方向流出去的
                int heigh = Math.min(height[left], height[i]) - height[top];
                int width = i - left - 1;

                sum += heigh * width;
            }
            stack.push(i);
        }

        return sum;
    }

    /**
     * 方法二：使用双指针方式
     * 0ms
     */
    public int trapByPoint(int[] height) {
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        int ans = 0;

        while (left < right) {
            //向右走
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    ans += leftMax - height[left];
                }
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                if (height[right] < rightMax) {
                    ans += rightMax - height[right];
                }
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }

        return ans;
    }
}
