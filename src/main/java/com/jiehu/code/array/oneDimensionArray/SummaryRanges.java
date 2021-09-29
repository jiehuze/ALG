package com.jiehu.code.array.oneDimensionArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * <p>
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 * <p>
 * 输入：nums = [0]
 * 输出：["0"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {

        ArrayList<String> list = new ArrayList<>();


        return list;
    }

    /**
     * 方法一：使用额外的空间保存数据，空间复杂度比较高
     */

    public List<String> summaryRanges1(int[] nums) {

        ArrayList<String> list = new ArrayList<>();

        ArrayList<Integer> tmplist = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            tmplist.add(nums[i]);

            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (tmplist.size() == 1) {
                    String tmp = "" + tmplist.get(0);
                    list.add(tmp);
                } else {
                    String tmp = "" + tmplist.get(0) + "->" + tmplist.get(tmplist.size() - 1);
                    list.add(tmp);
                }
                tmplist.clear();
            }
        }

        return list;
    }

    /**
     * 方法二：使用指针的方式，可以优化存储，执行效率也会增加
     */
    public List<String> summaryRanges2(int[] nums) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (i != j) {
                    list.add(nums[j] + "->" + nums[i]);
                } else {
                    list.add(nums[j] + "");
                }

                j = i + 1;
            }
        }

        return list;
    }
}
