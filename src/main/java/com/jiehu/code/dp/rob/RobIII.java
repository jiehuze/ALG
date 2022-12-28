package com.jiehu.code.dp.rob;

import com.jiehu.code.tree.vo.TreeNode;

/**
 * 337. 打家劫舍 III
 * https://leetcode.cn/problems/house-robber-iii/
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * 示例 1:
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 示例 2:
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * 提示：
 * 树的节点数在 [1, 104] 范围内
 * 0 <= Node.val <= 104
 */
public class RobIII {
    public int rob(TreeNode root) {
        /**
         * 1.定义dp数组：使用一个二个元素的数组，第一个元素记录为偷； 第二个元素记录不偷
         * 2. 推导公式
         * 3。 遍历顺序，使用递归方式，使用后续遍历的方式
         */
        int[] res = dfs(root);

        return Math.max(res[0], res[1]);
    }

    /**
     * 递归三部曲：
     * 1） 结束条件： 当root为null时结束
     */
    public int[] dfs(TreeNode root) {
        int[] ret = new int[2];
        if (root == null) return ret;

        //使用后续遍历，先遍历左树，再遍历右树，最后是根
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        //偷，那么left和right就不能偷，
        ret[0] = left[1] + right[1] + root.val;
        //不偷, 那么左右节点可偷可不偷，取最大值，max(left不偷，left偷) + max(right不偷，right偷)
        ret[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return ret;
    }
}
















