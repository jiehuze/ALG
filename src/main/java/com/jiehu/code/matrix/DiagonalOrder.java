package com.jiehu.code.matrix;

/**
 * 498. 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 */
public class DiagonalOrder {
    //[[2,3]]
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] retList = new int[rows * cols];
        int n = 0;

        int x = 0, right = cols - 1, y = 0, bottom = rows - 1;

        while (x <= bottom && y <= right) {
            //向右上角遍历
            while (x >= 0 && y <= right) {
                retList[n++] = mat[x][y];
                if (y == right) {
                    x++;
                    break;
                }
                if (x == 0) {
                    y++;
                    break;
                }

                x--;
                y++;
            }

            //向左下角遍历
            while (x <= bottom && y >= 0) {
                retList[n++] = mat[x][y];
                if (x == bottom) {
                    y++;
                    break;
                }
                if (y == 0) {
                    x++;
                    break;
                }
                x++;
                y--;
            }

        }

        return retList;
    }
}
