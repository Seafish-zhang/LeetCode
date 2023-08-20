package org.zhy.thousand.hundred;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class LeetCode20 {

    public static void main(String[] args) {
        System.out.println(new LeetCode20().isValid("]"));
        System.out.println(new LeetCode20().isValid2("(" + ""));
    }

    public boolean isValid(String s) {
        Stack<Character> stack1 = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack1.push(c);
                    break;
                case ')':
                    if (stack1.isEmpty() || stack1.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack1.isEmpty() || stack1.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack1.isEmpty() || stack1.pop() != '[') {
                        return false;
                    }
                    break;
                default:
            }
        }
        return stack1.isEmpty();
    }

    /**
     * 优化写法
     */
    public boolean isValid2(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
