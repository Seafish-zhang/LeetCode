package org.zhy;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 */
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            //定位i，另外两个用start和end从分别剩下排序数组中两头往中间靠
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - result))
                    //当前的值更接近目标值
                    result = sum;
                if (sum > target)
                    // 如果当前值大于目标值，需要减少当前值，end回退
                    end--;
                else if (sum < target)
                    // 如果当前值小于目标值，需要增加当前值，start前进
                    start++;
                else return result;
            }
        }
        return result;
    }
}
