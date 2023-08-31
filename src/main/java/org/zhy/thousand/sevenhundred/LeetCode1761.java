package org.zhy.thousand.sevenhundred;

/**
 * 1761. 一个图中连通三元组的最小度数
 * 给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，
 * 其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向边。
 * 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
 * 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
 * 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。
 */
public class LeetCode1761 {
    public int minTrioDegree(int n, int[][] edges) {
        int ans = Integer.MAX_VALUE;
        int[] inDegrees = new int[n];
        boolean[][] isConnected = new boolean[n][n];
        for (int[] edge : edges) {
            isConnected[edge[0] - 1][edge[1] - 1] = true;
            isConnected[edge[1] - 1][edge[0] - 1] = true;
            inDegrees[edge[0] - 1]++;
            inDegrees[edge[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isConnected[i][j] && isConnected[j][k] && isConnected[k][i]) {
                        ans = Math.min(ans, inDegrees[i] + inDegrees[j] + inDegrees[k] - 6);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
