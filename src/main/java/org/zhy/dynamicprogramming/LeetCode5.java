package org.zhy.dynamicprogramming;

/**
 * 5. 最长回文子串 （动态规划）
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 动态规划
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int max = 1;
        char[] charArray = s.toCharArray();
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 如果当之前子串时回文，那么在两头加入相同的字符，也是回文
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                    }
                }

            }
        }
        return s.substring(start, start + max);
    }
}
