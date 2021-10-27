package com.jiehu.code.bdf;

import java.util.*;

/**
 * 589. N 叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * 进阶：
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * 提示：
 *
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
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
