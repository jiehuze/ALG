package com.jiehu.code.array.oneDimensionArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. 缺失的区间
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 * <p>
 * 示例：
 * <p>
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * <p>
 * 输出: ["2", "4->49", "51->74", "76->99"]
 */
public class MissingRanges {
    /**
     * 方法一：使用指针方式
     * {0, 1, 3, 50, 75};
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> list = new ArrayList<>();

        int l = 0, r = nums.length - 1;
        boolean ra = true;
        while (ra) {
            ra = false;
            if (nums[l] < lower && l < nums.length - 1) {
                l++;
                ra = true;
            }
            if (nums[r] > upper && r > 0) {
                r--;
                ra = true;
            }
        }

        for (int i = l; i <= r; i++) {
            if (i == l && nums[i] != lower) {
                list.add(lower + "->" + (nums[i] - 1));
            } else if (i == r && nums[i] != upper) {
                list.add((nums[i] + 1) + "->" + upper);
            } else if (nums[i] + 1 != nums[i + 1]) {
                if (nums[i + 1] - nums[i] == 2) {
                    list.add((nums[i] + 1) + "");
                } else {
                    list.add((nums[i] + 1) + "->" + (nums[i + 1] - 1));
                }
            }
        }

        return list;
    }
}
