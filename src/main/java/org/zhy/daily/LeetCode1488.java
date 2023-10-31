package org.zhy.daily;

import java.util.*;

/**
 * 1488. 避免洪水泛滥
 * 你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨前是空的，
 * 那么它就会装满水。如果第 n 个湖泊下雨前是 满的 ，这个湖泊会发生 洪水 。你的目标是避免任意一个湖泊发生洪水。
 * 给你一个整数数组 rains ，其中：
 * rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
 * rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
 * 请返回一个数组 ans ，满足：
 * ans.length == rains.length
 * 如果 rains[i] > 0 ，那么ans[i] == -1 。
 * 如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
 * 如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。
 *
 * 请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生。
 */
public class LeetCode1488 {

    public int[] avoidFlood(int[] rains) {
        int length = rains.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        int[] nextRains = new int[length];
        Map<Integer, Integer> lakeDays = new HashMap<Integer, Integer>();
        for (int i = length - 1; i >= 0; i--) {
            int lake = rains[i];
            if (lake > 0) {
                nextRains[i] = lakeDays.getOrDefault(lake, Integer.MAX_VALUE);
                lakeDays.put(lake, i);
            }
        }
        Set<Integer> fullLakes = new HashSet<Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < length; i++) {
            int lake = rains[i];
            if (lake > 0) {
                if (!fullLakes.add(lake)) {
                    return new int[0];
                }
                if (nextRains[i] < length) {
                    pq.offer(new int[]{lake, nextRains[i]});
                }
            } else {
                if (pq.isEmpty()) {
                    ans[i] = 1;
                } else {
                    int[] pair = pq.poll();
                    int nextLake = pair[0];
                    ans[i] = nextLake;
                    fullLakes.remove(nextLake);
                }
            }
        }
        return ans;
    }
}
