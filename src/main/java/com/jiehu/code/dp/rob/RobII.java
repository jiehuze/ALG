package com.jiehu.code.dp.rob;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * https://leetcode.cn/problems/house-robber-ii/
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class RobII {
    public int rob(int[] nums) {
        /**
         * 分析思考：
         * 当前的nums为一个环形的数组，头和尾时挨着的；所以我们可以将这个数组分成两个部分：
         * 1）去掉头部分，为nums的下标为： 1 -- nums.lenght-1
         * 2) 去掉尾部分，为nums的下标为： 0 -- nums.lenght-2
         * 所以只需要取两个部分的最大的值即为所偷的最大金额
         */

        if (nums.length == 1) return nums[0];

        return Math.max(dpFunc(Arrays.copyOfRange(nums, 1, nums.length)), dpFunc(Arrays.copyOfRange(nums, 0, nums.length - 1)));

    }

    /**
     * 动态规范方式的函数如下
     */
    public int dpFunc(int[] partOfNums) {
        /**
         * 1.  dp[j]定义： 下标为j最多可以偷的钱数
         */
        int[] dp = new int[partOfNums.length];
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
        if (partOfNums.length == 1) return partOfNums[0];
        dp[0] = partOfNums[0];
        dp[1] = Math.max(partOfNums[0], partOfNums[1]);
        for (int j = 2; j < partOfNums.length; j++) {
            dp[j] = Math.max(dp[j - 1], dp[j - 2] + partOfNums[j]);
        }

        return dp[partOfNums.length - 1];
    }
}
