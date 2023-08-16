package org.zhy;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                current = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(current, max);
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int current = 0;
        int left = 0;
        int right = height.length - 1;
        //双指针向中间移动
        while (left < right) {
            current = Math.min(height[left], height[right]) * (right - left);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            max = Math.max(current, max);
        }
        return max;
    }
}
