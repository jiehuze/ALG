package com.jiehu.code.StackAndQueue;

import java.util.LinkedList;

/**
 * 402. 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * 示例 1 ：
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 * <p>
 * 提示：
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        //112
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && num.charAt(i) < stack.peek()) {
                k--;
                stack.pop();
            }
            stack.push(num.charAt(i));
        }

        //如果k为不为0，那么需要从栈中删除数字，从后往前删除
        while (!stack.isEmpty() && k > 0) {
            stack.removeFirst();
            k--;
        }

        StringBuffer rest = new StringBuffer();
        while (!stack.isEmpty()) {
            //如果第一个字符为0去掉，数字第一个位不能为0
            if (stack.peekLast() == '0' && rest.length() == 0) {
                stack.removeLast();
                continue;
            }
            rest.append(stack.removeLast());
        }

        return rest.length() == 0 ? "0" : rest.toString();
    }
}
