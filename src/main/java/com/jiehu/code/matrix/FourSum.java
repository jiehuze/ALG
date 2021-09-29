package com.jiehu.code.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *  
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();

        if (nums.length < 4) {
            return lists;
        }

        int L = 0, R = 0;
        // 第一步：必须先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
//            if (nums[i] > target) break; //最左侧值大于target，说明直接不可能相加为target
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break; //正叙千4个数如果大于target，说明整体都大于target，就不需要在进行计算了
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
//                if (nums[j] > target) break; //最左侧值大于target，说明直接不可能相加为target
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + +nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;//正叙千4个数如果大于target，说明整体都大于target，就不需要在进行计算了
                if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[j] < target) continue;

                L = j + 1;
                R = nums.length - 1;

                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[L], nums[R]);
                        lists.add(integers);

                        while (L < R && nums[L] == nums[L + 1]) L++;
                        while (L < R && nums[R] == nums[R - 1]) R--;

                        L++;
                        R--;
                    } else if (sum > target) R--;
                    else L++;
                }

            }
        }

        return lists;
    }


    /**
     * dfs回溯算法，虽然简洁，执行效率反而更低了，不建议使用
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();

        if (nums.length < 4) {
            return lists;
        }

        Arrays.sort(nums);

        dfs(nums, 0, target, lists, new ArrayList<Integer>());

        return lists;
    }

    public void dfs(int[] nums, int index, int target, ArrayList<List<Integer>> lists, List<Integer> ns) {

        if (ns.size() == 4) {
            int sum = getSum(ns);
            if (sum == target) {
                /**
                 * 必须重新new一个新的list对像，否则是提前出栈，为空了
                 */
                lists.add(new ArrayList<>(ns));
            }
            return;
        }

        if (index > nums.length - 1) return;


        /**
         * 层次递归，遍历所有分支,这个数量级会很大
         */
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;

            ns.add(nums[i]);

            if (getSum(ns) > target && nums[i] > 0) {
                if (!ns.isEmpty()) {
                    ns.remove(ns.size() - 1);
                }
                return;
            }

            dfs(nums, i + 1, target, lists, ns);
            if (!ns.isEmpty()) {
                ns.remove(ns.size() - 1);
            }
        }
    }

    public int getSum(List<Integer> ns) {
        int sum = 0;
        for (Integer n : ns) {
            sum += n;
        }
        return sum;
    }
}
