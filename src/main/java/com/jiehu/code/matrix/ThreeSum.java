package com.jiehu.code.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 分析：
         *  双指针移动：
         *  1）先进行数据排序，排序后，计算会更方便，有规律  ****
         *  2）确定L，R指针，L为i+1，R为左右侧，指针游动
         *  3)过程中，要去重，不然会出现多个list重复问题
         */
        ArrayList<List<Integer>> lists = new ArrayList<>();

        if (nums.length < 3) {
            return lists;
        }

        Arrays.sort(nums);
        int L = 0, R = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重

            L = i + 1;
            R = nums.length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    List<Integer> integers = Arrays.asList(nums[i], nums[L], nums[R]);
                    lists.add(integers);
                    while (L < R && nums[L] == nums[L + 1]) L++; //去重
                    while (L < R && nums[R] == nums[R - 1]) R--; //去重
                    L++;
                    R--;
                } else if (sum > 0) { //和大于0，说明右侧数过大了，需要左移动，因为左侧任何数都不可能<0
                    R--;
                } else { //同理
                    L++;
                }
            }
        }

        return lists;
    }
}
