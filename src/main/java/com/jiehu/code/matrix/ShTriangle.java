package com.jiehu.code.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角     生成杨辉三角
 * 119. 杨辉三角2   根据索引值取一行数据
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 */
public class ShTriangle {
    /**
     * 生成杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> rows = new ArrayList<>();
            rows.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> preRows = lists.get(i - 1);
                rows.add(preRows.get(j - 1) + preRows.get(j));
            }

            if (i > 0)
                rows.add(1);

            lists.add(rows);
        }

        return lists;
    }

    /**
     * @param rowIndex 行号
     * @return 返回该行号的数据
     */
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ArrayList<Integer> rows = new ArrayList<>();
            rows.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> preRows = lists.get(i - 1);
                rows.add(preRows.get(j - 1) + preRows.get(j));
            }

            if (i > 0)
                rows.add(1);

            lists.add(rows);
        }

        return lists.get(rowIndex);
    }
}















