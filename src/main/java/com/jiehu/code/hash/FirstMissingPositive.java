package com.jiehu.code.hash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 */
public class FirstMissingPositive {
    //用hash法
    //这里有一个注意，如果数字大于长度，不要这个数字
    public int firstMissingPositive(int[] nums) {
        //先进行存储hash
        HashSet<Integer> numSet = new HashSet<>();
        int max = 0;

        //找到最大值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length)
                continue;
            numSet.add(nums[i]);
            max = Math.max(max, nums[i]);
        }

        for (int i = 1; i <= max; i++) {
            if (!numSet.contains(i))
                return i;
        }

        return max + 1;
    }

    /**
     * 置换法：
     * 除了打标记以外，我们还可以使用置换的方法，将给定的数组「恢复」成下面的形式：
     * 如果数组中包含 x \in [1, N]x∈[1,N]，那么恢复后，数组的第 x - 1x−1 个元素为 xx。
     * 在恢复后，数组应当有 [1, 2, ..., N] 的形式，但其中有若干个位置上的数是错误的，每一个错误的位置就代表了一个缺失的正数。以题目中的示例二 [3, 4, -1, 1] 为例，恢复后的数组应当为 [1, -1, 3, 4]，我们就可以知道缺失的数为 22。
     * 那么我们如何将数组进行恢复呢？我们可以对数组进行一次遍历，对于遍历到的数 x = \textit{nums}[i]x=nums[i]，如果 x \in [1, N]x∈[1,N]，我们就知道 xx 应当出现在数组中的 x - 1x−1 的位置，因此交换 \textit{nums}[i]nums[i] 和 \textit{nums}[x - 1]nums[x−1]，这样 xx 就出现在了正确的位置。在完成交换后，新的 \textit{nums}[i]nums[i] 可能还在 [1, N][1,N] 的范围内，我们需要继续进行交换操作，直到 x \notin [1, N]x∈
     * /
     * [1,N]。
     * 注意到上面的方法可能会陷入死循环。如果 \textit{nums}[i]nums[i] 恰好与 \textit{nums}[x - 1]nums[x−1] 相等，那么就会无限交换下去。此时我们有 \textit{nums}[i] = x = \textit{nums}[x - 1]nums[i]=x=nums[x−1]，说明 xx 已经出现在了正确的位置。因此我们可以跳出循环，开始遍历下一个数。
     * <p>
     * 由于每次的交换操作都会使得某一个数交换到正确的位置，因此交换的次数最多为 NN，整个方法的时间复杂度为 O(N)O(N)。
     */
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
