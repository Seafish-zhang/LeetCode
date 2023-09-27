package org.zhy.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2251. 花期内花的数目
 * 给你一个下标从 0 开始的二维整数数组 flowers ，
 * 其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。
 * 同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 */
public class LeetCode2251 {

    public static void main(String[] args) {
        new LeetCode2251().fullBloomFlowers2(new int[][]{{1, 10}, {3, 3}}, new int[]{2, 3});
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        for (int i = 0; i < people.length; i++) {
            int current = 0;
            for (int[] flower : flowers) {
                int start = flower[0];
                int end = flower[1];
                if (start <= people[i] && end >= people[i]) {
                    current++;
                }
            }
            people[i] = current;
        }
        return people;
    }

    public int[] fullBloomFlowers2(int[][] flowers, int[] people) {
        int n = flowers.length;
        var starts = new int[n];
        var ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < people.length; i++) {
            people[i] = lowerBound(starts, people[i] + 1) - lowerBound(ends, people[i]);
        }
        return people;
    }

    // 返回 >= x 的第一个数的下标
    // 如果不存在（所有元素都小于 x），则返回 nums.length
    private int lowerBound(int[] nums, int x) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < x) {
                left = mid; // 区间缩小为 (mid, right)
            } else {
                right = mid; // 区间缩小为 (left, mid)
            }
        }
        return right; // 根据循环不变量，此时 right 就是满足 nums[right] >= x 的最小值
    }
}
