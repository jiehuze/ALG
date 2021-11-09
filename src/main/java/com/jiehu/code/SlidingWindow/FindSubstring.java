package com.jiehu.code.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 30. 串联所有单词的子串
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * 字节、百度、阿里、腾讯、华为
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * 示例 1：
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 示例 3：
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 */
public class FindSubstring {
    /**
     * 方法：同样是使用滑动窗口解决
     * 1。 先计算出滑动窗口的长度
     * 2。 使用临时hash存储word，与words进行比较，一致怎记录下标，否则滑动窗口
     */
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> rets = new ArrayList<>();
        //第一步计算words的长度,使用这个长度，去s中左滑动窗口大小
        int wordLen = words[0].length();
        int totalLen = words.length * words[0].length();

        HashMap<String, Integer> wHash = new HashMap<>();//存储字符串和个数

        for (String word : words) {
            wHash.put(word, wHash.getOrDefault(word, 0) + 1);
        }

        int left = 0;
        //因为substring是左闭又开区间，所以i的最大值要到s.length,而不能是s的最长下标
        for (int i = totalLen; i <= s.length(); i++, left++) {
            String sub = s.substring(left, i);
            if (check(wHash, sub, wordLen)) {
                rets.add(left);
            }
        }

        return rets;
    }

    public boolean check(HashMap<String, Integer> whash, String sub, int wordLen) {
        HashMap<String, Integer> tmp_hash = new HashMap<>();
        for (int i = 0; i < sub.length() / wordLen; i++) {
            String word = sub.substring(i * wordLen, (i + 1) * wordLen);
            if (!whash.containsKey(word))
                return false;
            tmp_hash.put(word, tmp_hash.getOrDefault(word, 0) + 1);
        }

        if (tmp_hash.equals(whash))
            return true;
        else
            return false;
    }
}
