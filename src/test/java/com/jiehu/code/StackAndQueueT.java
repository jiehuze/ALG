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

//        maxNumber();
//        lastStoneWeight();
//        findKthLargest();
//        topKFrequent();
//        kClosest();
        medianFinder();
    }

    public static void medianFinder() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }

    public static void kClosest() {
//        int[][] points = {{1, 3}, {-2, 2}};
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        KClosest kClosest = new KClosest();
        System.out.println(Arrays.deepToString(kClosest.kClosest(points, 2)));

    }

    public static void topKFrequent() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums, 2)));

    }

    public static void findKthLargest() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(nums, 2));

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

    public static void lastStoneWeight() {
        int[] stones = {3, 7, 2};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(stones));

    }
}
