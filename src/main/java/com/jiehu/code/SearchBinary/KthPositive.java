package com.jiehu.code.SearchBinary;

/**
 * 1539. 第 k 个缺失的正整数
 * <p>
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 */
public class KthPositive {
    /**
     * 二分法
     */
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] - mid - 1 >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return k - (arr[left - 1] - (left - 1) - 1) + arr[left - 1];
    }
}
