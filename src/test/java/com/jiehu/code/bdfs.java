package com.jiehu.code;

import com.jiehu.code.bdf.LandPerimeter;
import com.jiehu.code.bdf.RestoreIpAddresses;
import com.jiehu.code.bdf.SolveNQueens;

public class bdfs {
    public static void main(String[] args) {
        /**
         * 测试1： 岛屿周长
         */
//        landPerimeter();

//        restorelpAddress();
        solveNQueens();
    }

    public static void landPerimeter() {
        int[][] land = {{1, 1}, {1, 1}};
        LandPerimeter landPerimeter = new LandPerimeter();
        System.out.println(landPerimeter.islandPerimeter(land));
    }

    public static void restorelpAddress() {
//        String s = "25525511135";
        String s = "240102";
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses(s));
    }

    public static void solveNQueens() {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens2(4));
    }
}
