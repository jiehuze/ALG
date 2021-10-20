package com.jiehu.code.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 771. 宝石与石头
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 * <p>
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 */
public class NumJewelsInStones {
    /**
     * 方法一：hash算法，使用hashset存储宝石
     */
    public int numJewelsInStones1(String jewels, String stones) {
        int cnt = 0;
        HashSet<Character> jcsHashSet = new HashSet<>();
        char[] jcs = jewels.toCharArray();
        for (Character jc : jcs) {
            jcsHashSet.add(jc);
        }

        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            if (jcsHashSet.contains(c)) {
                cnt++;
            }
        }

        return cnt;
    }

    /**
     * 第二中算法：数组算法，用数组保存
     */
    public int numJewelsInStones2(String jewels, String stones) {
        int cnt = 0;
        int[] jcsArray = new int['z' - 'A' + 1];
        Arrays.fill(jcsArray, 0);
        char[] jcs = jewels.toCharArray();
        for (Character jc : jcs) {
            jcsArray[jc - 'A'] = 1;
        }

        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            if (jcsArray[c - 'A'] == 1) {
                cnt++;
            }
        }

        return cnt;
    }
}

















