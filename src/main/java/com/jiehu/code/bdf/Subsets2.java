package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Subsets2 {
    /**
     * 去除重复的子集，必须做两点：
     * 1。 必须进行排序，否则无法剔除重复
     * 2。必须用上一个和当前比较是否是一样的
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        //必须先进行排序，在进行组合
        Arrays.sort(nums);

        dfs(nums, 0, path, lists);
        return lists;
    }

    /**
     * 递归的方式，有递进，有回归
     */
    public void dfs(int[] nums, int index, ArrayList<Integer> path, List<List<Integer>> lists) {
        if (index > nums.length) return;
        lists.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            //增加这个判断，就可以去除重复的的子集
            if (i > 0 && i > index && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            dfs(nums, i + 1, path, lists);
            path.remove(path.size() - 1);
        }
    }
}
