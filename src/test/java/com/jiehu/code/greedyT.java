package com.jiehu.code;

import com.jiehu.code.greedy.*;

public class greedyT {
    public static void main(String[] args) {
        /**
         * 测试1：
         */
//        coinChange();

//        minCost();

//        removeDuplicatesII();
//        canCompleteCircuit();
//        maximumSwap();

        matrixScore();
    }

    public static void matrixScore() {
//        int[][] grid = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int[][] grid = {{0, 1, 1}, {1, 1, 1}, {0, 1, 0}};
        MatrixScore matrixScore = new MatrixScore();
        System.out.println(matrixScore.matrixScore(grid));
    }

    public static void maximumSwap() {
//        int num = 99808;
//        int num = 9901;
//        int num = 2736;
        int num = 9973;
//        int num = 99088;
        MaximumSwap maximumSwap = new MaximumSwap();
        System.out.println(maximumSwap.maximumSwap(num));
    }

    public static void coinChange() {
//        [1, 2, 5], amount = 11
        int[] coins = {1, 2, 5};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange1(coins, 11));

    }

    public static void minCost() {
        String s = "bbbaaa";
        int[] cost = new int[]{4, 9, 3, 8, 8, 9};
        MinCost minCost = new MinCost();
        System.out.println(minCost.minCost(s, cost));

    }

    public static void removeDuplicatesII() {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        RemoveDuplicatesII removeDuplicatesII = new RemoveDuplicatesII();
        System.out.println(removeDuplicatesII.removeDuplicates2(s, k));

    }

    public static void canCompleteCircuit() {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};

        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        System.out.println(canCompleteCircuit.canCompleteCircuit(gas, cost));

    }
}
