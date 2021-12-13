package com.jiehu.code.greedy;

import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        return removeDuplicatesByStack(s);
    }

    /**
     * 使用堆栈的方式
     */
    public String removeDuplicatesByStack(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peekLast() == s.charAt(i)) {
                stack.pollLast();
            } else {
                stack.offer(s.charAt(i));
            }
        }
        StringBuffer bf = new StringBuffer();
        while (!stack.isEmpty()) {
            bf.append(stack.pollFirst());
        }

        return bf.toString();
    }

    /**
     * 使用数组的方式,速度快
     */
    public String removeDuplicatesByArrays(String s) {
        char[] stack = new char[s.length()];
        int st = -1;

        for (int i = 0; i < s.length(); i++) {
            if (st != -1 && stack[st] == s.charAt(i)) {
                st--;
            } else {
                st++;
                stack[st] = s.charAt(i);
            }
        }

        return new String(stack, 0, st + 1);
    }

    /**
     * 快慢指针
     */
//    public String removeDuplicatesByPoint(String s) {
//        int l = -1;
//        for (int i = 0; i < s.length(); i++) {
//            if (l != -1 && s.charAt(l) == s.charAt(i)) {
//                l--;
//            } else {
//                l++;
//            }
//        }
//
//        return new String(stack, 0, st + 1);
//    }
}
