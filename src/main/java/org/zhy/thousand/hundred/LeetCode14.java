package org.zhy.thousand.hundred;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = strs[0].toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char current = charArray[i];
            boolean allMatch = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != current) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) {
                sb.append(current);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
