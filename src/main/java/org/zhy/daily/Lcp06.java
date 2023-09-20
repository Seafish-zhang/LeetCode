package org.zhy.daily;

/**
 * LCP 06. 拿硬币
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，
 * 求拿完所有力扣币的最少次数。
 */
public class Lcp06 {

    public int minCount(int[] coins) {
        int ans = 0;
        for (int x : coins) {
            ans += (x + 1) / 2;
        }
        return ans;
    }
}
