package com.jiehu.code.bdf;

import java.util.ArrayList;

/**
 * 37. 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 示例：
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * 输出：
 * [["5","3","4","6","7","8","9","1","2"],
 * ["6","7","2","1","9","5","3","4","8"],
 * ["1","9","8","3","4","2","5","6","7"],
 * ["8","5","9","7","6","1","4","2","3"],
 * ["4","2","6","8","5","3","7","9","1"],
 * ["7","1","3","9","2","4","8","5","6"],
 * ["9","6","1","5","3","7","2","8","4"],
 * ["2","8","7","4","1","9","6","3","5"],
 * ["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 */
public class SolveSudoku {
    /**
     * 回溯算法，深度遍历
     * 需要三个数组保存：每一个数保存了就标记为已经使用
     * 1。行数据
     * 2。列数据
     * 3，3宫格数据
     * 可以使用集中存储：1，现在用的数组；2：使用但数组的按位；3：使用枚举
     */
    boolean[][] line = new boolean[9][9]; //9行，9个数
    boolean[][] colume = new boolean[9][9]; //9列，9个数
    boolean[][][] block = new boolean[3][3][9]; // 3*3个块，每块9个数
    ArrayList<int[]> spaces = new ArrayList<>(); //用于记录没有填充的位置,必须要用这个，不然无法递归下去,否则会将已存在的位置弄错，********重要******

    //有比较回溯时是不是已经遍历到最后
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = colume[j][digit] = block[i / 3][j / 3][digit] = true;
                } else {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int row = space[0];
        int col = space[1];

        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!line[row][digit] && !colume[col][digit] && !block[row / 3][col / 3][digit]) {
                line[row][digit] = colume[col][digit] = block[row / 3][col / 3][digit] = true;
                board[row][col] = (char) ('0' + digit + 1);
                dfs(board, pos + 1);
                line[row][digit] = colume[col][digit] = block[row / 3][col / 3][digit] = false;
            }
        }
    }
}
