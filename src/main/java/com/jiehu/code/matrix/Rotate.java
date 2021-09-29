package com.jiehu.code.matrix;

/**
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * 方法二：
 * 在原有矩阵中进行旋转，
 * 我们可以使用一个临时变量 \textit{temp}temp 完成这四项的原地交换：
 * <p>
 * <p>
 * 顺时针
 * temp                     = matrix[row][col]
 * matrix[row][col]         = matrix[n−col−1][row]
 * matrix[n−col−1][row]     = matrix[n−row−1][n−col−1]
 * matrix[n−row−1][n−col−1] = matrix[col][n-row-1]
 * matrix[col][n−row−1]     = temp
 * ​
 * 逆时针
 * temp                     = matrix[row][col]
 * matrix[row][col]         = matrix[col][n-row-1]
 * matrix[col][n-row-1]     = matrix[n-row-1][n-col-1]
 * matrix[n-row-1][n-col-1] = matrix[n-col-1][row]
 * matrix[n-col-1][row]     = temp
 * ​
 * ***********  记住吧  ************
 * 当 n 为偶数时，我们需要枚举 n^2 / 4 = (n/2)×(n/2) 个位置，可以将该图形分为四块，以 4×4 的矩阵为例：
 * 当 n 为奇数时，由于中心的位置经过旋转后位置不变，我们需要枚举 (n^2-1) / 4 = ((n−1)/2)×((n+1)/2) 个位置，需要换一种划分的方式，以 5×5 的矩阵为例：
 */
public class Rotate {
    public void rotate1(int[][] matrrix) {
        int n = matrrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix_new[j][n - i - 1] = matrrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrrix[i][j] = matrix_new[i][j];
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = temp;
            }
        }
    }
}
