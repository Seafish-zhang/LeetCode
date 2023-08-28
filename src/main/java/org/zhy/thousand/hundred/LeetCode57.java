package org.zhy.thousand.hundred;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class LeetCode57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int st = newInterval[0];
        int ed = newInterval[1];
        for (int[] interval : intervals) {
            if (interval[1] < st || interval[0] > ed) {
                result.add(interval);
            } else {
                st = Math.min(st, interval[0]);
                ed = Math.max(ed, interval[1]);
            }
        }

        result.add(new int[]{st, ed});
        result.sort(Comparator.comparingInt(o -> o[0]));
        return result.toArray(new int[result.size()][2]);
    }
}
