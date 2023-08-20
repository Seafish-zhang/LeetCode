package org.zhy.thousand.hundred;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String current = "";
        match(result, current, n, n);
        return result;
    }

    private void match(List<String> result, String current, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(current);
        } else {
            if (left > right) {
                // 缺少的左括号大于缺少的右括号，说明当前字符串中左括号少于右括号
                // 错误递归
                return;
            }
            if (left > 0) {
                match(result, current + '(', left - 1, right);
            }
            if (right > 0) {
                match(result, current + ')', left, right - 1);
            }
        }
    }
}
