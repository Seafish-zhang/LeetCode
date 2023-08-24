package org.zhy.dynamicprogramming;

/**
 * 931. 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列
 * （即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当
 * 是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 */
public class LeetCode931 {

    public static void main(String[] args) {
        new LeetCode931().minFallingPathSum(new int[][]{{17, 82}, {1, -44}});
    }

    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left, right, mid;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0) {
                    left = Integer.MAX_VALUE;
                    right = Integer.MAX_VALUE;
                    if (j - 1 >= 0) {
                        left = matrix[i - 1][j - 1];
                    }
                    mid = matrix[i - 1][j];
                    if (j + 1 < n) {
                        right = matrix[i - 1][j + 1];
                    }
                    matrix[i][j] += Math.min(Math.min(left, mid), right);
                }
                if (i == m - 1) {
                    min = Math.min(min, matrix[i][j]);
                }
            }
        }
        return min;
    }
}
