package com.jiehu.code.StackAndQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * <p>
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * <p>
 * 示例 2：
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 * <p>
 * 提示：
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        return quickSortFindK(points, k);
    }

    /**
     * 方法一：使用priorty队列方式
     */
    public int[][] queueFindK(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //最小堆队列
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < points.length; i++) {
            queue.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }

        int[][] rets = new int[k][2];
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                int[] poll = queue.poll();
                rets[i] = points[poll[1]];
            }
        }

        return rets;
    }

    /************************************************************/
    /**
     * 方法二：借鉴quickSort方法,
     * 只需要找到小于pivot的点，而不需要对所有数据进行排序
     * 在一次划分操作完成后，设pivot 的下标为 ii
     * 最好找到的数可能情况为：
     * 如果 k = i−left+1，那么说明 pivot 就是第 kk 个距离最小的点，我们可以结束整个过程；
     * 如果 k < i−left+1，那么说明第 k 个距离最小的点在 pivot 左侧，因此递归调用 random_select(left, i - 1, k)；
     * 如果 k > i−left+1，那么说明第 k 个距离最小的点在 pivot 右侧，因此递归调用 random_select(i + 1, right, k - (i - left + 1))。
     * <p>
     * 用时：4ms，
     * queue用时：22ms
     */
    public int[][] quickSortFindK(int[][] points, int k) {
        int[][] rets = new int[k][2];
        random_select(points, 0, points.length, k);
        rets = Arrays.copyOf(points, k);
        return rets;
    }

    public void random_select(int[][] points, int left, int right, int k) {
        int pivot = left;
        int index = left + 1;

        //开始进行快速排序
        int pivotSqrt = points[pivot][0] * points[pivot][0] + points[pivot][1] * points[pivot][1];
        for (int i = index; i < right; i++) {
            int iSqrt = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (iSqrt <= pivotSqrt) {
                swap(points, index, i);
                index++;
            }
        }

        swap(points, pivot, index - 1);
        pivot = index;

        if (pivot > k) {
            //说明在左侧
            random_select(points, left, pivot, k);
        } else if (pivot < k) {
            //说明在右侧
            random_select(points, pivot, right, k);
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] tmp = points[index1];
        points[index1] = points[index2];
        points[index2] = tmp;
    }
}












































