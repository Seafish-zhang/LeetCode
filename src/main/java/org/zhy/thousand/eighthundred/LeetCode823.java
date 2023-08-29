package org.zhy.thousand.eighthundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 823. 带因子的二叉树
 * 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
 * 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 * 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。
 */
public class LeetCode823 {

    public int numFactoredBinaryTrees(int[] arr) {
        long mod = (long) 1e9 + 7;
        Arrays.sort(arr);
        Map<Integer, Integer> exist = new HashMap<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            exist.put(arr[i], i);

        }
        long result = 0;
        long[] tmp = new long[length];
        for (int i = 0; i < length; i++) {
            int val = arr[i];
            tmp[i] = 1;
            for (int j = 0; j < i; ++j) {
                int x = arr[j];
                if ((long) x * x > val) break;
                if (x * x == val) {
                    tmp[i] += tmp[j] * tmp[j];
                } else if (val % x == 0 && exist.containsKey(val / x)) {
                    tmp[i] += (tmp[j] * tmp[exist.get(val / x)] * 2);
                }

            }
            result += tmp[i];
        }
        return (int) (result % mod);
    }
}
