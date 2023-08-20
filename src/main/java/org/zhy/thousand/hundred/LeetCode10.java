package org.zhy.thousand.hundred;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class LeetCode10 {

    public static void main(String[] args) {
        System.out.println(new LeetCode10().isMatch("ab", ".*c"));
    }

    public boolean isMatch(String s, String p) {
        //设 s 的长度为 n ， p 的长度为 m ；将 s 的第 i 个字符记为 si,p的第 j 个字符记为 pj
        //将 s 的前 i 个字符组成的子字符串记为 s[:i] , 同理将 p 的前 j 个字符组成的子字符串记为 p[:j]
        // 本题可转化为求 s[:n] 是否能和 p[:m]匹配。
        //总体思路是从 s[:1]和 p[:1]开始判断是否能匹配，每轮添加一个字符并判断是否能匹配，
        // 直至添加完整个字符串 s 和 p 。展开来看，假设 s[:i] 与 p[:j] 可以匹配，那么下一状态有两种：
        //添加一个字符 s(i+1) 后是否能匹配？
        //添加字符 p(j+1)后是否能匹配？


        int m = s.length() + 1;
        int n = p.length() + 1;
        //动态规划
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int j = 2; j < n; j += 2) {
            // 因为‘*’匹配可以位0，那么如果s前面已经和p的*前两位已经匹配上，那么接下来的"任意值*"也相当匹配上
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        // dp[i][j] 对应的添加字符是 s[i - 1] 和 p[j - 1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果p[j-1]字符是‘*’时，如果
                //1、因为‘*’匹配可以位0，那么如果s前面已经和p的*前两位已经匹配上，那么接下来的"任意值*"也相当匹配上
                //2、如果s[i-2]和p[j-1]匹配上，且s[i-1]=p[j-2]或者p[j-2]=’.‘；即说明s[i-1]也能匹配p【j-1】的’*‘
                // 即类似这种情况 s:“aaa” p：“a*” 或者s:“aaa” p：”.*“ ,
                // 当s的前两位能匹配p时，且第三位也还是等于p中’*‘前面的字符，那么可以让’*‘多匹配一次
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                } else {
                    // 判断p[j-1]当前非‘*’ 情况下，如果p当前位‘.’或者s[i-1]==p[j-1],那么也能匹配上
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
