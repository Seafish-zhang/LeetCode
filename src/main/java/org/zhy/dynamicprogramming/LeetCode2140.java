package org.zhy.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 2140. 解决智力问题
 * 给你一个下标从 0 开始的二维整数数组 questions ，其中 questions[i] = [pointsi, brainpoweri] 。
 * 这个数组表示一场考试里的一系列题目，你需要 按顺序 （也就是从问题 0 开始依次解决），针对每个问题选择 解决 或者 跳过 操作。解决问题 i 将让你 获得  pointsi 的分数，但是你将 无法 解决接下来的 brainpoweri 个问题（即只能跳过接下来的 brainpoweri 个问题）。如果你跳过问题 i ，你可以对下一个问题决定使用哪种操作。
 * 比方说，给你 questions = [[3, 2], [4, 3], [4, 4], [2, 5]] ：
 * 如果问题 0 被解决了， 那么你可以获得 3 分，但你不能解决问题 1 和 2 。
 * 如果你跳过问题 0 ，且解决问题 1 ，你将获得 4 分但是不能解决问题 2 和 3 。
 * 请你返回这场考试里你能获得的 最高 分数。
 */
public class LeetCode2140 {

    public long mostPointsDp(int[][] questions) {
        long[] dp = new long[questions.length + 1];
        long max = 0;
        for (int i = questions.length - 1; i >= 0; i--) {
            if (questions[i][1] + i + 1 >= questions.length) {
                dp[i] = Math.max(questions[i][0], dp[i + 1]);
            } else {
                dp[i] = Math.max(questions[i][0] + dp[i + questions[i][1] + 1], dp[i + 1]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public long mostPoints(int[][] questions) {
        List<Long> result = new ArrayList<>();
        match(questions, result, 0, 0);
        long max = 0;
        for (Long i : result) {
            max = Math.max(max, i);
        }
        return max;
    }

    private void match(int[][] questions, List<Long> result, int index, long sum) {
        if (index >= questions.length) {
            result.add(sum);
        }

        for (int i = index; i < questions.length; i++) {
            int[] question = questions[i];
            int points = question[0];
            int brainpower = question[1];
            match(questions, result, i + brainpower + 1, sum + points);
        }
    }
}
