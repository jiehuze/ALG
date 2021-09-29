package com.jiehu.code.bdf;

import java.util.*;

/**
 * N 叉树前序输出
 */
public class PreorderTree {

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

    public List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        dfs(root, list);
        return list;
    }

    public void dfs(Node root, ArrayList<Integer> list) {
        if (root.children == null) return;

        list.add(root.val);
        for (Node node : root.children) {
            dfs(node, list);
        }
    }

    /**
     * 与二叉树类似的思路：
     * 1)栈中存放未遍历的结点，遍历完当前结点后，将孩子结点逆序入栈（保证出栈顺序是顺序的）
     * 2)一定要倒序数据后，写入栈中，才能保证先入后出的栈原则
     */
    public List<Integer> bfs(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            // 栈顶元素弹出后立刻加入到结果集
            Node cur = stack.pollLast();
            list.add(cur.val);

            //将所有自节点逆序写入栈
            if (cur.children != null) {
                Collections.reverse(cur.children);
                //和上面的collections是一样的，一定要倒序输出
//                for (int i = cur.children.size() - 1; i >= 0; --i){
//
//                }
                for (Node child : cur.children) {
                    if (child != null) {
                        stack.add(child);
                    }
                }
            }
        }


        return list;
    }
}
