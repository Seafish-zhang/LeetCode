package org.zhy.thousand.hundred;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] charArray = s.toCharArray();
        int maxStart = 0;
        int maxEnd = 0;
        int max = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (isPalindrome(charArray, i, j)) {
                    if (j - i > max) {
                        max = j - i;
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    private boolean isPalindrome(char[] charArray, int start, int end) {
        if (charArray.length == 0) {
            return false;
        }
        while (start < end) {
            if (charArray[start] == charArray[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 中心扩散法：假定当前位置是回文子串中心
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] charArray = s.toCharArray();
        int maxStart = 0;
        int maxEnd = 0;
        int max = 0;
        for (int mid = 0; mid < charArray.length; mid++) {
            int len = 1;
            int left = mid - 1;
            int right = mid + 1;
            //扩展前，左右相同字符都可以算进去回文串
            while (left >= 0 && charArray[left] == charArray[mid]) {
                left--;
                len++;//与mid字符一致，回文长度+1
            }
            while (right <= charArray.length - 1 && charArray[right] == charArray[mid]) {
                right++;//right字符与mid字符一致，继续左移
                len++;//与mid字符一致，回文长度+1
            }
            //开始同时向左右两侧扩展
            while (left >= 0 && right <= charArray.length - 1 && charArray[left] == charArray[right]) {
                //注意此处，在最后一次循环中，即最长回文子串索引为：i~j，此时的left=i-1，right=j+1
                left--;
                right++;
                len += 2;
            }
            if (len > max) {
                maxStart = left;
                maxEnd = right;
                max = len;
            }
        }
        return s.substring(maxStart + 1, maxEnd);
    }
}
