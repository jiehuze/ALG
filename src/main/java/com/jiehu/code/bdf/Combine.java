package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(n, 1, k, path, lists);

        return lists;
    }

    /**
     * 回溯算法
     * 注意：终止条件，重点要做剪枝操作减小无效计算
     */
    public void dfs(int n, int index, int k, ArrayList<Integer> path, List<List<Integer>> lists) {
        if (path.size() == k) {
            lists.add(new ArrayList<>(path));
            return;
        }

        //剪枝,很有效果，直接从10ms降低到1ms执行完成
        if (path.size() + n - index + 1 < k)
            return;

        for (int i = index; i <= n; i++) {
            path.add(i);
            dfs(n, i + 1, k, path, lists);
            path.remove(path.size() - 1);
        }
    }
}
