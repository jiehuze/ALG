package com.jiehu.code.bdf;

/**
 * 79. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 * 与：212. 单词搜索 II FindWords
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 */
public class Exist {
    //4个方向
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        //从第一个遍历，只要满足就返回
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, 0, 0))
                    return true;
            }
        }
        return false;
    }

    //回溯算法：将经过的路径标记为#，后面不要在走这个，深度搜素是遇到不符合字符时，直接hui归走另一条路，将标记清除
    public boolean dfs(char[][] board, String word, int index, int x, int y) {
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        //该临时变量只在其作用域起作用
        char c = board[x][y];
        board[x][y] = '#';
        for (int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if (dx >= 0 && dx < board.length && dy >= 0 && dy < board[0].length && board[dx][dy] != '#') {
                if (dfs(board, word, index + 1, dx, dy))
                    return true;
            }
        }
        board[x][y] = c;

        return false;
    }
}
