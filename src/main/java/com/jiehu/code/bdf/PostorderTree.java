package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * 进阶：
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 *
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * 提示：
 *
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 *
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 */
public class PostorderTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        dfs(root, list);
        return list;
    }

    /**
     * 第一种方法：dfs深度遍历
     */
    public void dfs(Node root, ArrayList<Integer> list) {
        if (root == null) return;

        for (Node node : root.children) {
            if (node != null)
                dfs(node, list);
        }
        list.add(root.val);

    }

    /**
     * 方法二：bfs，迭代算法
     * 与N叉前叙不同，1）利用linkedList，将数据总是写入第一个，这样输出时就是正序
     * 2） 原始数据不需要在进行反转，直接使用即可
     */
    public List<Integer> bfs(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;

        LinkedList<Node> stack = new LinkedList<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pollLast();
            list.addFirst(cur.val);
            if (cur.children != null) {
                Collections.reverse(cur.children);
                for (Node node : cur.children) {
                    stack.add(node);
                }
            }

        }

        return list;
    }
}
