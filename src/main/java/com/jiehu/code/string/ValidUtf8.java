package com.jiehu.code.string;

/**
 * 393. UTF-8 编码验证
 * <p>
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 * <p>
 * 对于 1 字节的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 * 这是 UTF-8 编码的工作方式：
 * <p>
 * Char. number range  |        UTF-8 octet sequence
 * (hexadecimal)    |              (binary)
 * --------------------+---------------------------------------------
 * 0000 0000-0000 007F | 0xxxxxxx
 * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 * <p>
 * 注意：
 * 输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。
 * <p>
 * 示例 1：
 * <p>
 * data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
 * <p>
 * 返回 true 。
 * 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
 * 示例 2：
 * <p>
 * data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
 * <p>
 * 返回 false 。
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 */
public class ValidUtf8 {
    public boolean validUtf8(int[] data) {
        int len = data.length;
        int left = 0;
        while (left < len) {
            int ishead = ishead(data[left]);
            if (ishead == 0) {
                left++;
                continue;
            }
            if (ishead == -1)
                return false;

            for (int i = 1; i < ishead; i++) {
                if (i + left >= len) {
                    return false;
                }
                if (isbody(data[i + left]) == false) {
                    return false;
                }
            }
            left += ishead;
        }
        return true;
    }

    public int ishead(int data) {
        int four = data >> 4;
        int n = -1;
        if (four < 8) {
            n = 0;
        }

        if ((four & 0xC) == 12) {
            n = 2;
        }
        if (four == 14) {
            n = 3;
        }

        if (four == 15 && (data & 0x08) == 0) {
            n = 4;
        }

        return n;
    }

    public boolean isbody(int data) {
        int body = data >> 6;
        if (body == 2)
            return true;
        else
            return false;
    }
}
