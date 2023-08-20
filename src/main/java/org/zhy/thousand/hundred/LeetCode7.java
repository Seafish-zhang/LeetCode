package org.zhy.thousand.hundred;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class LeetCode7 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE % 10);
        System.out.println(Integer.MIN_VALUE % 10);
    }

    public int reverse(int x) {
        int result = 0;
        int tmp = 0;
        while (x != 0) {
            tmp = x % 10;
            //判断溢出（是否大于最大值 2 ^ 31 - 1 = 2147483647 或者 小于最大值 -2 ^ 31 = -2147483648）
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tmp > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && tmp < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            result = result * 10 + tmp;
            x = x / 10;

        }
        return result;
    }
}
