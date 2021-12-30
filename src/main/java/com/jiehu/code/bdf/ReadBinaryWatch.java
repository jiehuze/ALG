package com.jiehu.code.bdf;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表
 * https://leetcode-cn.com/problems/binary-watch/
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * 8   4   2   1
 * 32   16  8   4   2   1
 * 例如，下面的二进制手表读取 "3:25" 。
 * 0   0   1   1
 * 0   1   1   0   0   1
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * 小时不会以零开头：
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * 示例 1：
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * 示例 2：
 * <p>
 * 输入：turnedOn = 9
 * 输出：[]
 */
public class ReadBinaryWatch {
    int[] a = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    ArrayList<String> list = new ArrayList<>();

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn < 9) {
            dfs(0, turnedOn, 0, 0, 0);
        }

        return list;
    }

    public void dfs(int cnt, int turnedOn, int index, int hour, int minute) {
        if (cnt == turnedOn) {
            list.add(hour + ":" + (minute > 9 ? minute : "0" + minute));
            return;
        }

        //这种累计使用的，就必须使用数组,如果只能使用一次的，就不需要了
        for (int i = index; i < a.length && cnt < turnedOn; i++) {
            if (i < 4 && hour + a[i] < 12) dfs(cnt + 1, turnedOn, i + 1, hour + a[i], minute);
            if (i >= 4 && minute + a[i] < 60) dfs(cnt + 1, turnedOn, i + 1, hour, minute + a[i]);
        }

    }

    /**
     * 二进制枚举法，效率也一般
     */
    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }

}
