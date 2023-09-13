package org.zhy.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 1222. 可以攻击国王的皇后
 * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 * 给定一个由整数坐标组成的数组 queens ，表示黑皇后的位置；以及一对坐标 king ，
 * 表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。
 */
public class LeetCode1222 {


    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // 国王被皇后攻击的8个方向
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        // 用于判断该位置是否有皇后
        boolean[][] vis = new boolean[10][10];
        for (int[] q : queens) {
            vis[q[0]][q[1]] = true;
        }
        int x = king[0];
        int y = king[1];
        int step = 1;
        List<List<Integer>> result = new ArrayList<>();
        // 用于判断该方向是否已经有皇后更靠近国王
        boolean[] checked = new boolean[8];
        // 8*8的棋盘，单个方向最多8个空间
        while (step <= 8) {
            for (int i = 0; i < 8; i++) {
                // 如果该方向前面已经有皇后了，后面的皇后均会被阻挡，直接返回
                if (checked[i]) {
                    continue;
                }
                int nx = x + dirs[i][0] * step, ny = y + dirs[i][1] * step;
                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
                    // 到边界尽头了，不用再遍历这个方向
                    checked[i] = true;
                } else {
                    if (!vis[nx][ny]) {
                        continue;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nx);
                    list.add(ny);
                    result.add(list);
                    checked[i] = true;
                }
            }
            step++;
        }
        return result;
    }
}
