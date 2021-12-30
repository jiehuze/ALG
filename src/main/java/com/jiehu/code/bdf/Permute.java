package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Permute {
    /**
     * 使用回溯算法，做深度搜索遍历
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int dep = 0;
        int len = nums.length;
        boolean[] used = new boolean[len];

        dfs(nums, len, dep, path, lists, used);

        return lists;
    }

    public void dfs(int[] nums, int len, int dep, ArrayList<Integer> path, List<List<Integer>> lists, boolean[] used) {
        if (len == dep) {
            lists.add(new ArrayList<>(path));
            return;
        }

        //每个叶子节点都要遍历到
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                //搜索下去
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, len, dep + 1, path, lists, used);
                //回归回来
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
