package com.jiehu.code.SearchBinary;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binary2Times(matrix, target);
    }

    /**
     * 方法一：两次二分查找
     */
    public boolean binary2Times(int[][] matrix, int target) {
        int index = 0;
        int left = -1, right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (matrix[mid][0] <= target)
                left = mid;
            else
                right = mid - 1;
        }
        index = left;
        if (index < 0) return false;
        left = 0;
        right = matrix[index].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[index][mid] == target) return true;
            else if (matrix[index][mid] > target) right = mid - 1;
            else if (matrix[index][mid] < target) left = mid + 1;
        }

        return false;
    }

    /**
     * 方法二：一次二次查找，将矩阵做成一个升序的一维数组
     * 必须是前闭后闭
     */
    public boolean binarySearch(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x = mid / cols;
            int y = mid % cols;

            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] > target) right = mid - 1;
            else if (matrix[x][y] < target) left = mid + 1;
        }

        return false;
    }
}







































