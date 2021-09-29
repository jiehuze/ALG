package com.jiehu.code.array.oneDimensionArray;

/**
 * 665. 非递减数列
 * <p>
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 */
public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0)
            return false;

        int cnt = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                //第一个字符传不能被替换,因为第一个字符可能会非常大，没有办法替换
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }

        return true;
    }
}
