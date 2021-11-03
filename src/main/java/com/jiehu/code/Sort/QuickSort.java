package com.jiehu.code.Sort;

/**
 * 快速排序：
 * 快速排序是由东尼·霍尔所发展的一种排序算法
 * 需要使用的3个指针：
 * 1. pivot：基准指针，
 * 2. slow：慢指针，
 * 3. i：快指针
 * 通过快指针从头开始向后遍历，慢指针的左侧为<pivot的数字，右侧为>pivot的数字
 * 一轮遍历完成后，pivot和slow-1数据对换位置，只有pivot的位置，左侧为<pivot位置的数字，右侧为>pivot位置的数字
 * 第二轮：使用pivot进行分割为 left部分，和right部分，
 * 一次轮询后，最后得到的就是一个有序数组了
 * <p>
 * 大数据的mapreduce都是使用的快排的方式
 * <p>
 * 该算法和归并排序的思想一样，同样使用分治法进行，指示归并需要分治后合并，快排不需要合并过程，自动是顺序的
 */
public class QuickSort {
    public int[] sort(int[] arrays) {
        quickSort(arrays, 0, arrays.length - 1);

        return arrays;
    }

    public void quickSort(int[] arrays, int left, int right) {
        if (left < right) {
            int partitionId = partition(arrays, left, right);
            //递归左侧
            quickSort(arrays, left, partitionId - 1);
            //递归右侧
            quickSort(arrays, partitionId + 1, right);
        }
    }

    public int partition(int[] arrays, int left, int right) {
        int pivot = left;//基准数据
        int slow = left + 1; //慢指针
        //i为快指针
        for (int i = slow; i <= right; i++) {
            if (arrays[i] < arrays[pivot]) {
                swap(arrays, i, slow);
                //交换数据后，慢指针后移一位
                slow++;
            }
        }

        //将基准数据和慢指针数据交换位置，因为慢指针-1的左侧数据为小于pivot的数据，右侧为大于pivot的数据
        swap(arrays, pivot, slow - 1);

        return slow - 1;
    }

    //交互数据
    public void swap(int[] arrays, int index, int index2) {
        int tmp = arrays[index];
        arrays[index] = arrays[index2];
        arrays[index2] = tmp;
    }
}
