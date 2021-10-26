package com.jiehu.code.StackAndQueue;

import java.util.LinkedList;

/**
 * 151. 翻转字符串里的单词
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 * 说明：
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
 * 示例 4：
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 * 提示：
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 */
public class ReverseWords {
    public String reverseWords(String s) {
        return reverseWords1(s);
    }

    /**
     * 一：使用数组直接返回
     */
    public String reverseWords1(String s) {

        String[] sp = s.split(" ");
        StringBuffer sbf = new StringBuffer();
        for (int i = sp.length - 1; i >= 0; i--) {
            if (" ".equals(sp[i]) || "".equals(sp[i])) {
                continue;
            }
            if (sbf.length() != 0)
                sbf.append(" ");
            sbf.append(sp[i]);
        }

        return sbf.toString();
    }

    /**
     * 二：不使用api方式
     * 通过堆栈完成
     */
    public String reverseWords2(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        StringBuffer stb = new StringBuffer();

        for (int i = s.length() - 1; i >= -1; i--) {
            if (i == -1 || s.charAt(i) == ' ') {
                if (!stack.isEmpty() && stb.length() != 0)
                    stb.append(" ");
                while (!stack.isEmpty()) {
                    stb.append(stack.pop());
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stb.toString();
    }

}
