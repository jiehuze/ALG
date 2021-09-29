package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 */
public class LevelOrderTree {

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

    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();

        if (root != null)
            dfs(lists, root, 0);
        return lists;
    }

    /**
     * dfs深度搜索: 方法很巧妙，代码量少而且很简洁：只需要将每一层定义对应的数组，根据不同层数组存储即可
     */
    private void dfs(ArrayList<List<Integer>> lists, Node root, int level) {
        //很巧妙，没有这一层数组，就建设这一层数组
        if (lists.size() <= level) {
            lists.add(new ArrayList<>());
        }

        lists.get(level).add(root.val);
        for (Node child : root.children) {
            if (child != null) {
                dfs(lists, child, level + 1);
            }
        }
    }

    /**
     * bfs迭代可以实现
     * 注意：1）迭代必须使用堆栈容器：如linkedlist或者Deque
     * 2）必须注意层级关系
     */
    private List<List<Integer>> bfs(Node root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;

        LinkedList<Node> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) { //层级，********
                Node cur = stack.pollLast();
                list.add(cur.val);
                if (cur.children != null) {
//                    Collections.reverse(cur.children);
                    for (Node node : cur.children) { //层级下的所有元素：要不就是插入头，或者插入尾部
                        if (node != null)
                            stack.addFirst(node);
                    }
                }
            }
            lists.add(list);
        }

        return lists;
    }
}
