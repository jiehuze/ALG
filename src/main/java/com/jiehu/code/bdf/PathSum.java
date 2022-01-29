package com.jiehu.code.bdf;

import com.jiehu.code.tree.vo.TreeNode;

import java.util.LinkedList;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * 提示：
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int sum = 0;
        return dfs(root, sum, targetSum);
    }

    /**
     * 深度搜索
     */
    public boolean dfs(TreeNode node, int sum, int targetSum) {
        if (node == null) return false;
        sum += node.val;
        if (node.right == null && node.left == null) {
            return sum == targetSum;
        }
        return dfs(node.left, sum, targetSum) || dfs(node.right, sum, targetSum);
    }

    /**
     * 广度搜索
     */
    public boolean bfs(TreeNode node, int targetSum) {
        if (node == null) return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    if (poll.val == targetSum)
                        return true;
                }

                //如果大于target值了，就不需要往队列中写入了，因为不可能为true
                if (poll.left != null) {
                    poll.left.val += poll.val;
                    //有可能有负数
//                    if (poll.left.val <= targetSum)
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    poll.right.val += poll.val;
//                    if (poll.right.val <= targetSum)
                    queue.offer(poll.right);
                }
            }

        }

        return false;
    }
}
