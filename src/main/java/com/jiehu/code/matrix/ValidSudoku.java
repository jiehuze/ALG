package com.jiehu.code.matrix;

import java.util.HashMap;

/**
 * 36. 有效的数独
 * <p>
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        return false;
    }

    /**
     * 方法一：将3个规则都跑一遍
     */
    public boolean alg1(char[][] board) {
        //按照行遍历
        for (int i = 0; i < 9; i++) {
            HashMap<Integer, Integer> list = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                int ch_int = board[i][j] - '0';
                if (ch_int >= 0 && ch_int <= 9) {
                    if (list.containsKey(ch_int))
                        return false;
                    list.put(ch_int, i);
                }
            }
        }

        //按照列遍历
        for (int i = 0; i < 9; i++) {
            HashMap<Integer, Integer> list = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                int ch_int = board[j][i] - '0';
                if (ch_int >= 0 && ch_int <= 9) {
                    if (list.containsKey(ch_int))
                        return false;
                    list.put(ch_int, j);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isRepetition(board, i * 3, j * 3) == false) return false;
            }
        }


        return true;
    }

    //是否重复的3*3矩阵
    public boolean isRepetition(char[][] board, int x, int y) {
        HashMap<Integer, Integer> list = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int ch_int = board[x + i][y + j] - '0';
                if (ch_int >= 0 && ch_int <= 9) {
                    if (list.containsKey(ch_int))
                        return false;
                    list.put(ch_int, 0);
                }
            }

        }

        return true;
    }

    /**
     * 方法二：只需要跑一遍就可以，但是空间复杂要高，初始化3个数组,用下标记录行，列，矩阵数据，每个方格存储个数，当个数大于1时，说明有重复，直接返回false
     * 执行效率要高一点，但是空间会浪费
     */
    public boolean alg2(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
