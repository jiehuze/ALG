package com.jiehu.code.math;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2 31次方,  2 31次方 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 */
public class Reverse {
    /**
     * 第一中方法：按位进行转
     */
    public int reverse(int x) {
        long ret = 0;
        int m = x / 10;
        while (m > 0) {
            ret = ret * 10 + m % 10;
            m = m / 10;
        }

        //如果超出了范围，就返回0，比较巧妙
        return (int) ret == ret ? (int) ret : 0;
    }

    /**
     * 第二中方法：使用字符串反转
     */
    public int reverse2(int x) {
        char[] s = String.valueOf(x).toCharArray();
        int left = 0;
        int right = s.length - 1;

        if (s[left] == '-') {
            left++;
        }
        while (left <= right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }

        long aLong = Long.valueOf(new String(s));

        return (int) aLong == aLong ? (int) aLong : 0;
    }
}
