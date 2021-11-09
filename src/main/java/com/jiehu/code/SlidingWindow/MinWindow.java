package com.jiehu.code.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 字节、腾讯
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        return minWindowByArrays(s, t);
    }

    /**
     * 滑动窗口：
     * 1， 当不符合t时，r向右滑动，知道满足t
     * 2。 在满足t后，l向右滑动，直到不满足t，返回第一步即可
     */
    public String minWindowByHashMap(String s, String t) {
        //用户存储滑动窗口中的字符及个数
        HashMap<Character, Integer> shp = new HashMap<>();
        HashMap<Character, Integer> thp = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            thp.put(t.charAt(i), thp.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = 0;
        int minL = 0, minR = 0;
        int minStr = Integer.MAX_VALUE;
        while (r < s.length()) {
            shp.put(s.charAt(r), shp.getOrDefault(s.charAt(r), 0) + 1);
            while (r >= t.length() - 1 && check(shp, thp) && l <= r) {
                if (r - l + 1 < minStr) {
                    minL = l;
                    minR = r + 1;
                    minStr = r - l + 1;
                }
                shp.put(s.charAt(l), shp.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            r++;
        }

        return minR == 0 ? "" : s.substring(minL, minR);
    }

    /**
     * 检查shp中是否全部覆盖来thp
     */
    public boolean check(HashMap<Character, Integer> shp, HashMap<Character, Integer> thp) {
        for (Map.Entry<Character, Integer> entry : thp.entrySet()) {
            if (shp.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    /**
     * 方法二：使用字符数组来存储字符和个数，这样使用数组的特性，效率会更高
     * 字符最多为128个，所以申请两个字符数组，大小为128
     * <p>
     * 效率高：3ms，
     * 第一个方法：38ms
     */
    public String minWindowByArrays(String s, String t) {
        //记录滑动窗口中的字符次数
        int[] wArrs = new int[128];
        //记录t中的字符次数
        int[] tArrs = new int[128];

        int minLen = Integer.MAX_VALUE;
        int minL = 0, minR = 0;
        //记录滑动窗口中存在的t中的字符数量
        int count = 0;
        int l = 0, r = 0;

        for (int i = 0; i < t.length(); i++) {
            tArrs[t.charAt(i)]++;
        }

        while (r < s.length()) {

            char c = s.charAt(r);
            wArrs[c]++;
            if (tArrs[c] > 0 && wArrs[c] <= tArrs[c]) {
                count++;
            }

            //当窗口中覆盖t中的所有字符
            while (count == t.length()) {
                //左指针向右移动
                if (r - l + 1 < minLen) {
                    minL = l;
                    minR = r + 1;
                    minLen = r - l + 1;
                }

                //如果左指针的数据在t中，count将减1；左指针向右移动
                char cl = s.charAt(l);
                wArrs[cl]--;
                if (tArrs[cl] > 0 && wArrs[cl] < tArrs[cl]) {
                    count--;
                }
                l++;
            }

            r++;
        }

        return minR == 0 ? "" : s.substring(minL, minR);
    }
}






























