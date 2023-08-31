package org.zhy.dynamicprogramming;

/**
 * 673. 最长递增子序列的个数
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * 注意 这个数列必须是 严格 递增的。
 */
public class LeetCode673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            //必定有单独自己的一个递增子序列
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (nums[i] > nums[j]) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            count[i] = count[j];
                        } else if (dp[i] == dp[j] + 1) {
                            count[i] += count[j];
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                result += count[i];
            }
        }
        return result;
    }

}
