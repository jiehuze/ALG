package com.jiehu.code.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 分析：
 * <p>
 * （top，left）           (top, right)
 * ------------------------
 * ｜ 1 ｜ 2 ｜ 3 ｜ 4 ｜ 5 ｜
 * ｜ 6 ｜ 7 ｜ 8 ｜ 9 ｜10 ｜
 * ｜11 ｜12 ｜13 ｜14 ｜15 ｜
 * ------------------------
 * (bottom, left)         (bottom, right)
 * <p>
 * 方向:
 * 上：（top，left）    ----->  (top, right)
 * 右：（top+1，right） ----->  (bottom, right)
 * 下：（bottom, right-1） ------>  (bottom, left)
 * 左：（bottom-1, left）  ------>  (top+1, left)
 * <p>
 * 下和左操作时，需要判断当前left和top是否超出，不超出可以执行，否则直接退出
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> restList = new ArrayList<>();

        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {

            //上
            for (int i = left; i <= right; i++) {
                restList.add(matrix[top][i]);
            }
            //右
            for (int j = top + 1; j <= bottom; j++) {
                restList.add(matrix[j][right]);
            }
            if (top < bottom && left < right) {
                //下
                for (int i = right - 1; i >= left; i--) {
                    restList.add(matrix[bottom][i]);
                }
                //左
                for (int i = bottom - 1; i >= top + 1; i--) {
                    restList.add(matrix[i][left]);
                }
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return restList;
    }
}
