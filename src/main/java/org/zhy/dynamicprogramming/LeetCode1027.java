package org.zhy.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 1027. 最长等差数列
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，
 * 且 0 <= i1 < i2 < ... < ik <= nums.length - 1。
 * 并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 */
public class LeetCode1027 {

    private int result;

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] maxLen = new HashMap[n];
        for (int i = 1; i < n; ++i)
            dfs(i, nums, maxLen);
        return result;
    }

    private Map<Integer, Integer> dfs(int i, int[] nums, Map<Integer, Integer>[] maxLen) {
        if (maxLen[i] != null) {
            // 之前算过了
            return maxLen[i];
        }
        // i=0 时不会进入循环
        maxLen[i] = new HashMap<>();
        for (int j = i - 1; j >= 0; --j) {
            int d = nums[i] - nums[j]; // 公差
            if (!maxLen[i].containsKey(d)) {
                maxLen[i].put(d, dfs(j, nums, maxLen).getOrDefault(d, 1) + 1);
                result = Math.max(result, maxLen[i].get(d));
            }
        }
        return maxLen[i];
    }
}
