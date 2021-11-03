package com.jiehu.code.StackAndQueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * <p>
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * <p>
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return findSlidByQueue(nums, k);
    }

    /**
     * 方法一：使用优先队列，堆顶为最大数,大根堆
     */
    public int[] findSlidByQueue(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];
        //数组，第一个元素为：值，第二个元素为：下标
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });


        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            //需要判断当前堆顶的元素是不是要出优先队列的元素
            if (queue.size() >= k) {
                while (!queue.isEmpty()) {
                    int i1 = queue.peek()[1];
                    //如果下标不在滑动窗口中，就将其剔除出该队列中，剩下的最大值肯定在滑动窗口中
                    if (i1 < i - k + 1) {
                        queue.poll();
                    } else {
                        ret[i - k + 1] = queue.peek()[0];
                        break;
                    }
                }
            }
        }

        return ret;
    }

    /**
     * 2rd: 使用单调队列方式,双向队列
     * 使用单调栈方式存储下标，并且队列的头，一定存储的是最大值，按照下标判断是否超出来滑动窗口，如果在滑动窗口中，就一定是这个最大值
     * 本方法：28ms
     * 第一种：78ms
     * 比第一种方式快：
     */
    public int[] findSlidByStack(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                while (queue.peekFirst() < i - k + 1) {
                    queue.pollFirst();
                }
                ans[i - k + 1] = nums[queue.peekFirst()];
            }
        }

        return ans;
    }
}
























