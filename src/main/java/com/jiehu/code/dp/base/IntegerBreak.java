package com.jiehu.code.dp.base;

/**
 * 343. 整数拆分
 * https://leetcode.cn/problems/integer-break/
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * <p>
 * 提示:
 * <p>
 * 2 <= n <= 58
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        //1.定义dp[i]: 含义为拆分i所得得最大乘积是多少
        int[] dp = new int[n + 1];
        /**
         * 2. 递推公式：
         * 得到i得最大乘积，无非是需要将i进行拆分，可以拆分个数有：2,3,4,...i-1
         * 状态：2个数时： j * （i-j）
         *      多个数时： j * dp[i-j] 相当于时拆分 i-j,以此来得到递推公式
         *  因为j是从 1 到 i-1 开始算dp[i]的乘积，所以需要取这个过程中的最大乘积
         *  所以递推公式为：
         *      dp[i] = max( dp[i], max(j*(i-j), j*dp[i-j]))
         */
        /**
         * 3. 初始化： dp[1] = 1
         * 4. 遍历顺序为，i从3开始，1和2已经确定，j从1开始
         */
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            // 为什么是i/2，因为超过i/2后的数据，已经算过了
            for (int j = 1; j < i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}























