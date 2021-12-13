package com.jiehu.code.greedy;

/**
 * 1578. 避免重复字母的最小删除成本
 * https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 * 返回使字符串任意相邻两个字母不相同的最小删除成本。
 * 请注意，删除一个字符后，删除其他字符的成本不会改变。
 * 示例 1：
 * 输入：s = "abaac", cost = [1,2,3,4,5]
 * 输出：3
 * 解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
 * 示例 2：
 * 输入：s = "abc", cost = [1,2,3]
 * 输出：0
 * 解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
 * 示例 3：
 * 输入：s = "aabaa", cost = [1,2,3,4,1]
 * 输出：2
 * 解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
 */
public class MinCost {
    public int minCost(String s, int[] cost) {
        int costSum = 0;
        int max = Integer.MAX_VALUE;

        //贪心算法，将重复的字符作为一项单独处理
        for (int i = 0; i < s.length(); i++) {
            max = cost[i];
            for (int j = 1; j <= s.length() - i; j++) {
                if (j == s.length() - i) return costSum;

                if (s.charAt(i + j - 1) == s.charAt(i + j)) {
                    costSum += Math.min(max, cost[i + j]);
                    max = Math.max(max, cost[i + j]);
                } else {
                    i += j - 1;
                    break;
                }
            }
        }

        return costSum;
    }
}
