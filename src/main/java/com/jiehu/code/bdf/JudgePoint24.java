package com.jiehu.code.bdf;

/**
 * 679. 24 点游戏
 * https://leetcode-cn.com/problems/24-game/
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * 示例 1:
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 */
public class JudgePoint24 {
    /**
     * 很明显的递归思路。每次递归都会挑出两个数，我们尝试挑出不同的两数组合：
     * 挑 1、2，基于它，继续递归。
     * 挑 1、3，基于它，继续递归。
     * 挑 ……
     * 即通过两层 for 循环，枚举所有的两数组合，展开出不同选择所对应的递归分支。
     */
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] cards) {
        double[] doubleNums = new double[cards.length];
        //必须将int转为double，否则在除法时，整数相除只能取整，出现数据不准确
        for (int i = 0; i < cards.length; i++) {
            doubleNums[i] = (double) cards[i];
        }
        return dfs(doubleNums);
    }

    public boolean dfs(double[] nums) {
        if (nums.length == 1) {
            /**
             * *********由于精度问题 ********
             * 1e-6表示1乘以10的负6次方。
             * Math.abs(x) < 1e-6其实相当于x==0
             * 1e-6(也就是0.000001)叫做epslon，用来抵消浮点运算中因为误差造成的相等无法判断的情况。它通常是一个非常小的数字（具体多小要看你的运算误差）
             */
            return Math.abs(nums[0] - TARGET) < EPSILON;
        }

        //分别俩俩组合
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                //当前一样地址跳过
                if (i == j) continue;

                //将在i和j位置的数据剔除出去，做运算使用，其他数据重新存储在newNums中
                double[] newNums = new double[nums.length - 1];
                for (int k = 0, z = 0; k < nums.length; k++) {
                    if (k != i && k != j) {
                        newNums[z++] = nums[k];
                    }
                }
                //把四种运算符进行操作，总有一种满足，否则就回归
                for (int k = 0; k < 4; k++) {
                    if (k == ADD) {
                        newNums[newNums.length - 1] = nums[i] + nums[j];
                    } else if (k == MULTIPLY) {
                        newNums[newNums.length - 1] = nums[i] * nums[j];
                    } else if (k == SUBTRACT) {
                        newNums[newNums.length - 1] = nums[i] - nums[j];
                    } else if (k == DIVIDE && nums[j] != 0) {
                        newNums[newNums.length - 1] = nums[i] / nums[j];
                    } else {
                        continue;
                    }

                    if (dfs(newNums)) return true;
                }
            }
        }

        return false;
    }
}
