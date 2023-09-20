package org.zhy.daily;

/**
 * 1163. 按字典序排在最后的子串
 * 给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 */
public class LeetCode1163 {

    public String lastSubstring(String s) {
        int length = s.length();
        int left = 0, right = 1, step = 0;
        while (right + step < length) {
            if (s.charAt(left + step) == s.charAt(right + step)) {
                step++;
            } else {
                if (s.charAt(left + step) < s.charAt(right + step)) {
                    left += step + 1;
                } else {
                    right += step + 1;
                }
                step = 0;
                right = Math.max(right, left + 1);
            }
        }
        return s.substring(left);
    }

}
