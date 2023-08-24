package org.zhy.dynamicprogramming;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class LeetCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int min = Integer.MAX_VALUE;
        int left;
        int right;
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                left = Integer.MAX_VALUE;
                right = Integer.MAX_VALUE;
                if (i - 1 >= 0) {
                    Integer current = triangle.get(i).get(j);
                    List<Integer> tmp = triangle.get(i - 1);
                    if (j - 1 >= 0) {
                        left = tmp.get(j - 1);
                    }
                    if (j < tmp.size()) {
                        right = tmp.get(j);
                    }
                    current += Math.min(left, right);
                    triangle.get(i).set(j, current);
                    if (i == triangle.size() - 1) {
                        min = Math.min(current, min);
                    }
                }
            }
        }
        return min;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        //创建n*m的二维数组
        int[][] dp = new int[n][m];
        //初始化dp[0][0]
        dp[0][0] = triangle.get(0).get(0);
        //第一列需要单独计算
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < n; ++i) {
            int j = 1;
            //注意计算的是三角形每一行的长度都不同
            //最后一列需要单独计算(斜边)，所以是从遍历的个数是size()-1
            while (j < triangle.get(i).size() - 1) {
                //状态转移公式
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                ++j;
            }
            //三角形斜边需要单独计算
            dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
        }
        //最后一行保存了每条路径的计算结果，对最后一行数组求min即为最终结果
        int[] tmp = dp[n - 1];
        int min = Integer.MAX_VALUE;
        for (int i : tmp) {
            min = Math.min(min,i);
        }
        return min;
    }

}
