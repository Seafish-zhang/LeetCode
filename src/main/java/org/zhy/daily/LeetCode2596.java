package org.zhy.daily;

/**
 * 2596. 检查骑士巡视方案
 * 骑士在一张 n x n 的棋盘上巡视。在 有效 的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
 * 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，
 * 其中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的。
 * 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
 * 注意，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。
 */
public class LeetCode2596 {

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;

        int n = grid.length;
        int[] indices = new int[n * n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j)
                // 登记0, n * n - 1 值的坐标
                indices[grid[i][j]] = i * n + j;
        }

        int x = indices[0] / n, y = indices[0] % n;
        for (int i = 1; i < indices.length; ++i) {
            // 因为骑士走的“日”子,判断下一个序号的坐标和前一个是否距离为2即可
            int nx = indices[i] / n, ny = indices[i] % n;
            int dx = nx - x;
            int dy = ny - y;
            if (Math.abs(dx * dy) != 2) return false;
            x = nx;
            y = ny;
        }
        return true;
    }

}
