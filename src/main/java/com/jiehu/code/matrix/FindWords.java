package com.jiehu.code.matrix;

import java.util.*;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * <p>
 * 和黄金矿工比较像，求的数不同而已
 */
public class FindWords {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        Trie trie = new Trie();

        /**
         * 将word进行拆分到hash及子hash中，行程一个列表树，根据列表树进行顺序搜索
         * 叶子节点即为最终的word值，只要搜索到最后叶子节点即为有效，标记，
         * 过程中将路过的字符修改为非法字符 "#"，这样就不会再从该点经过
         */

        for (String word : words) {
            trie.insert(word);
        }

        /**
         * 要从头开始，一直到结尾
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, ans);
            }
        }

        return new ArrayList<String>(ans);
    }

    /**
     * @param board
     * @param now
     * @param i1
     * @param j1
     * @param ans   嵌套遍历下去，直到找到最后。并找到服务要求的叶子节点后，标记写入HashSet中，
     *              HashSet的特性就是自动去重
     */
    public void dfs(char[][] board, Trie now, int i1, int j1, Set<String> ans) {
        if (!now.children.containsKey(board[i1][j1])) {
            return;
        }

        char c = board[i1][j1];

        now = now.children.get(c);
        if (!"".equals(now.words)) {
            ans.add(now.words);
        }

        board[i1][j1] = '#';
        /**
         * 根据4个方向搜索
         */
        for (int[] dir : dirs) {
            int i2 = i1 + dir[0], j2 = j1 + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length)
                dfs(board, now, i2, j2, ans);
        }

        board[i1][j1] = c;
    }

    class Trie {
        String words;
        HashMap<Character, Trie> children;

        public Trie() {
            this.words = "";
            this.children = new HashMap<>();
        }

        public void insert(String words) {
            Trie cur = this;
            char[] chars = words.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (!cur.children.containsKey(chars[i])) {
                    cur.children.put(chars[i], new Trie());
                }
                cur = cur.children.get(chars[i]);
            }

            cur.words = words;
        }
    }
}
