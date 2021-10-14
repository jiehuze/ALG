package com.jiehu.code.math;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int i = a.length() - 1, j = b.length() - 1, add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? a.charAt(i)-'0' : 0;
            int y = j >= 0 ? b.charAt(j)-'0' : 0;

            ans.append((x + y + add) % 2);
            add = (x + y + add) / 2;

            i--;
            j--;
        }

        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = addBinary("11", "1");
        System.out.println(s);
    }
}
