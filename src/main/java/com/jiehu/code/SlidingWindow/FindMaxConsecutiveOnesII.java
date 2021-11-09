package com.jiehu.code.SlidingWindow;

/**
 * 487. 最大连续1的个数 II（中等）
 * 快手、阿里面试
 * 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 * <p>
 * 示例 1：
 * 输入：[1,0,1,1,0]
 * 输出：4
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 * 当翻转以后，最大连续 1 的个数为 4。
 * 注：
 * 输入数组只包含 0 和 1.
 * 输入数组的长度为正整数，且不超过 10,000
 */
public class FindMaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        return getMaxNum(nums);
    }

    public int getMaxNum(int[] nums) {
        //起始位置为left，跳过0后的最后一个1的位置为right
        int left = 0, right = 0;
        int z = -1;
        int maxLen = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                if (z > left) {
                    maxLen = Math.max(right - left, maxLen);
                    left = z + 1;
                }
                z = right;
            }
            right++;
        }

        maxLen = Math.max(right - left, maxLen);

        return maxLen;
    }

    public int getMaxNum2(int[] nums) {
        //p1存储含有一个0的数组长度，p2存储没有0的数组长度
        int p1 = 0, p2 = 0;
        int res = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                p1++;
                p2++;
            } else {
                p1 = p2 + 1;
                p2 = 0;
            }

            res = Math.max(p1, Math.max(p2, res));
        }

        return res;
    }

    //滑动窗口的另一种方式
    public int getMaxNum3(int[] nums) {
        int left = 0;
        //最为间隔多少个0计算，
        int z = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                z++;
            }
            //这里的间隔为不大于1，可以任意为k
            while (z > 1) {
                if (nums[left] == 0) {
                    z--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;
    }
}
