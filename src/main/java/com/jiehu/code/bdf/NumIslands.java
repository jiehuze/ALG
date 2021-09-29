package com.jiehu.code.bdf;

import java.util.LinkedList;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * dfs: dfs使用递归的方式
 * bfs：bfs使用堆栈的方式，主要使用LinkedList（）双向列表
 */
public class NumIslands {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }

        return num;
    }

    public void dfs(char[][] grid, int x, int y) {

        grid[x][y] = '2';
        for (int[] dir : dirs) {
            int dx = x + dir[0], dy = y + dir[1];
            if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == '1') {
                dfs(grid, dx, dy);
            }
        }
    }

    public int bfs(char[][] grid) {
        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    LinkedList<int[]> stack = new LinkedList<>();
                    stack.offer(new int[]{i, j});
                    while (!stack.isEmpty()) {
                        int[] pos = stack.poll();
                        int x = pos[0];
                        int y = pos[1];

                        for (int[] dir : dirs) {
                            int dx = x + dir[0];
                            int dy = y + dir[1];
                            if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == '1') {
                                grid[dx][dy] = '2';
                                stack.offer(new int[]{dx, dy});
                            }
                        }
                    }
                    num++;
                }
            }
        }

        return num;
    }
}
