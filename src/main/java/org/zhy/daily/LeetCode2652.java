package org.zhy.daily;

/**
 * 2652. 倍数求和
 * 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
 * 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
 */
public class LeetCode2652 {

    public int sumOfMultiples(int n) {
        return helper(n, 3) + helper(n, 5) + helper(n, 7) - helper(n, 3 * 5) - helper(n, 3 * 7) - helper(n, 5 * 7) + helper(n, 3 * 5 * 7);
    }

    private int helper(int n, int k) {
        int cnt = n / k;    // cnt * k 为小于等于n的最大数字
        return (k + cnt * k) * cnt / 2; // 等差数列求和公式
    }
}
