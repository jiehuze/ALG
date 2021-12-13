package com.jiehu.code.greedy;

/**
 * 330. 按要求补齐数组
 * https://leetcode-cn.com/problems/patching-array/
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 * 示例 1:
 * 输入: nums = [1,3], n = 6
 * 输出: 1
 * 解释:
 * 根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
 * 现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
 * 其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
 * 所以我们最少需要添加一个数字。
 * 示例 2:
 * 输入: nums = [1,5,10], n = 20
 * 输出: 2
 * 解释: 我们需要添加 [2, 4]。
 * 示例 3:
 * 输入: nums = [1,2,2], n = 5
 * 输出: 0
 */
public class MinPatches {
    //对于正整数 x，如果区间 [1,x-1] 内的所有数字都已经被覆盖，且 x 在数组中，则区间 [1,2x−1] 内的所有数字也都被覆盖
    //https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode-solu-klp1/
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                // 从x=1开始依次判断，每次如果x在数组中，则更新x为x+nums[index]，因为根据贪心思想，我们总保证区间小于x的所有值会被覆盖掉，因此x+1，x+2，... x+nums[index]-1都会被覆盖到，更新x += nums[index]。
                x += nums[index];
                index++;
            } else {
                // 从x=1开始依次判断，每次如果x在数组中，则更新x为x+nums[index]，因为根据贪心思想，我们总保证区间小于x的所有值会被覆盖掉，因此x+1，x+2，... x+nums[index]-1都会被覆盖到，更新x += nums[index]。
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}
