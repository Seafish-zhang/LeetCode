package org.zhy.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 2316. 统计无向图中无法互相到达点对数
 * 给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，
 * 其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
 * 请你返回 无法互相到达 的不同 点对数目 。
 */
public class LeetCode2316 {
    boolean[] visited;

    public long countPairs(int n, int[][] edges) {
        // 建图
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            links.get(e[0]).add(e[1]);
            links.get(e[1]).add(e[0]);
        }
        // 深度优先搜索
        visited = new boolean[n];   // 记录节点是否搜索过
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;     // 已搜索过的连通块的节点，跳过
            long cnt = dfs(i, links);   // 搜索节点所在的连通块的节点数
            res += cnt * (n - cnt);     // 一个连通块的所有节点和连通块以外的节点都互相不可达
        }
        return res / 2;     // 每个节点对被算了两次，除以2
    }

    private int dfs(int node, List<List<Integer>> links) {
        visited[node] = true;   // 当前节点已经访问过了
        int cnt = 1;    // 统计从这个节点可达的不重复的节点个数，初始个数为一个，表示节点本身
        for (int next : links.get(node)) {
            if (!visited[next]) cnt += dfs(next, links);  // 递归搜索相邻节点的可达不重复节点个数
        }   // 深度优先搜索，找到这个节点所在的连通块的所有节点
        return cnt;
    }
}
