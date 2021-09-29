package com.jiehu.code;

import com.jiehu.code.matrix.*;
import com.jiehu.code.bdf.Jump;

import java.util.List;

public class matrixT {
    public static void main(String[] args) {
        /**
         * 测试1： 螺旋矩阵输出
         */
//        spiralOrder();

        /**
         * 测试2： 查询words，水平和垂直方向,
         */

//        findWords();

        /**
         * 测试3： 3数之和
         */
//        threeSum();

        /**
         * 测试3： 4数之和
         */
        fourSum();

        /**
         * 测试4：矩阵顺时针和逆时针旋转
         */
        rotate();

        /**
         * 跳跃游戏
         */
        jump();
    }

    public static void jump() {
        int[] nums = {2, 1, 1, 3, 1, 4};
        Jump jump = new Jump();
        System.out.println(jump.bfs(nums));
    }

    public static void spiralOrder() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        int [][]matrix = new int[][]{{6,9,7}};

        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> integers = spiralOrder.spiralOrder(matrix);

        System.out.println(integers);
    }

    public static void findWords() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        FindWords findWords = new FindWords();
        List<String> wList = findWords.findWords(board, words);

        System.out.println(wList);

    }

    public static void threeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);


        System.out.println(lists);

    }

    public static void fourSum() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        FourSum fourSum = new FourSum();
//        final List<List<Integer>> lists = fourSum.fourSum(nums, 0);
//
//        System.out.println(lists);

        final List<List<Integer>> lists2 = fourSum.fourSum2(nums, 0);
        System.out.println(lists2);
    }

    public static void rotate() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Rotate rotate = new Rotate();
        rotate.rotate1(matrix);
        for (int[] s : matrix) {
            for (int t : s) {
                System.out.print(t + " ");
            }
            System.out.print("\n");
        }

        rotate.rotate(matrix);

        for (int[] s : matrix) {
            for (int t : s) {
                System.out.print(t + " ");
            }
            System.out.print("\n");
        }

        rotate.rotate2(matrix);
        for (int[] s : matrix) {
            for (int t : s) {
                System.out.print(t + " ");
            }
            System.out.print("\n");
        }
    }
}
