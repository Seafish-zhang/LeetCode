package org.zhy.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 1462. 课程表 IV
 * 你总共需要上 numCourses 门课，课程编号依次为 0 到 numCourses-1 。你会得到一个数组 prerequisite ，
 * 其中 prerequisites[i] = [ai, bi] 表示如果你想选 bi 课程，你 必须 先选 ai 课程。
 * 有的课会有直接的先修课程，比如如果想上课程 1 ，你必须先上课程 0 ，那么会以 [0,1] 数对的形式给出先修课程数对。
 * 先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。
 * 你也得到一个数组 queries ，其中 queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程 uj 是否是课程 vj 的先决条件。
 * 返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。
 */
public class LeetCode1462 {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // if preQ[a][b] = true 那么a是b的先决条件
        boolean[][] preQ = new boolean[numCourses][numCourses];
        // 建立图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] inorder = new int[numCourses];
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            inorder[b]++;
            graph.get(a).add(b);
        }
        // 做一个拓扑排序的预处理
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inorder[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int next : graph.get(poll)) {
                inorder[next]--;
                preQ[poll][next] = true;
                // 遍历前置节点poll的先决条件，施加到后置节点next上
                for (int i = 0; i < numCourses; i++) {
                    // 更新先决条件查询数组
                    if (preQ[i][poll]) preQ[i][next] = true;
                }
                if (inorder[next] == 0) queue.add(next);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (var q : queries) {
            ans.add(preQ[q[0]][q[1]]);
        }

        return ans;
    }

}
