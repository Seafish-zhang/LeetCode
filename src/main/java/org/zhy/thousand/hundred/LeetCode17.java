package org.zhy.thousand.hundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 1: 2:abc 3:def
 * 4:ghi 5:jkl :6 mno
 * 7:pqrs 8:tuv 9:wxyz
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LeetCode17 {

    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        char[] charArray = digits.toCharArray();
        List<String> result = new ArrayList<>();
        match(charArray, result, 0, map, new StringBuilder());
        return result;
    }

    private void match(char[] chars, List<String> result, int index, Map<Character, char[]> map, StringBuilder sb) {
        if (index == chars.length) {
            result.add(sb.toString());
        } else {
            char aChar = chars[index];
            char[] letters = map.get(aChar);
            for (int i = 0; i < letters.length; i++) {
                sb.append(letters[i]);
                match(chars, result, index + 1, map, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
