package com.jiehu.code;

import com.jiehu.code.StackAndQueue.SimplifyPath;

public class StackAndQueueT {
    public static void main(String[] args) {
        /**
         * 测试，有效路径
         */
        simplifyPath();
    }
    public static void simplifyPath(){
        String path = "/home//foo/";
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath(path));
    }
}
