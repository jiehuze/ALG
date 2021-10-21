package com.jiehu.code.StackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class DailyTemperatures {

    //单调栈方法
    public int[] dailyTemperatures(int[] temperatures) {
        int[] rets = new int[temperatures.length];
        //默认是0，可以不用加这句话
        Arrays.fill(rets, 0);
        //定义单调递减栈，存储数组下标
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer p = stack.pop();
                rets[p] = i - p;
            }
            stack.push(i);
        }

        return rets;
    }
}
