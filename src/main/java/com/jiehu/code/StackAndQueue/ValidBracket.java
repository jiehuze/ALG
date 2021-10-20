package com.jiehu.code.StackAndQueue;

import java.util.LinkedList;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class ValidBracket {
    public boolean isValid(String s) {
        return isValidByStack(s);
    }

    /**
     * 使用堆栈的方式解决该问题
     */
    public boolean isValidByStack(String s) {
        //将所有 "(,[,{"入栈，遇到 ),],}"出栈与之对比即可
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.addFirst(c);
            } else {
                if (stack.size() == 0)
                    return false;
                char c1 = stack.pop();
                if (c == ')' && c1 == '('
                        || c == ']' && c1 == '['
                        || c == '}' && c1 == '{') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.size() != 0) return false;

        return true;
    }
}




















