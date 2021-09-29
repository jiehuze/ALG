package com.jiehu.code.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题：数字n代表生成的括号的对数，规则时一一对应
 * 例如：n=2
 * 输出：[(()), ()()]
 *
 * 使用递归的方法实现，也就是穷举方法：
 *
 * 递归方法的三要素：
 * 1）实现方法，要明确这个函数要干什么
 * 2）结束条件
 * 3）等价
 */

public class BracketNum {
    public List<String> bracketNum(int n) {
        List<String> list = new ArrayList<>();
        if (n != 0) {
            dfs(n, "", list, 0, 0);
        }

        return list;
    }

    private void dfs(int num, String path, List<String> list, int open, int close) {

        //当打开的符合>n时，或者闭符号>开符号，直接返回
        if (open > num || close > open) return;

        //一直深度遍历到树长度为 2*num，直接返回
        if (path.length() == 2 * num) {
            list.add(path);
            return;
        }

        dfs(num, path + "(", list, open + 1, close);
        dfs(num, path + ")", list, open, close + 1);

    }

    private void dfs2(int num, String path, List<String> list, int open, int close) {
        //一直深度遍历到树长度为 2*num，直接返回
        if (path.length() == 2 * num) {
            list.add(path);
            return;
        }

        //把判断提前到这个地方，
        if (open < num)
            dfs(num, path + "(", list, open + 1, close);
        if (close < open)
            dfs(num, path + ")", list, open, close + 1);

    }
}
