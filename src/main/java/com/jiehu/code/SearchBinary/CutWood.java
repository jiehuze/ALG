package com.jiehu.code.SearchBinary;

/**
 * leetcode没有这个题
 * 给定长度为n的数组，每个元素代表一个木头的长度，木头可以任意截断，从这堆木头中截出至少k个相同长度为m的木块。已知k，求max(m)。
 * <p>
 * 输入两行，第一行n, k，第二行为数组序列。输出最大值。
 * <p>
 * 输入
 * 5 5
 * 4 7 2 10 5
 * 输出
 * 4
 */
public class CutWood {
    //二分编写注意点
    //
    //求的是 最后一个 cnt >= k 的长度, 所以每次要向右移动, 于是向上取整, 有 mid = left + right + 1 >> 1, 有+1
    //考虑两个元素的情况, 如果 mid 落在右边那一个元素, 这时 cnt < k, 所以 right = mid - 1
    //若 right= mid , 则下一次 mid 仍然不变, 无法跳出循环
    public int cutWood(int[] nums, int k) {
        int maxLen = 0;
        //找到最大长度的木头
        for (int i = 0; i < nums.length; i++) {
            maxLen = Math.max(maxLen, nums[i]);
        }

        //将木头长度按照二分法进行切割，可以减少一半的
        int l = 1;
        int r = maxLen;

        while (l < r) {
            //这里一定要+1，不然会进入死循环，left无法继续增加
            int mid = l + (r - l) / 2 + 1;

            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                cnt += nums[i] / mid;
            }

            if (cnt >= k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
