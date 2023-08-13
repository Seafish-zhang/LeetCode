package org.zhy;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class LeetCode1 {

    /**
     * 双重循环
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new NullPointerException("没有符合值");
    }

    /**
     * 利用Map
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.containsKey(target - nums[i])) {
                return new int[]{i, temp.get(target - nums[i])};
            } else {
                temp.put(nums[i], i);
            }
        }
        throw new NullPointerException("没有符合值");
    }
}
