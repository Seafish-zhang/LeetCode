package org.zhy.daily;

/**
 * 2520. 统计能整除数字的位数
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 *
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 */
public class LeetCode2520 {

    public int countDigits(int num) {
        int n = num, ans = 0;
        while (num != 0) {
            ans += n % (num % 10) == 0 ? 1 : 0;
            num /= 10;
        }
        return ans;
    }
}
