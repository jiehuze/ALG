package com.jiehu.code;

import com.jiehu.code.greedy.CoinChange;

public class greedyT {
    public static void main(String[] args) {
        /**
         * 测试1：
         */
        coinChange();
    }

    public static void coinChange() {
//        [1, 2, 5], amount = 11
        int[] coins = {1, 2, 5};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange1(coins, 11));

    }
}
