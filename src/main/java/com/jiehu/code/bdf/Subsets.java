package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Subsets {
    /**
     * 回溯算法
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

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
            path.add(nums[i]);
            dfs(nums, i + 1, path, lists);
            path.remove(path.size() - 1);
        }
    }

}
