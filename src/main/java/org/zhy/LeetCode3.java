package org.zhy;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 0) {
            return 0;
        }
        int max = 1;
        Map<Character, Integer> tmp = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            tmp.put(charArray[i], 1);
            for (int j = i + 1; j < charArray.length; j++) {
                if (tmp.containsKey(charArray[j])) {
                    max = j - i > max ? j - i : max;
                    break;
                } else {
                    tmp.put(charArray[j], 1);
                    max = j - i + 1 > max ? j - i + 1 : max;
                }
            }
            tmp.clear();
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            result = Math.max(result, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return result;
    }

}
