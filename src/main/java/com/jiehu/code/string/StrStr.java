package com.jiehu.code.string;

/**
 * 28. 实现 strStr()
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();

        if (ns.length == 0)
            return 0;

        int left = 0;
        while (left <= hs.length - ns.length) {
            for (int i = 0; i < ns.length; i++) {
                if (hs[left + i] != ns[i]) break;

                if (i == ns.length - 1) return left;
            }
            left++;
        }


        return -1;
    }

    /**
     * KMP算法详解
     * https://www.zhihu.com/question/21923021
     */

    public int strStr2(String haystack, String needle) {
        //两种特殊情况
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        // char 数组
        char[] hasyarr = haystack.toCharArray();
        char[] nearr = needle.toCharArray();
        //长度
        int halen = hasyarr.length;
        int nelen = nearr.length;
        //返回下标
        return kmp(hasyarr, halen, nearr, nelen);

    }

    public int kmp(char[] hasyarr, int halen, char[] nearr, int nelen) {
        //获取next 数组
        int[] next = next(nearr, nelen);
        int j = 0;
        for (int i = 0; i < halen; ++i) {
            //发现不匹配的字符，然后根据 next 数组移动指针，移动到最大公共前后缀的，
            //前缀的后一位,和咱们移动模式串的含义相同
            while (j > 0 && hasyarr[i] != nearr[j]) {
                j = next[j - 1] + 1;
                //超出长度时，可以直接返回不存在
                if (nelen - j + i > halen) {
                    return -1;
                }
            }
            //如果相同就将指针同时后移一下，比较下个字符
            if (hasyarr[i] == nearr[j]) {
                ++j;
            }
            //遍历完整个模式串，返回模式串的起点下标
            if (j == nelen) {
                return i - nelen + 1;
            }
        }
        return -1;
    }

    //这一块比较难懂，不想看的同学可以忽略，了解大致含义即可，或者自己调试一下，看看运行情况
    //我会每一步都写上注释
    //最长前缀标记
    public int[] next(char[] needle, int len) {
        //定义 next 数组
        int[] next = new int[len];
        // 初始化
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < len; ++i) {
            //我们此时知道了 [0,i-1]的最长前后缀，但是k+1的指向的值和i不相同时，我们则需要回溯
            //因为 next[k]就是用来记录子串的最长公共前后缀的尾坐标（即长度）
            //就要找 k+1前一个元素在next数组里的值,即next[k+1]
            while (k != -1 && needle[k + 1] != needle[i]) {
                k = next[k];
            }
            // 相同情况，就是 k的下一位，和 i 相同时，此时我们已经知道 [0,i-1]的最长前后缀
            //然后 k - 1 又和 i 相同，最长前后缀加1，即可
            if (needle[k + 1] == needle[i]) {
                ++k;
            }
            next[i] = k;

        }
        return next;
    }

}































