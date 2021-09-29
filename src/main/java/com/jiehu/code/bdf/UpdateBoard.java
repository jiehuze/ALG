package com.jiehu.code.bdf;

import java.util.LinkedList;

/**
 * 扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。 
 * 'M' 代表一个未挖出的地雷，
 * 'E' 代表一个未挖出的空方块，
 * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，
 * 'X' 则表示一个已挖出的地雷。
 * <p>
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * <p>
 * 规则1：如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 规则2：如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 规则3：如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 规则4：如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * <p>
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * <p>
 * Click : [3,0]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 */
public class UpdateBoard {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (click[0] >= board.length || click[2] >= board[0].length) return board;

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            dfs(board, click[0], click[1]);
        }

        return board;
    }

    /**
     * 解题思路： 以搜索的点主要做三个事情：
     * 1）如果是地雷就直接爆炸
     * 2）根据该点扫描周围8个方向的，是否有地雷，有地雷的话，标记这个位置的数字
     * 3）如果周边没有地雷，直接标记为B
     * <p>
     * 还有一个方式：先比较雷，根据雷周围数，把相应的数字标记出来
     */

    public boolean dfs(char[][] board, int x, int y) {
        int cnt = 0;
        //先扫描8个方向，标记该方格的字母或者数字，字母只能是B，数字是cnt
        for (int[] dir : dirs) {
            int dx = x + dir[0], dy = y + dir[1];
            if (dx >= 0 && dx < board.length && dy >= 0 && dy < board[0].length) {
                if (board[dx][dy] == 'M')
                    cnt++;
            }
        }
        //数名周围有雷，标记数字，否则标记B
        if (cnt > 0) {
            board[x][y] = (char) (cnt + '0');
        } else {
            board[x][y] = 'B';
            for (int[] dir : dirs) {
                int dx = x + dir[0], dy = y + dir[1];
                if (dx >= 0 && dx < board.length && dy >= 0 && dy < board[0].length && board[dx][dy] == 'E') {
                    dfs(board, dx, dy);
                }
            }
        }

        return true;
    }

    //效率不高
    public void bfs(char[][] board, int cx, int cy) {
        LinkedList<int[]> stack = new LinkedList<>();
        stack.offer(new int[]{cx, cy});
        while (!stack.isEmpty()) {
            int[] pos = stack.poll();
            int x = pos[0];
            int y = pos[1];

            int cnt = 0;
            //先扫描8个方向，标记该方格的字母或者数字，字母只能是B，数字是cnt
            for (int[] dir : dirs) {
                int dx = x + dir[0], dy = y + dir[1];
                if (dx >= 0 && dx < board.length && dy >= 0 && dy < board[0].length) {
                    if (board[dx][dy] == 'M')
                        cnt++;
                }
            }
            //说明周围有雷，标记数字，否则标记B
            if (cnt > 0) {
                board[x][y] = (char) (cnt + '0');
            } else {
                board[x][y] = 'B';
                for (int[] dir : dirs) {
                    int dx = x + dir[0], dy = y + dir[1];
                    if (dx >= 0 && dx < board.length && dy >= 0 && dy < board[0].length && board[dx][dy] == 'E') {
                        stack.offer(new int[]{dx, dy});
                    }
                }
            }

        }
    }

}
