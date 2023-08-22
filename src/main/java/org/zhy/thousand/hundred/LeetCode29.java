package org.zhy.thousand.hundred;

/**
 * 29. 两数相除
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
 */
public class LeetCode29 {

    public static void main(String[] args) {
        new LeetCode29().divide(-2147483648, -1);
    }

    public int divide(int dividend, int divisor) {
        int limit = -1073741824;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int flag = -1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = 1;
        }
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int result = 0;
        while (dividend <= divisor) {
            int current = divisor;
            int cout = -1;
            while (current >= limit && cout >= limit && current >= dividend - current) {
                current += current;
                cout += cout;
            }
            dividend -= current;
            result += cout;

        }

        return flag * result;
    }
}
