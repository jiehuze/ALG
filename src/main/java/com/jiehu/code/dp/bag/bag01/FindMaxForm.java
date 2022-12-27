package com.jiehu.code.dp.bag.bag01;

/**
 * 474. 一和零
 * https://leetcode.cn/problems/ones-and-zeroes/
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * 提示：
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 */
public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        /**
         * 这个把strs种的元素认为是 物品
         * m和n是两种纬度的背包而已，   所以这个还是01背包问题；
         * 需要没每一个元素（物品）种的0和1个数计算出来
         */
        //1. 定义dp[i][j]数组，含义为： 背包种i个0，j个1的最大子集个数
        int [][]dp = new int[m+1][n+1];
        /**
         * 2。 推导公式：根据01背包公式: dp[j] = dp[j-value[i]] + value[i]
         *
         * dp[i][j] = max(dp[i][j], dp[i-izeroNum][j-jzeroNum]+1)
         */
        // 3。 初始化 dp数组，为0即可

        for (String str : strs) { //遍历物品
            int xz = 0, yz = 0;
            for (char c : str.toCharArray())
                if (c == '0') xz++;
                else yz++;

            for (int x = m; x >= xz; x--) { // 背包m
                for (int y = n; y >= yz; y--) { //背包n 从大到下遍历
                    dp[x][y] = Math.max(dp[x][y], dp[x-xz][y-yz]+1);
                }
            }
        }

        return dp[m][n];
    }
}
