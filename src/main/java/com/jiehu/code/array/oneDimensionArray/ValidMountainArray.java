package com.jiehu.code.array.oneDimensionArray;

/**
 * 有效的山脉数组
 * <p>
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * arr.length >= 3
 * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * <p>
 * 方法：双指针，一起移动
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;

        int l = 0, r = arr.length - 1;

        while (l != r) {
            //如果不能碰面，说明不是山，直接返回
            if (arr[l] >= arr[l + 1] && arr[r] >= arr[r - 1])
                return false;

            if (arr[l] < arr[l + 1]) {
                l++;
            }
            if (arr[r] < arr[r - 1]) {
                r--;
            }

            if (r == 0 || r == arr.length-1)
                return false;
        }

        if (r == 0 || r == arr.length-1)
            return false;

        return true;
    }
}
