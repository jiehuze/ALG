package com.jiehu.code.greedy;

import java.util.*;

/**
 * 《硬币兑换》
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        //先进行排序
        Arrays.sort(coins);

        int level = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            level += amount / coins[i];
            amount = amount % coins[i];
        }

        if (amount == 0)
            return level;
        else
            return -1;
    }

    /**
     * bfs方法：将每个节点存储总和
     */
    public int bfs(int[] coins, int amount) {
        int level = 0;
        int sum = 0;
        //先进行排序
        Arrays.sort(coins);
        int len = coins.length;
        //先用贪心算法，将力度降下来
        if (amount % coins[len - 1] == 0) {
            return amount / coins[len - 1];
        } else {
            level = amount / coins[len - 1];
            sum = level * coins[len - 1];
        }

        LinkedList<Integer> stack = new LinkedList<>();

        stack.offer(sum);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Integer curCoin = stack.poll();
                if (curCoin == amount) return level;
                if (curCoin > amount) break;

                for (int j = 0; j < coins.length; j++) {
                    //做剪枝处理,将大的剪掉
                    if (curCoin + coins[j] <= amount)
                        stack.offer(curCoin + coins[j]);
                }
            }
            level++;
        }


        return -1;
    }

    public int coinChange1(int[] coins, int amount) {
        //先进行排序
        Arrays.sort(coins);

        dfs(coins, amount, 0, 0, mans);

        return mans == Integer.MAX_VALUE ? -1 : mans;
    }

    int mans = Integer.MAX_VALUE;

    public void dfs(int[] coins, int amount, int cIndex, int count, int ans) {
        if (amount == 0) {
            mans = Math.min(mans, ans);
            return;
        }

        if (cIndex == coins.length) return;

        for (int i = amount / coins[cIndex]; i >= 0 && i + count < ans; i++) {
            dfs(coins, amount - i * coins[cIndex], cIndex + 1, count + i, ans);
        }

    }


}
