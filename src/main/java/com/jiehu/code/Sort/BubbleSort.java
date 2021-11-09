package com.jiehu.code.Sort;

/**
 * 冒泡排序
 * https://www.jianshu.com/p/1458abf81adf
 * 1.原理：比较两个相邻的元素，将值大的元素交换到右边
 * 2.思路：依次比较相邻的两个数，将比较小的数放在前面，比较大的数放在后面。
 * 　　　　(1)第一次比较：首先比较第一和第二个数，将小数放在前面，将大数放在后面。
 * 　　　　(2)比较第2和第3个数，将小数 放在前面，大数放在后面。
 * 　　　　......
 * 　　　　(3)如此继续，知道比较到最后的两个数，将小数放在前面，大数放在后面，重复步骤，直至全部排序完成
 * 　　　　(4)在上面一趟比较完成后，最后一个数一定是数组中最大的一个数，所以在比较第二趟的时候，最后一个数是不参加比较的。
 * 　　　　(5)在第二趟比较完成后，倒数第二个数也一定是数组中倒数第二大数，所以在第三趟的比较中，最后两个数是不参与比较的。
 * 　　　　(6)依次类推，每一趟比较次数减少依次
 */
public class BubbleSort {
    public int[] sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            //最大值都会排序在数组的最后面了，所以只需要排序前面的数组即为：n-i-1
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j);
            }
        }

        return arr;
    }

    public void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
