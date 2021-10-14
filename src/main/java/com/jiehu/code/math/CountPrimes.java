package com.jiehu.code.math;

import java.util.Arrays;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 106
 * <p>
 * 介绍方法：一般有两种方法
 * 方法一：暴力方法
 * 方法二：埃氏筛
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int num = 0;
        int[] primes = new int[n];
        //默认全部比较为指数
        Arrays.fill(primes, 1);

        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                num++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = 0;
                    }
                }
            }
        }

        return num;
    }

    /**
     * 这个效率要高一点
     */
    public int countPrimes2(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        //循环不一样
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}
