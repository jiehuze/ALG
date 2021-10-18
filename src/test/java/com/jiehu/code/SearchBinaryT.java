package com.jiehu.code;

import com.jiehu.code.SearchBinary.CutWood;
import com.jiehu.code.SearchBinary.KthPositive;
import com.jiehu.code.SearchBinary.SearchMatrix;

public class SearchBinaryT {
    public static void main(String[] args) {
        /**
         * 测试矩阵查找1：
         */
//        searchMatrix();

        /**
         * 第 k 个缺失的正整数
         */
//        findKthPositive();

        /**
         * 截木头
         */
        cutWood();
    }

    public static void searchMatrix() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//        int[][] matrix = {{1}};


        SearchMatrix searchMatrix = new SearchMatrix();
//        System.out.println(searchMatrix.binary2Times(matrix, 13));

        System.out.println(searchMatrix.binarySearch(matrix, 3));
    }

    public static void findKthPositive(){
//        int[] nums = {1,2,3,4};
        int[] nums = {2,3,4,7,11};
        KthPositive kthPositive = new KthPositive();
        System.out.println(kthPositive.findKthPositive(nums, 5));

    }

    public static void cutWood(){
        int[] nums = {4,7,2,10,5};
        CutWood cutWood = new CutWood();
        System.out.println(cutWood.cutWood(nums, 5));

    }
}
