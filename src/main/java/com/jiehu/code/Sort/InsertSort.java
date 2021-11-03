package com.jiehu.code.Sort;

/**
 * 插入排序：
 * 从第一个开始遍历，依次互换位置，将当前数据插入到对应的下标下
 * https://www.cnblogs.com/coding-996/p/12275710.html
 */
public class InsertSort {
    public int[] sort(int[] nums) {
        insertSort(nums);

        return nums;
    }

    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                //互换位置，否则不互换位置
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    //交互数据
    public void swap(int[] arrays, int index, int index2) {
        int tmp = arrays[index];
        arrays[index] = arrays[index2];
        arrays[index2] = tmp;
    }
}
