package com.jiehu.code.StackAndQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        return topKFrequent1(nums, k);
    }

    /**
     * 1。hashmap存储数据
     */
    public int[] topKFrequent1(int[] nums, int k) {
        //key: 元素；value：次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //必须使用升降序队列,
//        LinkedList<int[]> stack = new LinkedList<>();
        //优先队列,优先队列的作用是能保证每次取出的元素都是队列中权值最小的
        //和 215 FindKthLargest的第二个方式一样，最大堆顶点
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        map.forEach((key, value) -> {
            if (queue.size() == k) {
                if (value > queue.peek()[1]) {
                    queue.poll();
                    queue.offer(new int[]{key, value});
                }
            } else {
                queue.offer(new int[]{key, value});
            }
        });


        int[] rsts = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            rsts[i++] = queue.poll()[0];
        }

        return rsts;
    }
}




































