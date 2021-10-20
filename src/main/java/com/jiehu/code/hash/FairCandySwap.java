package com.jiehu.code.hash;

import java.util.HashSet;

/**
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * 示例 1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //先求和，并存储在hashset中
        HashSet<Integer> bobSet = new HashSet<>();
        int aliceNums = 0;
        int bobNums = 0;
        int[] ret = new int[2];

        //先将数组保存在hashset中，便于查找，并计算各个和，
        for (int a : aliceSizes) {
            aliceNums += a;
        }

        for (int b : bobSizes) {
            bobSet.add(b);
            bobNums += b;
        }

        int average = (aliceNums + bobNums) / 2;

        //公式：平均值-（alice总数-交换糖果）= bob的交换糖果
        //如果bob有这个糖果就返回正确
        for (int a : aliceSizes) {
            int t = average - (aliceNums - a);
            if (bobSet.contains(t)) {
                ret[0] = a;
                ret[1] = t;
                break;
            }
        }

        return ret;
    }
}
