package org.zhy.thousand.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 */
public class LeetCode30 {

    public static void main(String[] args) {
        new LeetCode30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        int length = words[0].length();
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(word);
        }
        for (int i = 0; i <= s.length() - length * wordList.size(); i++) {
            String current = s.substring(i, i + length);
            if (wordList.contains(current)) {
                wordList.remove(current);
                match(result, wordList, s, i, i + length, length);
                wordList.add(current);
            }
        }
        return result;
    }

    private void match(List<Integer> result, List<String> wordList, String s, int start, int index, int length) {
        if (wordList.isEmpty()) {
            result.add(start);
            return;
        }
        if (index <= s.length() - length * wordList.size()) {
            String current = s.substring(index, index + length);
            if (wordList.contains(current)) {
                wordList.remove(current);
                match(result, wordList, s, start, index + length, length);
                wordList.add(current);
            }
        }
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        List<String> wordList = Arrays.asList(words);
        Collections.sort(wordList);

        //有几个单词
        int wordsLen = words.length;
        //每个单词长度
        int wordLen = words[0].length();
        //s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串 ,所以总长度
        int wordsLenSum = wordsLen * wordLen;
        if (s.length() < wordsLenSum) {
            return res;
        }
        for (int i = 0; i <= s.length() - wordsLenSum; i++) {
            String subStr = s.substring(i, i + wordsLenSum);
            List<String> tmpList = new ArrayList<>();
            for (int k = 0; k < subStr.length(); k = k + wordLen) {
                tmpList.add(subStr.substring(k, k + wordLen));
            }
            Collections.sort(tmpList);
            if (tmpList.equals(wordList)) {
                res.add(i);
            }
        }
        return res;
    }
}
