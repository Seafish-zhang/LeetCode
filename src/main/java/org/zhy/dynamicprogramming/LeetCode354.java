package org.zhy.dynamicprogramming;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 */
public class LeetCode354 {

    public static void main(String[] args) {
        new LeetCode354().maxEnvelopes(new int[][]{{2, 3}, {1, 8}, {5, 4}, {5, 2}, {6, 7}, {6, 4}});
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] weigth = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            weigth[i] = envelopes[i][1];
        }
        int[] dp = new int[weigth.length];
        int result = 0;
        for (int i = 0; i < weigth.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (weigth[i] > weigth[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] weigth = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            weigth[i] = envelopes[i][1];
        }
        return lengthOfLIS(weigth);
    }

    public int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            int left = 0, right = piles;
            // 二分查找插入位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker) right = mid;
                else left = mid + 1;
            }
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}
