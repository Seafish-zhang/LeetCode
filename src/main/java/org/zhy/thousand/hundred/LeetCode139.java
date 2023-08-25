package org.zhy.thousand.hundred;

import java.util.*;

/**
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class LeetCode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        int n = s.length();
        boolean[] f = new boolean[n + 10];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && !f[i]; j++) {
                String sub = s.substring(j - 1, i);
                if (set.contains(sub)) {
                    f[i] = f[j - 1];
                }
            }
        }
        return f[n];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        LinkedList<String> current = new LinkedList<>();
        List<String> result = new ArrayList<>();
        match(s, 0, current, result, wordSet);
        return !result.isEmpty();
    }

    private void match(String s, int start, LinkedList<String> current, List<String> result, Set<String> wordSet) {
        // 满足条件，存储当前路径
        if (start == s.length()) {
            // 用空格相连
            result.add(String.join(" ", current));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 切分字符串
            String word = s.substring(start, i + 1);
            // 不在 wordSet 中，则跳过
            if (!wordSet.contains(word)) {
                continue;
            }

            // 添加到路径中
            current.addLast(word);
            match(s, i + 1, current, result, wordSet);
            // 撤销操作
            current.removeLast();
        }
    }
}
