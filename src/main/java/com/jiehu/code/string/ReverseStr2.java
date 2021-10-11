package com.jiehu.code.string;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class ReverseStr2 {
    //输入
    //"abcdefg"
    //2
    //输出
    //"cbadgfe"
    //预期结果
    //"bacdfeg"
    public String reverseStr(String s, int k) {
        char[] ss = s.toCharArray();
        int len = ss.length;

        int m = len / (2 * k);
        int n = len % (2 * k);

        for (int i = 0; i < m; i++) {
            reverse(ss, i * 2 * k, i * 2 * k + k-1);
        }

        if (n < k) {
            reverse(ss, m * 2 * k, m * 2 * k + n-1);
        }
        if (n >= k) {
            reverse(ss, m * 2 * k, m * 2 * k + k-1);
        }

        return String.valueOf(ss);
    }

    public void reverse(char[] ss, int left, int right) {
        while (left <= right) {
            char tmp = ss[left];
            ss[left] = ss[right];
            ss[right] = tmp;
            left++;
            right--;
        }
    }
}








































