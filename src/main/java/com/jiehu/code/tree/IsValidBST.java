package com.jiehu.code.tree;

import com.jiehu.code.tree.vo.TreeNode;

import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        if (root.left != null) {
            if (root.left.val > root.val) {
                return false;
            } else if (dfs(root.left)) {
                return true;
            } else {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.val < root.val) {
                return false;
            } else if (dfs(root.right)) {
                return true;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean bfs(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        if (root != null) {
            stack.offer(root);
        }

        if (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            TreeNode nl = node.left, nr = node.right;
            if (nl != null) {
                if (nl.val > node.val) return false;
                stack.offer(nl);
            }
            if (nr != null) {
                if (nr.val < node.val) return false;
                stack.offer(nr);
            }
        }

        return true;
    }
}
