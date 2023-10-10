package org.zhy.daily;

import java.util.*;

/**
 * 2512. 奖励最顶尖的 K 名学生
 * 给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。
 * 不会 有单词同时是正面的和负面的。
 * 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
 * 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，
 * 其中 student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
 * 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
 */
public class LeetCode2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : positive_feedback) {
            map.put(s, 3);
        }
        for (String s : negative_feedback) {
            map.put(s, -1);
        }
        int[] ans = new int[report.length];
        for (int i = 0; i < report.length; i++) {
            String[] temp = report[i].split(" ");
            int res = 0;
            for (String s : temp) {
                if (map.containsKey(s)) res += map.get(s);
            }
            ans[i] = res;
        }
        Integer[] id = new Integer[report.length];
        for (int i = 0; i < report.length; i++) id[i] = i;
        Arrays.sort(id, (a, b) -> ans[a] == ans[b] ? student_id[a] - student_id[b] : ans[b] - ans[a]);
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arr.add(student_id[id[i]]);
        }
        return arr;
    }
}
