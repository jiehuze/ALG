package com.jiehu.code.matrix;

/**
 * 867. 转置矩阵
 * <p>
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 */
public class Transpose {
    public int[][] transpose(int[][] matrix) {


        return matrix;
    }

    /**
     * @param matrix 矩阵为宽高一样的正方形
     * @return 归纳法：借助一个int就可以
     */
    public int[][] square(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //正方形矩阵可以使用这个，否则不行
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i + 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        return matrix;
    }

    /**
     * @param matrix 正方形和长方形
     * @return 使用贪心算法
     */
    public int[][] rectangle(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transMatrix = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transMatrix[i][j] = matrix[j][i];
            }
        }

        return transMatrix;
    }
}
