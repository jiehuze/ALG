package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, target, 0, 0, path, lists);

        return lists;
    }

    public void dfs(int[] candidates, int target, int index, int sum, ArrayList<Integer> path, List<List<Integer>> lists) {
        if (sum == target) {
            lists.add(new ArrayList<>(path));
            return;
        }

        if (sum > target) return;

        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && i > index && candidates[i] == candidates[i - 1])
                continue;
            path.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, target, i + 1, sum, path, lists);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
