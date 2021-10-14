package com.jiehu.code.math;

/**
 * 1232. 缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * <p>
 * 示例 1：
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *  
 * 提示：
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 */
public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 2) return false;
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int xx = coordinates[i][0] - coordinates[i - 1][0];
            int yy = coordinates[i][1] - coordinates[i - 1][1];
            //错误写法，由于x,y可能是0，导致除数为零，所以将除法修改为乘法
            //if (xx / x != yy / y) return false;
            if (xx * y / x != yy * x) return false;
        }

        return true;
    }
}
