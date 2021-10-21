package com.jiehu.code.StackAndQueue;

import java.util.LinkedList;

/**
 * 224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 */
public class Calculate {
    int ptr = 0;

    /**
     * 有时间详细研究一下 *******
     */
    public int dfs(String s) {
        //先计算结束
        if (ptr == s.length() || s.charAt(ptr) == ')') {
            return 0;
        }

        int ret = 0;
        int sum = 0;
        String op = "+";

        char c = s.charAt(ptr);
        if (c == '+' || c == '-') {
            op = String.valueOf(c);
            ptr++;
        } else if (Character.isDigit(c)) {
            int n = getDigit(s);
            if ("+".equals(op))
                sum += n;
            else
                sum -= n;
        } else if (c == ' ') {
            ptr++;
        } else { //为')'
            //过滤左括号
            ptr++;
            sum = dfs(s);
            //过滤右括号
            ptr++;

            ret += sum;
        }

        return ret;
    }

    public int calculate(String s) {
        LinkedList<String> stack = new LinkedList<>();

        while (ptr < s.length()) {
            char c = s.charAt(ptr);
            if (c == '(' || c == '+' || c == '-') {
                stack.addLast(String.valueOf(c));
                ptr++;
            } else if (Character.isDigit(c)) {
                stack.addLast(String.valueOf(getDigit(s)));
            } else if (c == ' ') {
                ptr++;
            } else { //为')'
                //跳过右括号
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"(".equals(stack.peekLast())) {
                    sub.addFirst(stack.removeLast());
                }
                //左括号出栈
                stack.removeLast();

                //计算括号中的数据
                int sum = getSum(sub);
                stack.addLast(String.valueOf(sum));
            }
        }

        return getSum(stack);
    }

    //读取数字
    public int getDigit(String s) {
        StringBuffer dit = new StringBuffer();
        while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
            dit.append(s.charAt(ptr++));
        }

        return Integer.parseInt(dit.toString());
    }

    public int getSum(LinkedList<String> sub) {
        int sum = 0;
        String op = "+";
        for (String s : sub) {
            if ("+".equals(s) || "-".equals(s)) {
                op = s;
            } else {
                if ("+".equals(op))
                    sum += Integer.valueOf(s);
                else
                    sum -= Integer.valueOf(s);
            }
        }

        return sum;
    }
}
