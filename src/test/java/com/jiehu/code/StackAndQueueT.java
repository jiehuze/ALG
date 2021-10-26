package com.jiehu.code;

import com.jiehu.code.StackAndQueue.*;

import java.util.Arrays;

public class StackAndQueueT {
    public static void main(String[] args) {
        /**
         * 测试，有效路径
         */
//        simplifyPath();

//        removeKdigits();

//        dupicateLetters();

//        find132();
//        reverseWords();

        maxNumber();
    }

    public static void simplifyPath() {
        String path = "/home//foo/";
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath(path));
    }

    public static void removeKdigits() {
        String num = "112";
        RemoveKdigits removeKdigits = new RemoveKdigits();
        System.out.println(removeKdigits.removeKdigits(num, 1));
    }

    public static void dupicateLetters() {
//        String s = "bbcaac";
        String s = "abacb";
        DuplicateLetters duplicateLetters = new DuplicateLetters();
        System.out.println(duplicateLetters.removeDuplicateLetters(s));
    }

    public static void find132() {
        int[] nums = {5, 6, 5};
        Find132pattern find132pattern = new Find132pattern();
        System.out.println(find132pattern.find132pattern(nums));

    }

    public static void reverseWords() {
        String s = " hello world ";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(s));

    }

    public static void maxNumber() {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        MaxNumber maxNumber = new MaxNumber();
        System.out.println(Arrays.toString(maxNumber.maxNumber(nums1, nums2, k)));
    }
}
