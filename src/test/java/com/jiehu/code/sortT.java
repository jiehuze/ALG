package com.jiehu.code;

import com.jiehu.code.Sort.BubbleSort;
import com.jiehu.code.Sort.InsertSort;
import com.jiehu.code.Sort.MergeSort;
import com.jiehu.code.Sort.QuickSort;

import java.util.Arrays;

public class sortT {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 6, 8};

        quickSort(arr);
        insertSort(arr);
        mergeSort(arr);
        bubbleSort(arr);
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr) {
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.sort(arr)));
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr) {
        InsertSort insertSort = new InsertSort();
        System.out.println(Arrays.toString(insertSort.sort(arr)));

    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sort(arr)));
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.sort(arr)));
    }

    public static void sortt() {
        //测试80万个数据的排序
        int[] arr = new int[800000];
        for (int index = 0; index < 800000; index++) {
            arr[index] = (int) (Math.random() * 80000);
        }
    }
}
