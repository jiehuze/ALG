package com.jiehu.code.StackAndQueue;

import java.util.Arrays;

/**
 * 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * 示例：
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        return lastStoneWeight1(stones);
    }

    /**
     * 排序后进行粉碎，
     * 这个方法是比较好的，
     * 还有一种方法，使用队列方式，原始要排序，将队列中被粉碎的石头移除出该队列，剩下的<=1的个数就是最后的石头重量
     */
    public int lastStoneWeight1(int[] stones) {
        int len = stones.length;
        if (len < 2) {
            return stones[0];
        }
        Arrays.sort(stones);
        while (stones[len - 1] != 0 && stones[len - 2] != 0) {
            if (stones[len - 2] == stones[len - 1]) {
                stones[len - 2] = 0;
                stones[len - 1] = 0;
            } else if (stones[len - 2] < stones[len - 1]) {
                stones[len - 1] -= stones[len - 2];
                stones[len - 2] = 0;
            }
            Arrays.sort(stones);
        }
        return stones[len - 1];
    }
}
