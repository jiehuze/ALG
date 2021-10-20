package com.jiehu.code.hash;

import java.util.HashMap;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
 */
public class WordPattern {
    // hash法
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> patternHash = new HashMap<>();

        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (patternHash.containsKey(c) && !patternHash.get(c).equals(words[i])) {
                return false;
            }

            if (!patternHash.containsKey(c) && patternHash.containsValue(words[i]))
                return false;

            patternHash.put(c, words[i]);
        }

        return true;
    }
}
