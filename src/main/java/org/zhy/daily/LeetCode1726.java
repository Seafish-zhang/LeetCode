package org.zhy.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 1726. 同积元组
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。
 * 其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 */
public class LeetCode1726 {

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> mulCount = new HashMap<>();   // 存储数组中两两的乘积的个数
        int n = nums.length;
        int mul;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                mul = nums[i] * nums[j];
                mulCount.put(mul, mulCount.getOrDefault(mul, 0) + 1);   // 统计不同两个元素的乘积个数
            }
        }
        int res = 0;
        for (int cnt : mulCount.values()) {    // 枚举哈希表所有乘积的个数情况
            res += (cnt) * (cnt - 1) * 4;   // 每一种乘积取出两组元素，共有n(n-1)/2，两组元素共有8种情况
        }
        return res;
    }
}
