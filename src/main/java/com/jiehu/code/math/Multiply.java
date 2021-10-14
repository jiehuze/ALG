package com.jiehu.code.math;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {
    /**
     * 使用字符传位逐一增加方法
     * todo 未完成
     */
    public String multiply(String num1, String num2) {
        StringBuffer ret = new StringBuffer();
        int[] math = new int[num1.length()];

        for (int i = 0; i < num1.length(); i++) {
            int add = 0;
            for (int j = 0; j < num2.length(); j++) {
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';

                math[i] = ((x * y + add) % 10) * j * 10 + math[i];
                add = (x * y + add) / 10;
            }
        }

        return ret.toString();
    }

    /**
     * 乘法：
     */
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        //相乘后的所得结果是固定落在固定位置的
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        //将该该位置>10的数，进位到高位
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        //int转string
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }

}
