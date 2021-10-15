package com.jiehu.code.SearchBinary;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //这两句是可有可无的，
        if (nums[0] > target) return 0;
        if (nums[right - 1] < target) return right;

        while (left < right) {
            int mid = left + (right - left) / 2;
//            int mid = ((right - left) >> 1) + left;  这种写法也可以

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
        }

        return left + 1;
    }
}
