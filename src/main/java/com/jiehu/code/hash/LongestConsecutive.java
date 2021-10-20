package com.jiehu.code.hash;

import java.util.*;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        return getLongestBySort(nums);
    }

    /**
     * 方法一：使用先排序，在遍历
     * 10ms
     */
    public int getLongestBySort(int[] nums) {
        //先进行排序
        Arrays.sort(nums);
        int maxlen = 0;
        int n = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) {
                n++;
            } else if (nums[i] == nums[i + 1]) {
                continue;
            } else {
                maxlen = Math.max(maxlen, n);
                n = 1;
            }
        }
        maxlen = Math.max(maxlen, n);

        return maxlen;
    }

    /**
     * 方法二：使用hashset，用到了其去重功能
     * 249ms
     */
    public int getLongestByHashMap(int[] nums) {
        HashMap<Integer, Boolean> hms = new HashMap<>();
        for (int num : nums) {
            hms.put(num, true);
        }
        int maxLen = 0;

        for (Map.Entry<Integer, Boolean> hm : hms.entrySet()) {
            if (hm.getValue() == false) continue;

            int len = 1;
            int k = hm.getKey();
            while (hms.containsKey(k + len)) {
                len++;
                hms.replace(k + len, false);
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    /**
     * 方法三：13ms
     */
    public int getLongestByHashSet(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            //这个地方比较巧妙，如果没有上一个数，才计算，否则跳过了，不许和map方法一样，需要重新写一下
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}





























