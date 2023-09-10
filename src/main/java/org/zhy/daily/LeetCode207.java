package org.zhy.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] needPreArr = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        for(int[] cp : prerequisites) {
            needPreArr[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        for(int i = 0; i < numCourses; i++)
            if(needPreArr[i] == 0) queue.add(i);
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--needPreArr[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }
}
