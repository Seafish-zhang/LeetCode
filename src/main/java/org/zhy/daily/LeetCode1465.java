package org.zhy.daily;

import java.util.Arrays;

/**
 * 1465. 切割后面积最大的蛋糕
 * 矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中：
 * horizontalCuts[i] 是从矩形蛋糕顶部到第  i 个水平切口的距离
 * verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离
 * 请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，
 * 并返回其 面积 。由于答案可能是一个很大的数字，因此需要将结果 对 109 + 7 取余 后返回。
 */
public class LeetCode1465 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int MOD = 1000000007; // 模值
        int maxHDiff = getMaxDiff(h, horizontalCuts);   // 获取垂直方向的最大距离
        int maxWDiff = getMaxDiff(w, verticalCuts);     // 获取水平方向的最大距离
        return (int) (1L * maxHDiff * maxWDiff % MOD);   // 最大面积等于二者乘积
    }

    /**
     * 获取给定方向的最大距离
     *
     * @param maxCut: 给定方向的尺寸（高度/宽度，或者说是下边界/右边界）
     * @param cuts:   给定方向的切割数组
     */
    private int getMaxDiff(int maxCut, int[] cuts) {
        Arrays.sort(cuts);      // 切割位置排序
        int n = cuts.length;
        int diff = Math.max(cuts[0], maxCut - cuts[n - 1]);     // 初始最大距离为首个切割位置与起点距离和最后一个切割位置与终点的距离的较大值
        for (int i = 1; i < n; i++) {
            diff = Math.max(diff, cuts[i] - cuts[i - 1]);     // 比较相邻两个切割位置的距离
        }
        return diff;
    }
}
