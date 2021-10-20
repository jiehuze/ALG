package com.jiehu.code.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 554. 砖墙
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 * 示例 1：
 * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 * 输出：2
 * 示例 2：
 * 输入：wall = [[1],[1],[1]]
 * 输出：3
 *  
 * 提示：
 * <p>
 * n == wall.length
 * 1 <= n <= 104
 * 1 <= wall[i].length <= 104
 * 1 <= sum(wall[i].length) <= 2 * 104
 * 对于每一行 i ，sum(wall[i]) 是相同的
 * 1 <= wall[i][j] <= 231 - 1
 */
public class LeastBricks {
    /**
     * 思路及算法
     * 由于砖墙是一面矩形，所以对于任意一条垂线，其穿过的砖块数量加上从边缘经过的砖块数量之和是一个定值，即砖墙的高度。
     * 因此，问题可以转换成求「垂线穿过的砖块边缘数量的最大值」，用砖墙的高度减去该最大值即为答案。
     * 虽然垂线在每行至多只能通过一个砖块边缘，但是每行的砖块边缘也各不相同，因此我们需要用哈希表统计所有符合要求的砖块边缘的数量。
     * 注意到题目要求垂线不能通过砖墙的两个垂直边缘，所以砖墙两侧的边缘不应当被统计。因此，我们只需要统计每行砖块中除了最右侧的砖块以外的其他砖块的右边缘即可。
     * 具体地，我们遍历砖墙的每一行，对于当前行，我们从左到右地扫描每一块砖，使用一个累加器记录当前砖的右侧边缘到砖墙的左边缘的距离，将除了最右侧的砖块以外的其
     * 他砖块的右边缘到砖墙的左边缘的距离加入到哈希表中。最后我们遍历该哈希表，找到出现次数最多的砖块边缘，这就是垂线经过的砖块边缘，而该垂线经过的砖块数量即为砖墙的高度减去该垂线经过的砖块边缘的数量。
     */
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        wall.forEach(col -> {
            int sum = 0;
            //size要减去1，去掉最右侧边界
            for (int j = 0; j < col.size() - 1; j++) {
                sum += col.get(j);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        });

        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(entry.getValue(), maxCnt);
        }

        return wall.size() - maxCnt;
    }
}















