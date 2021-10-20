package com.jiehu.code;

import com.jiehu.code.hash.FairCandySwap;

public class hashT {
    public static void main(String[] args) {

        /**
         * 交换糖果
         */
        fairCandySwap();
    }

    public static void fairCandySwap() {
        int[] alice = {1, 2};
        int[] bob = {2, 3};
        FairCandySwap fairCandySwap = new FairCandySwap();
        System.out.println(fairCandySwap.fairCandySwap(alice, bob));
    }
}
