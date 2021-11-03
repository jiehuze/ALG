package com.jiehu.code.StackAndQueue;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 还有两种方法：
 * 1。 红黑树
 * 2。二叉数
 */
public class MedianFinder {
    /**
     * 思路和算法
     * 我们用两个优先队列queMax 和 queMin 分别记录大于中位数的数和小于等于中位数的数。当累计添加的数的数量为奇数
     * 时，queMin 中的数的数量queMax多一个，此时中位数为queMin的队头。当累计添加的数的数量为偶数时，两个优先队列
     * 中的数的数量相同，此时中位数为它们的队头的平均值。
     * 当我们尝试添加一个数num 到数据结构中，我们需要分情况讨论：
     * 1.num≤max{queMin}
     * 此时num 小于等于中位数，我们需要将该数添加到queMin 中。新的中位数将小于等于原来的中位数，因此我们可能需要将
     * queMin 中最大的数移动到queMax 中。
     * 2.num>max{queMin}
     * 此时num 大于中位数，我们需要将该数添加到queMin 中。新的中位数将大于等于原来的中位数，因此我们可能需要将queMax
     * 中最小的数移动到queMin 中。
     * 3.特别地，当累计添加的数的数量为 0 时，我们将 num 添加到queMin 中。
     */
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        //最大顶堆，存储小数的最大值
        queMin = new PriorityQueue<>((a, b) -> b - a);
        //最小顶堆，存储大数的最小值
        queMax = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            //必须保持平衡，min最多比max多一个数，否则就需要将min中的最大数推出给max
            if (queMin.size() > queMax.size() + 1) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size())
            return queMin.peek();
        else {
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
