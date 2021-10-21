package com.jiehu.code.array;

import java.util.ArrayList;

/**
 * 135. 分发糖果
 * <p>
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class Candy {
    public int candy(int[] ratings) {
        ArrayList<Integer> list = new ArrayList<>();
        if (ratings.length == 1)
            return 1;

        int sum = 1;
        list.add(1);
        for (int i = 1; i < ratings.length; i++) {
            int n = 1;
            if (ratings[i] > ratings[i - 1]) {
                n += list.get(i - 1);
            } else if (ratings[i] == ratings[i - 1]) {
                n = list.get(i - 1);
            }

            list.add(n);

            sum += n;
        }

        System.out.println(list);

        return sum;
    }

    public int candy1(int[] ratings) {
        int n = ratings.length;
        int sum = 1;
        //pre： 标记为最多多少糖果，逐渐增加，分数小的，直接清为1
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                sum += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                sum += dec;
                pre = 1;
            }
        }
        return sum;
    }
}
