package com.jiehu.code;

import com.jiehu.code.Sort.QuickSort;

import java.util.Arrays;

public class sortT {
    public static void main(String[] args) {

        quickSort();
    }

    public static void quickSort() {
        int[] as = {1, 5, 3, 7, 6, 8};
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.sort(as)));

    }
}
