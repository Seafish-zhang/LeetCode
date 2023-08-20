package org.zhy.thousand.hundred;

/**
 * 8. 字符串转换整数 (atoi)
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 */
public class LeetCode8 {

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int flag = 0;
        int result = 0;
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                if (flag == 0) {
                    flag = 1;
                }
                if (flag > 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && ((int) c - 48) > Integer.MAX_VALUE % 10))) {
                    return Integer.MAX_VALUE;
                }
                if (flag < 0 && (flag * result < Integer.MIN_VALUE / 10 || (flag * result == Integer.MIN_VALUE / 10 && flag * ((int) c - 48) < Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + ((int) c - 48);
            } else {
                if (flag != 0) {
                    break;
                } else if (c == ' ') {
                    continue;
                } else if (c == '+') {
                    if (flag == 0) {
                        flag = 1;
                    } else {
                        break;
                    }
                } else if (c == '-') {
                    if (flag == 0) {
                        flag = -1;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result * flag;
    }
}
