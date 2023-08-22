package org.zhy.thousand.eighthundred;

/**
 * 849. 到最近的人的最大距离
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 返回他到离他最近的人的最大距离。
 */
public class LeetCode849 {

    public int maxDistToClosest(int[] seats) {
        int length = seats.length;
        int left = -1;
        int result = 0;
        for (int right = 0; right < length; right++) {
            if (seats[right] == 1) {
                if (left == -1) {
                    left = right;
                    result = Math.max(result, left);
                } else {
                    result = Math.max(result, (right - left) / 2);
                    left = right;
                }
            }
        }
        // 最后判断右边界
        return Math.max(result, length - left - 1);
    }
}
