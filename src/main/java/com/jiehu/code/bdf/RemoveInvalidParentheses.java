package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 301. 删除无效的括号 (困难)   todo
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * 示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 * <p>
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 * <p>
 * 输入：s = ")("
 * 输出：[""]
 */
public class RemoveInvalidParentheses {
    List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int lr = 0, rr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') lr++;
            if (s.charAt(i) == ')') {
                if (lr > 0) lr--;
                else rr++;
            }
        }

        dfs(0, lr, rr, s);

        return res;
    }

    //回溯,深度搜索
    public void dfs(int index, int lr, int rr, String s) {
        //结束条件
        if (lr == 0 && rr == 0) {
            if (isValid(s)) res.add(s);
        }

        //for 循环
        //跳过条件
        //判断条件
        //回溯
        for (int i = index; i < s.length(); i++) {
            //如果当前括号和前一个括号一样，就跳过，因为没有必要在处理，一个效果
            if (i > index && s.charAt(i) == s.charAt(i - 1)) continue;

            if (lr > rr && s.charAt(i) == '(') {
                dfs(i, lr - 1, rr, s.substring(0, i) + s.substring(i + 1));
            }
            if (rr > lr && s.charAt(i) == ')') {
                dfs(i, lr, rr - 1, s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
            stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }
}

