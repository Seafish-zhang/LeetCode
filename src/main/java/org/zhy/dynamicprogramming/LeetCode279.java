package org.zhy.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class LeetCode279 {

    public int numSquares(int n) {
        // 预处理出所有可能用到的「完全平方数」
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            list.add(idx * idx);
            idx++;
        }

        // f[i][j] 代表考虑前 i 个物品，凑出 j 所使用到的最小元素个数
        int len = list.size();
        int[][] f = new int[len][n + 1];

        // 处理第一个数的情况
        for (int j = 0; j <= n; j++) {
            int t = list.get(0);
            int k = j / t;
            if (k * t == j) { // 只有容量为第一个数的整数倍的才能凑出
                f[0][j] = k;
            } else { // 其余则为无效值
                f[0][j] = -1;
            }
        }

        // 处理剩余数的情况
        for (int i = 1; i < len; i++) {
            int t = list.get(i);
            for (int j = 0; j <= n; j++) {
                // 对于不选第 i 个数的情况
                f[i][j] = f[i - 1][j];
                // 对于选 k 次第 i 个数的情况
                for (int k = 1; k * t <= j; k++) {
                    // 能够选择 k 个 t 的前提是剩余的数字 j - k * t 也能被凑出
                    // 使用 0x3f3f3f3f 作为最大值（预留累加空间）可以省去该判断
                    if (f[i - 1][j - k * t] != -1) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - k * t] + k);
                    }
                }

            }
        }
        return f[len - 1][n];
    }
}
