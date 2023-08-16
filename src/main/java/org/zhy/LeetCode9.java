package org.zhy;

/**
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        //有符号‘-’，必定不回文
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        if (s.isEmpty()) {
            return false;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }


    public boolean isPalindrome2(int x) {
        //边界判断
        if (x < 0) {
            return false;
        }
        //算出x的位数
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            // 取头
            int left = x / div;
            // 取尾
            int right = x % 10;
            if (left != right) {
                return false;
            }
            // 头尾两位相同了，去除头尾两位再计算 （1221%1000）/10=22
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 获取一半的相反数
        int revertedNumber = 0;
        while (x > revertedNumber) {
            // 每次增加x的最后一位
            revertedNumber = revertedNumber * 10 + x % 10;
            //每次去除最后一位，x逐步变成一半
            x /= 10;
        }
        // 偶位数就判断相等，如果是奇位数就判断去除一位后相等
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
