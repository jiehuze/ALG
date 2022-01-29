package com.jiehu.code.tree;

import com.jiehu.code.tree.vo.TreeNode;

import java.util.LinkedList;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * <p>
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    /**
     * 方法一：深度搜索，必须所有都迭代到，才能回溯，所以效率不高
     */
    public boolean dfs(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val == q.val && dfs(p.right, q.right) && dfs(p.left, q.left)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 方法二： 广度搜索会速度快一点
     */
    public boolean bfs(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pstack = new LinkedList<>();
        LinkedList<TreeNode> qstack = new LinkedList<>();

        if (q != null)
            qstack.offer(q);
        if (p != null)
            pstack.offer(p);

        while (!qstack.isEmpty() && !pstack.isEmpty()) {
            TreeNode ptn = pstack.poll();
            TreeNode qtn = qstack.poll();
            if (ptn == null || qtn == null) return false;

            TreeNode pl = ptn.left, pr = ptn.right;
            TreeNode ql = qtn.left, qr = qtn.right;

            if (pl == null ^ ql == null) return false;
            if (pr == null ^ qr == null) return false;

            if (ptn.val != qtn.val) return false;

            if (ql != null) {
                qstack.offer(qtn.left);
            }

            if (pl != null) {
                pstack.offer(ptn.left);
            }

            if (qr != null) {
                qstack.offer(qtn.right);
            }

            if (pr != null) {
                pstack.offer(ptn.right);
            }
        }

        return qstack.isEmpty() && pstack.isEmpty();
    }
}
