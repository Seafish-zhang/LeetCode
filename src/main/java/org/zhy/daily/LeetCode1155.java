package org.zhy.daily;

/**
 * 1155. 掷骰子等于目标和的方法数
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 kn 种方式中)滚动骰子的数量，
 * 使正面朝上的数字之和等于 target 。
 * 答案可能很大，你需要对 109 + 7 取模 。
 */
public class LeetCode1155 {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1000000007;     // 模值
        int[][] dp = new int[n + 1][target + 1];    // dp[i][j]表示i个骰子和为j的情况数
        dp[0][0] = 1;   // dp[0][0]初始为1，表示0个骰子和为0的情况只有一种
        for (int i = 1; i <= n; i++) {    // 依次枚举骰子数
            for (int s = 1; s <= target; s++) {   // 依次枚举和的情况，因为所有值都为正，因此只需要找到target即可
                for (int j = 1; j <= k; j++) {    // 枚举第i个骰子的值情况
                    if (s - j < 0) continue;     // 值大于和，这个值不可能参与到构成和s中
                    dp[i][s] += dp[i - 1][s - j];   // 状态转移
                    dp[i][s] %= MOD;                // 取模
                }
            }
        }
        return dp[n][target];   // 表示n个骰子和为target的情况数
    }
}
