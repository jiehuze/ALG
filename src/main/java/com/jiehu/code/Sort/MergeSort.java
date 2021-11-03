package com.jiehu.code.Sort;

/**
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略
 * （分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"合并在一起，即分而治之)。
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 */
public class MergeSort {
    public int[] sort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
        return arr;
    }

    private void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, tmp); ////左边归并排序，使得左子序列有序
            mergeSort(arr, mid + 1, right, tmp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, tmp);//将两个有序子数组合并操作
        }
    }

    //合并阶段，将两个数组合并成一个有序数组
    private void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针

        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                tmp[t++] = arr[j++];
            } else {
                tmp[t++] = arr[i++];
            }
        }

        while (i <= mid) {
            tmp[t++] = arr[i++];
        }

        while (j <= right) {
            tmp[t++] = arr[j++];
        }

        t = 0;
        //将生成的数组拷贝到源数组中
        while (left <= right) {
            arr[left++] = tmp[t++];
        }
    }
}
