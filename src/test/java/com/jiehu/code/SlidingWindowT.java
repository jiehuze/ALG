package com.jiehu.code;

import com.jiehu.code.SlidingWindow.CheckInclusion;
import com.jiehu.code.SlidingWindow.FindMaxConsecutiveOnesII;
import com.jiehu.code.SlidingWindow.MinSwaps;
import com.jiehu.code.SlidingWindow.MinWindow;

public class SlidingWindowT {
    public static void main(String[] args) {
//        minWindow();
//        findMaxConsecutiveOnes();
//        minSwaps();
        checkInclusion();
    }

    public static void checkInclusion() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion2(s1,s2));

    }

    public static void minSwaps() {
        int[] data = {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
        MinSwaps minSwaps = new MinSwaps();
        System.out.println(minSwaps.minSwaps(data));
    }

    public static void findMaxConsecutiveOnes() {
        int[] nums = {1, 0, 1, 1, 0};
        FindMaxConsecutiveOnesII findMaxConsecutiveOnesII = new FindMaxConsecutiveOnesII();
        System.out.println(findMaxConsecutiveOnesII.findMaxConsecutiveOnes(nums));
        System.out.println(findMaxConsecutiveOnesII.getMaxNum2(nums));
        System.out.println(findMaxConsecutiveOnesII.getMaxNum3(nums));


    }

    public static void minWindow() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinWindow minWindow = new MinWindow();

        System.out.println(minWindow.minWindow(s, t));
    }
}
