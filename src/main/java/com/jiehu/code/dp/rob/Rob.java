package com.jiehu.code.dp.rob;

/**
 * 198. 打家劫舍
 * https://leetcode.cn/problems/house-robber/
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class Rob {
    public int rob(int[] nums) {
        /**
         * 1.  dp[j]定义： 下标为j最多可以偷的钱数
         */
        int[] dp = new int[nums.length];
        /**
         * 2. 递推公式：
         *  分析： 当前有两种状态
         *   1）偷： dp[j] = dp[j-2]+nums[j] j前一个是不允许偷的，
         *   2）不偷： dp[j] = dp[j-1] j这个不偷，那到j下标时，最大就是前一个的值
         *
         *  3. 初始化： dp[0] = nums[0]
         *             dp[1] = max(dp[0], dp[1])
         *  4. 遍历顺序，为从小到大
         */
        if (nums.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int j = 2; j < nums.length; j++) {
            dp[j] = Math.max(dp[j - 1], dp[j - 2] + nums[j]);
        }

        return dp[nums.length - 1];
    }
}
