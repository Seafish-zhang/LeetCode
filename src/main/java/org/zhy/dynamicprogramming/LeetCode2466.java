package org.zhy.dynamicprogramming;

/**
 * 2466. 统计构造好字符串的方案数
 * 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
 * 将 '0' 在字符串末尾添加 zero  次。
 * 将 '1' 在字符串末尾添加 one 次。
 * 以上操作可以执行任意次。
 * 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
 * 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
 */
public class LeetCode2466 {

    public static void main(String[] args) {
        System.out.println((int) (10e8 + 7));
        System.out.println(1000000007);
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = (int) (10e8 + 7);
        long result = 0;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 0; i < high + 1; ++i) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            }
            if (i >= one) {
                dp[i] += dp[i - one];
            }
            dp[i] %= mod;
            if (i >= low) {
                result += dp[i];
            }
        }
        return (int) (result % mod);
    }
}
