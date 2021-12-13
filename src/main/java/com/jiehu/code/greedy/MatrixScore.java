package com.jiehu.code.greedy;

/**
 * 861. 翻转矩阵后的得分
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 * 示例：
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 */
public class MatrixScore {
    //方法：先按照行转，当第一个不为一时，移动
    //   再按照列传，第一个不为1时，转移
    public int matrixScore(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        //按照行转
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }

        //按照列转.但是前提是 1的数要 < 0的数
        for (int i = 1; i < col; i++) {
            int[] ns = new int[2];
            for (int j = 0; j < row; j++) {
                ns[grid[j][i]]++;
            }
            if (ns[0] > ns[1]) {
                for (int j = 0; j < row; j++) {
                    grid[j][i] ^= 1;
                }
            }
        }

//        System.out.println(Arrays.deepToString(grid));

        int sum = 0;
        for (int i = 0; i < row; i++) {
            StringBuffer buf = new StringBuffer();
            for (int j = 0; j < col; j++) {
                buf.append(grid[i][j]);
            }

            sum += Integer.valueOf(buf.toString(), 2);
        }

        return sum;
    }

    /**
     * https://leetcode-cn.com/problems/score-after-flipping-matrix/solution/fan-zhuan-ju-zhen-hou-de-de-fen-by-leetc-cxma/
     * 实际编写代码时，我们无需修改原矩阵，而是可以计算每一列对总分数的「贡献」，从而直接计算出最高的分数。假设矩阵共有 mm 行 nn 列，计算方法如下：
     * <p>
     * 对于最左边的列而言，由于最优情况下，它们的取值都为 11，因此每个元素对分数的贡献都为 2^{n-1}，总贡献为 m * 2的{n-1}次方
     * 对于第 j 列（j>0，此处规定最左边的列是第 0 列）而言，我们统计这一列 0,1 的数量，令其中的最大值为 k，则 k 是列翻转后的1 的数量，该列的总贡献为 k×2的(n−j−1)次方
     * 需要注意的是，在统计 0,1 的数量的时候，要考虑最初进行的行反转。
     * <p>
     * 牛逼～～～～
     */
    public int matrixScore2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                //考虑第一列的反转
                if (grid[i][0] == 1) {
                    nOnes += grid[i][j];
                } else {
                    nOnes += (1 - grid[i][j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - grid[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }
}
