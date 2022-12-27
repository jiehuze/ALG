package com.jiehu.code.dp.base;

/**
 * 509. 斐波那契数
 * https://leetcode.cn/problems/fibonacci-number/
 * 斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 30
 */
public class Fib {
    public int fib(int n) {
        if ( n <= 1) return n;
        //1. dp[i] 含义：第i个数组下标下的总和
        int[] dp = new int[n + 1];
        //2. 初始化dp数组
        dp[0] = 0;
        dp[1] = 1;
        //4. 遍历顺序从3开始，从小到大遍历
        for (int i = 2; i <= n; i++) {
            //3. 递推公式
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
