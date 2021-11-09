package com.jiehu.code.SlidingWindow;

/**
 * 1004. 最大连续1的个数 III
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * 字节、华为
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 */
public class FindMaxConsecutiveOnesIII {
    //滑动窗口的方式进行
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int z = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                z++;
            }
            while (z > k) {
                if (nums[left] == 0) {
                    z--;
                }
            }

            maxLen = Math.max(i - left + 1, maxLen);
        }

        return maxLen;
    }
}
