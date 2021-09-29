package com.jiehu.code.bdf;

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
