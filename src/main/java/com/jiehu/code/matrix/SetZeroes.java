package com.jiehu.code.matrix;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 进阶：
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {

    }

    /**
     * 方法一：使用比较数组，记录要写为0的行和列
     */
    public void setZeroes1(int[][] matrix) {
        int rowlen = matrix.length;
        int collen = matrix[0].length;

        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                if (rows[i] == 1 || cols[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }

    /**
     * 方法二：使用2个标记变量
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        //先比较两个边，如果边为0，那么行和列就是空
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //根据两个边，如果为0，那么这个方格也是0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

    }

    /**
     * 方法二：使用1个标记变量（优化）
     */
    public void setZeroes3(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        //还是先标记两边，然后根据两个边在遍历
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }

    }

}






































