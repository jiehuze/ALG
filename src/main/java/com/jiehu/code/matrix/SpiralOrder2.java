package com.jiehu.code.matrix;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 问题分析：每个矩阵方格数值为：matrix[i][j] = (n*3) + (j+1)
 */
public class SpiralOrder2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rows = n, cols = n;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;

        while (left <= right && top <= bottom) {
            //上
            for (int i = left; i <= right; i++) {
                write(matrix, n, num, top, i);
                num++;
            }
            //右
            for (int i = top + 1; i <= bottom; i++) {
                write(matrix, n, num, i, right);
                num++;
            }

            if (left < right && top < bottom) {
                //下
                for (int i = right - 1; i >= left; i--) {
                    write(matrix, n, num, bottom, i);
                    num++;
                }

                //左
                for (int i = bottom - 1; i >= top + 1; i--) {
                    write(matrix, n, num, i, left);
                    num++;
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return matrix;
    }

    public void write(int[][] matrix, int n, int num, int x, int y) {
        matrix[x][y] = num;
    }

    /**
     * 另一种题型：按照顺序的二维数组，顺时针螺旋读取后，输出读取后的矩阵
     */
    public void write2(int[][] matrix, int n, int num, int left, int top) {
        int x = num / n;
        int y = num % n;
        matrix[x][y] = n * left + top + 1;
    }
}









































