package com.jiehu.code.SearchBinary;

/**
 * 162. 寻找峰值
 * <p>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 提示：
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 */
public class MountainPeakElement {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums);
    }

    /**
     * 方法一：从头开始遍历,效率可以
     */

    public int whileSearch(int[] nums) {
        int n = nums.length;

        if (n < 2) return 0;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                if (i + 1 == n || nums[i] > nums[i + 1])
                    return i;
            }
        }

        return 0;
    }

    /**
     * 方法二：使用二分法，
     * 先选取一个坐标，分析坐标左右的数据，如果：
     * nums[mid] > nums[mid+1] 说明右侧有峰值，可以从：left -> mid
     * nums[mid] <= nums[mid+1] 说明左侧有峰值，可以从：mid+1 -> right
     * <p>
     * 强调：必须有递增的，否则就会进入死循环，要不left = mid+1，或者right = mid-1
     */
    public int binarySearch(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            //千万不要越过做：mid-1,否则会跳过峰值
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}



































