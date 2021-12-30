package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permute2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //必须要先进行排序
        Arrays.sort(nums);
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(nums, nums.length, 0, path, lists, used);

        return lists;
    }

    //使用回溯算法，复用permute的46算法的补充，去掉重复
    public void dfs(int[] nums, int len, int dep, ArrayList<Integer> path, List<List<Integer>> lists, boolean[] used) {
        if (len == dep) {
            lists.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            //这里和46算法多了一步去除重复
            if (used[i] || (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]))
                continue;

            used[i] = true;
            path.add(nums[i]);
            dfs(nums, len, dep + 1, path, lists, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
