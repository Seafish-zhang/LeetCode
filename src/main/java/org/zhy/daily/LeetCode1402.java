package org.zhy.daily;

import java.util.Arrays;

/**
 * 1402. 做菜顺序
 * 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。
 * 一道菜的 「 like-time 系数 」定义为烹饪这道菜结束的时间（包含之前每道菜所花费的时间）乘以这道菜的满意程度，
 * 也就是 time[i]*satisfaction[i] 。
 * 返回厨师在准备了一定数量的菜肴后可以获得的最大 like-time 系数 总和。
 * 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
 */
public class LeetCode1402 {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int f = 0; // f(0) = 0
        int s = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            s += satisfaction[i];
            if (s <= 0) { // 后面不可能找到更大的 f(k)
                break;
            }
            f += s; // f(k) = f(k-1) + s
        }
        return f;
    }
}
