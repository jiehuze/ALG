package com.jiehu.code.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        return sigleNumberXor(nums);
    }

    /**
     * 方法一： 使用异或的特性 1ms
     * 1.任何数和 00 做异或运算，结果仍然是原来的数，即 a^0=a
     * 2.任何数和其自身做异或运算，结果是 00，即 a^a=0
     * 3.异或运算满足交换律和结合律，即 a^b^a = b^a^a = b^(a^a) = b^0 = b
     */
    public int sigleNumberXor(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }

        return ret;
    }

    /**
     * 方法二：使用hash
     * 15ms
     */
    public int sigleNumberHash(int[] nums) {
        HashMap<Integer, Integer> hms = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hms.containsKey(nums[i])) {
                hms.replace(nums[i], hms.get(nums[i]) + 1);
            } else {
                hms.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entries : hms.entrySet()) {
            if (entries.getValue() == 1) return entries.getKey();
        }

        return -1;
    }
}


















