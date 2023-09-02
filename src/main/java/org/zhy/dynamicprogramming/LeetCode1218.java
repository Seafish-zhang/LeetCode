package org.zhy.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，
 * 该子序列中相邻元素之间的差等于 difference 。
 * 子序列 是指在不改变其余元素顺序的情况下，
 * 通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 */
public class LeetCode1218 {

    public int longestSubsequence(int[] arr, int d) {
        int result = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i - d, 0) + 1);
            result = Math.max(result, map.get(i));
        }
        return result;
    }


    public int longestSubsequence2(int[] arr, int d) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[n][2];
        dp[0][1] = 1;
        map.put(arr[0], 0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = 1;
            int prev = arr[i] - d;
            if (map.containsKey(prev)) dp[i][1] = Math.max(dp[i][1], dp[map.get(prev)][1] + 1);
            map.put(arr[i], i);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
