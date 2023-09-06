package org.zhy.dynamicprogramming;

/**
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class LeetCode518 {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        f[0][0] = 1;   // 使用0种货币，凑0元钱,也是一种方案
        for (int i = 1; i <= n; i++) {
            int v = coins[i - 1];
            for (int j = 0; j <= amount; j++)
                for (int k = 0; k * v <= j; k++)
                    f[i][j] += f[i - 1][j - k * v];  //状态计算方程
        }
        return f[n][amount];
    }
}
