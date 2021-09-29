package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 叉树后序输出
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
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
