package com.jiehu.code.SlidingWindow;

/**
 * 845. 数组中的最长山脉
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 * 字节、网易、商汤
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * 如果不含有 “山脉” 则返回 0。
 * 示例 1：
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 */
public class LongestMountain {
    /**
     * 枚举山脚
     */
    public int longestMountain(int[] arr) {
        int left = 0, top = 0;
        int maxLen = 0;

        //[2,1,4,7,3,2,5]
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) { //上坡，标记右侧山底
                if (top != left) {
                    //说明到山底，需要爬第二个山了
                    maxLen = Math.max(maxLen, i - left);
                    left = top = i;
                }
            } else if (arr[i] < arr[i - 1]) {
                if (left + 1 == i) {
                    left++;
                    top = left;
                } else {
                    //到达了山顶，下坡了，标记山顶
                    if (top == left)
                        top = i - 1;
                    maxLen = Math.max(maxLen, i - left + 1);
                }
            } else {
                //上坡的数和山顶相同
                if (left == top) {
                    if (left == i - 1)
                        left = i;
                } else {
                    if (top + 1 == i) {
                        top = i;
                    }
                }
            }
        }

        return maxLen;
    }

    /**
     * 枚举山顶
     * 对于一座「山脉」，我们称首元素 B[0] 和尾元素 B[len(B)−1] 为「山脚」，满足题目要求 B[i−1]<B[i]>B[i+1] 的元素B[i] 为「山顶」
     * 为了找出数组arr 中最长的山脉，我们可以考虑枚举山顶，再从山顶向左右两侧扩展找到山脚。
     * 由于从左侧山脚到山顶的序列是严格单调递增的，而从山顶到右侧山脚的序列是严格单调递减的，因此我们可以使用动态规划（也可以理解为递推）的方法，计算出从任意一个元素开始，向左右两侧最多可以扩展的元素数目。
     * 我们用left[i] 表示 arr[i] 向左侧最多可以扩展的元素数目。如果arr[i−1]<arr[i]，那么 arr[i] 可以向左扩展到arr[i−1]，再扩展left[i] 个元素，因此有 left[i]=left[i−1]+1
     * 如果arr[i−1]≥arr[i]，那么arr[i] 无法向左扩展，因此有left[i]=0
     * 特别地，当i=0 时，arr[i] 为首元素，无法向左扩展，因此同样有left[0]=0
     * 同理，我们用right[i] 表示arr[i] 向右侧最多可以扩展的元素数目，那么有类似的状态转移方程（递推式）
     * right[i]={
     * right[i+1]+1,    arr[i]>arr[i+1]
     * 0,               arr[i]≤arr[i+1] 或 i=n−1
     * }
     * 其中 nn 是数组arr 的长度。
     * 在计算出所有的left以及right之后，我们就可以枚举山顶。需要注意的是，只有当left[i] 和 right[i] 均大于 0 时，arr[i] 才能作为山顶，并且山脉的长度为left+right[i]+1。
     * 在所有的山脉中，最长的即为答案。
     */
    public int longestMountain2(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = arr[i - 1] < arr[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = arr[i + 1] < arr[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}





































