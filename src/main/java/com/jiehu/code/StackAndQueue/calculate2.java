package com.jiehu.code.StackAndQueue;

import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *  
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */
public class calculate2 {
    /**
     * 栈方法：
     * 加号：将数字压入栈；
     * 减号：将数字的相反数压入栈；
     * 乘除号：计算数字与栈顶元素，并将栈顶元素替换为计算结果。
     * 最后计算栈中的数据
     */
    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int num = 0;
        //保存上一个符号，遇到下一个数字时，按照规则操作入栈
        Character presign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            char c = s.charAt(i);
            //这个判断一定要注意
            if (!Character.isDigit(s.charAt(i)) && c != ' ' || i == s.length() - 1) {
                switch (presign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                }

                presign = c;
                num = 0;
            }
        }

        int sum = 0;
        for (int n : stack) {
            sum += n;
        }

        return sum;
    }
}
