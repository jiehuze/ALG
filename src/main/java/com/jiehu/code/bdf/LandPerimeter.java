package com.jiehu.code.bdf;

/**
 * 463. 岛屿的周长
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * 示例 1：
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * 示例 2：
 *
 * 输入：grid = [[1]]
 * 输出：4
 * 示例 3：
 *
 * 输入：grid = [[1,0]]
 * 输出：4
 * 提示：
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] 为 0 或 1

 * 链接：https://leetcode-cn.com/problems/island-perimeter
 */
public class LandPerimeter {
    int perimeter = 0;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        if (row == 0)
            return perimeter;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
            }
        }

        dfs(grid, row, col);

        return perimeter;
    }

    public void dfs(int[][] grid, int x, int y) {

        grid[x][y] = -1;
        for (int[] dir : dirs) {
            int dx = x + dir[0], dy = y + dir[1];
            if (dx < 0 || dy < 0 || dx >= grid.length || dy >= grid[0].length) {
                perimeter++;// 说明没有海也没有陆地了
            }
            if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] != -1) {
                if (grid[dx][dy] == 0) {//说明时海洋，不能跳，边+1
                    perimeter++;
                    continue;
                }

                dfs(grid, dx, dy);
            }
        }
    }
}
