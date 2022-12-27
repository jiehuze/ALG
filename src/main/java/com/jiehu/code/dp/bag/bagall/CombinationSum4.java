package com.jiehu.code.dp.bag.bagall;

/**
 * 377. 组合总和 Ⅳ
 * https://leetcode.cn/problems/combination-sum-iv/
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 * 输入：nums = [9], target = 3
 * 输出：0
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        /**
         * 1. 定义dp[j], 容量为j时的组合排列子集个数
         */
        int[] dp = new int[target + 1];

        /**
         * 2。递推公式，涉及到个数问题，递推公式为：
         *      dp[j] += dp[j-nums[i]]
         * 3. 初始dp[0] = 1
         * 4. 循环顺序：因为是排列，所以应该是：背包后物品,从小到大
         */
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j > nums[i])
                    dp[j] += dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
