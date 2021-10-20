package com.jiehu.code.hash;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ret = new int[arr1.length];
        int index = 0;
        HashMap<Integer, Integer> hp = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            hp.put(arr1[i], hp.getOrDefault(arr1[i], 0) + 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            Integer size = hp.get(arr2[i]);
            for (int j = 0; j < size; j++) {
                ret[index++] = arr2[i];
            }
            hp.remove(arr2[i]);
        }

        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            if (hp.containsKey(arr1[i])) {
                ret[index++] = arr1[i];
            }
        }

        return ret;
    }
}
