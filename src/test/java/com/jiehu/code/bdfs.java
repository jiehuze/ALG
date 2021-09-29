package com.jiehu.code;

import com.jiehu.code.bdf.LandPerimeter;

public class bdfs {
    public static void main(String[] args) {
        /**
         * 测试1： 岛屿周长
         */
        landPerimeter();
    }

    public static void landPerimeter() {
        int[][] land = {{1, 1}, {1, 1}};
        LandPerimeter landPerimeter = new LandPerimeter();
        System.out.println(landPerimeter.islandPerimeter(land));
    }
}
