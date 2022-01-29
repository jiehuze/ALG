package com.jiehu.code.tree;

import com.jiehu.code.tree.vo.TreeNode;

import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {

        return bfs(root);
    }

    /**
     * 方法一：广度搜索
     */
    public int bfs(TreeNode root) {
        int maxdepth = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        }

        stack.offer(root);

        while (!stack.isEmpty()) {
            int size = stack.size();
            maxdepth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.poll();
                if (node.left != null) {
                    stack.offer(node.left);
                }

                if (node.right != null) {
                    stack.offer(node.right);
                }
            }
        }

        return maxdepth;
    }

    int maxdepth = 0;

    public void dfs(TreeNode root, int level) {
        maxdepth = Math.max(level, maxdepth);

        if (root.right != null) {
            dfs(root.right, level + 1);
        }

        if (root.left != null) {
            dfs(root.left, level + 1);
        }
    }
}
