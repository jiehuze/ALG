package com.jiehu.code.bdf;

import java.util.LinkedList;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * <p>
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * 分析：广度搜索：
 * <p>
 * 思想：先搜索做标记，再做过滤
 * 本题使用dfs方法，会比较复杂，需要使用arrylist进行辅助，也可以写
 */
public class OrangesRotting {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {

        int ret = 0;
        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    stack.offer(new int[]{i, j}); //向链表末尾添加元素，返回是否成功；
                }
            }
        }

        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                int[] pos = stack.poll(); //删除并返回第一个元素
                int x = pos[0];
                int y = pos[1];

                for (int[] dir : dirs) {
                    int dx = x + dir[0], dy = y + dir[1];
                    if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == 1) {
                        stack.offer(new int[]{dx, dy});
                        grid[dx][dy] = 2;
                    }
                }
            }
            if (!stack.isEmpty()) {
                ret++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ret = -1;
                    break;
                }
            }
        }

        return ret;
    }
}
