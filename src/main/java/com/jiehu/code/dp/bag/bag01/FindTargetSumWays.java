package com.jiehu.code.dp.bag.bag01;

/**
 * 494. 目标和
 * https://leetcode.cn/problems/target-sum/
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        /**1.定义dp[j]数组：和为j时的组合种类
         * 根本本题： target有两部分组成，加法的总数和减法的总数，加上加法的总数为x
         *  target = x - (sum-x)
         *  x = (target+sum)/2
         *  1）当：x不能被整除时，说明不存在这个target；
         *  2）当： target的绝对值大于sum时，也是没有方案的
         *
         *  所以当达到target时，加法的总和为x的组合种类,就可以推导出来
         */
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int size = (target + sum) / 2;

        if ((target + sum) % 2 != 0) return 0;
        if (Math.abs(target) > sum) return 0;

        int[] dp = new int[size + 1];
        /**
         * 2。 推导公式：
         * 状态： 比如有5个nums；
         *  当选择了1个nums[1]时，还有 dp[4]种方法凑成容量为5的背包
         *  当选择了2个nums[i]时，还有 dp[3]种方法凑成容量为5的背包
         *  当选择了3个nums[i]时，还有 dp[2]种方法凑成容量为5的背包
         *  当选择了4个nums[i]时，还有 dp[1]种方法凑成容量为5的背包
         *  当选择了5个nums[i]时，还有 dp[0]种方法凑成容量为5的背包
         *  哪有多少种方法呢：就是将所有的方法加起来
         *  dp[j] += dp[j-nums[i]];
         */
        // 3. 初始化dp， dp[0] = 1
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) { //背包 01背包从大到小遍历
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
























