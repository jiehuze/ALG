package com.jiehu.code.StackAndQueue;

import java.util.LinkedList;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class DecodeString {
    int ptr = 0;

    public String decodeString(String s) {
//        return decodeStack(s);
        return dfs(s);
    }

    /**
     * 二：dfs,重点看下
     */
    public String dfs(String s) {
        //结束条件
        if (ptr == s.length() || s.charAt(ptr) == ']') {
            return "";
        }

        int repTime = 1;
        String ret = "";
        if (Character.isDigit(s.charAt(ptr))) {
            repTime = Integer.valueOf(getDigit(s));
            //跳过左括号
            ++ptr;
            String str = dfs(s);
            //过滤有括号
            ++ptr;

            //构造字符串
            for (int j = 0; j < repTime; j++) {
                ret += str;
            }
        } else if (Character.isLetter(s.charAt(ptr))) {
            ret = String.valueOf(s.charAt(ptr++));
        }

        return ret + dfs(s);
    }

    /**
     * 这个方法利用堆栈，很牛逼，利用两个堆栈解决
     */
    public String decodeStack(String s) {
        LinkedList<String> stack = new LinkedList<>();
        while (ptr < s.length()) {
            char c = s.charAt(ptr);
            if (Character.isDigit(c)) {
                stack.addLast(getDigit(s));
            } else if (Character.isLetter(c) || c == '[') {
                stack.addLast(String.valueOf(c));
                ptr++;
            } else {
                //跳过"]"
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    //要倒序写，因为在stack中是倒序的，在这里倒序写就是正序了
                    sub.addFirst(stack.removeLast());
                }
                //左括号出栈
                stack.removeLast();

                //此时为字符串应该出现的次数
                int cnt = Integer.valueOf(stack.removeLast());

                //构造串
                StringBuffer t = new StringBuffer();
                String o = getString(sub);

                for (int j = 0; j < cnt; j++) {
                    t.append(o);
                }

                //将构造好的字符串入栈
                stack.addLast(t.toString());
            }
        }

        return getString(stack);
    }

    /**
     * @param s 数字可以是1-9，也可以是>=10
     * @return
     */
    public String getDigit(String s) {
        StringBuffer ret = new StringBuffer();
        while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }

        return ret.toString();
    }

    /**
     * 从堆栈中恢复字符串
     */
    public String getString(LinkedList<String> stk) {
        StringBuffer ret = new StringBuffer();
        for (String s : stk) {
            ret.append(s);
        }

        return ret.toString();
    }
}













