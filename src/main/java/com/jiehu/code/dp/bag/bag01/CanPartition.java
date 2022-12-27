package com.jiehu.code.dp.bag.bag01;

/**
 * 416. 分割等和子集
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class CanPartition {
    /**
     * 典型的01背包问题；分析：
     * 因为使得两个组合为子集，并且每一个元素只能选择一个，所以是01背包问题；
     * 如果能被分配为两个子集并且和相等，说明数组的总和能被2整除，如果不能被2整除说明不能分为两个子集
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        //定义dp[i]: 总和为i时的组合时最大组合数
        int[] dp = new int[target + 1];
        /**
         * 2。 递推公式
         *  状态： 1。 不放进： dp[j] = dp[j]
         *        2. 放进： dp[j] = dp[j-nums[i]] + nums[i]
         *   最后dp[j] = max(dp[j],dp[j-nums[i]] + nums[i])
         */
        for (int i = 0; i < nums.length; i++) { //物品
            for (int j = target; j >= nums[i]; j--) { //背包， 保证物品被选择一次，需要背包从大到小遍历
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        for (int p : dp) {
            System.out.println(p);
        }

        if (dp[target] == target) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};

        canPartition(nums);
    }
}
