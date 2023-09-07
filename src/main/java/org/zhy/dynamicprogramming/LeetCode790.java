package org.zhy.dynamicprogramming;

/**
 * 790. 多米诺和托米诺平铺
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 109 + 7 取模 的值。
 * 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，
 * 使得恰好有一个平铺有一个瓷砖占据两个正方形。
 */
public class LeetCode790 {


    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        long[] f = new long[n + 1];
        f[0] = f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; ++i)
            f[i] = (f[i - 1] * 2 + f[i - 3]) % (int) (1e9 + 7);
        return (int) f[n];
    }


    public int numTilings2(int n) {
        int[][] f = new int[2][4];
        f[1][0] = f[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            int a = i & 1, b = (i - 1) & 1;
            f[a][0] = f[b][1];
            int cur = 0;
            for (int j = 0; j < 4; j++) cur = (cur + f[b][j]) % (int) (1e9 + 7);
            f[a][1] = cur;
            f[a][2] = (f[b][0] + f[b][3]) % (int) (1e9 + 7);
            f[a][3] = (f[b][0] + f[b][2]) % (int) (1e9 + 7);
        }
        return f[n & 1][1];
    }

}
