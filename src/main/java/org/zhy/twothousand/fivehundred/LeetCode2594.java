package org.zhy.twothousand.fivehundred;

/**
 * 2594. 修车的最少时间
 * 给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
 * 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
 * 请你返回修理所有汽车 最少 需要多少时间。
 * 注意：所有机械工可以同时修理汽车。
 */
public class LeetCode2594 {

    public long repairCars(int[] ranks, int cars) {
        int[] cnt = new int[101]; // 数组比哈希表更快
        int minR = ranks[0];
        for (int r : ranks) {
            cnt[r]++;
            minR = Math.min(minR, r);
        }
        long left = 0;
        long right = (long) minR * cars * cars;
        while (left + 1 < right) {
            long mid = (left + right) >> 1;
            long s = 0;
            for (int r = minR; r <= 100 && s < cars; r++) {
                s += (long) Math.sqrt(mid / r) * cnt[r];
            }
            if (s >= cars) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
