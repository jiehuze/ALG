package com.jiehu.code.bdf;

import com.jiehu.code.tree.TreeNode;

import java.util.*;

/** 34
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> lists = new ArrayList<>();

        LinkedList<Integer> list = new LinkedList<>();
        dfs(root, 0, targetSum, list, lists);

        return lists;
    }

    /**
     * 深度搜索
     */
    public void dfs(TreeNode node, int sum, int targetSum, LinkedList<Integer> list, List<List<Integer>> lists) {
        if (node == null) return;

        sum += node.val;
        //递归中的递进
        list.offerLast(node.val);
        if (node.right == null && node.left == null) {
            if (targetSum == sum) {
                lists.add(new LinkedList<>(list));
            }
        }

        dfs(node.left, sum, targetSum, list, lists);
        dfs(node.right, sum, targetSum, list, lists);

        //递归中的归
        list.pollLast();
    }

    public void bfs(TreeNode node, int targetSum, List<List<Integer>> lists) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> queueSum = new LinkedList<Integer>();
        HashMap<TreeNode, TreeNode> nodeMap = new HashMap<>();
        if (node == null) return;
        queue.offer(node);
        queueSum.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                Integer pollsum = queueSum.poll();
                if (poll.left == null && poll.right == null) {
                    if (pollsum + poll.val == targetSum) {
                        getPath(lists, nodeMap, poll);
                    }
                }

                //如果大于target值了，就不需要往队列中写入了，因为不可能为true
                if (poll.left != null) {
                    queueSum.offer(pollsum + poll.val);
                    queue.offer(poll.left);
                    nodeMap.put(poll.left, poll);
                }

                if (poll.right != null) {
                    queueSum.offer(pollsum + poll.val);
                    queue.offer(poll.right);
                    nodeMap.put(poll.right, poll);
                }
            }
        }
    }

    public void getPath(List<List<Integer>> lists, HashMap<TreeNode, TreeNode> nodeMap, TreeNode node) {
        LinkedList<Integer> tmp = new LinkedList<>();
        while (node != null) {
            tmp.add(node.val);
            node = nodeMap.get(node);
        }

        Collections.reverse(tmp);

        lists.add(tmp);
    }
}
