package com.jiehu.code.bdf;

import java.util.LinkedList;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * 输入：grid =[
 * [0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 */
public class MaxAreaOfIsland {
    int maxArea = 0;
    int curArea = 0;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    curArea = 0;
                    dfs(grid, i, j);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }

        return maxArea;
    }

    public void dfs(int[][] grid, int x, int y) {

        grid[x][y] = 0; //比较成海洋，就不会在搜索了
        curArea++;
        for (int[] dir : dirs) {
            int dx = x + dir[0], dy = y + dir[1];
            if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == 1) {
                dfs(grid, dx, dy);
            }

        }

    }

    /**
     * 算法优秀：比dfs快
     */
    public int bfs(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int curArea = 0;
                    LinkedList<int[]> stack = new LinkedList<>();
                    stack.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    while (!stack.isEmpty()) {
                        int[] pos = stack.poll();
                        int x = pos[0];
                        int y = pos[1];

                        curArea++;
                        for (int[] dir : dirs) {
                            int dx = x + dir[0], dy = y + dir[1];
                            if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == 1) {
                                stack.offer(new int[]{dx, dy});
                                grid[dx][dy] = 0;
                            }
                        }
                    }


                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }
}
