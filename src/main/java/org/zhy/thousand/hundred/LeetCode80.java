package org.zhy.thousand.hundred;

/**
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int current = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[current] != nums[i]) {
                current++;
                nums[current] = nums[i];
                count = 1;
            } else {
                if (count < 2) {
                    count++;
                    current++;
                    nums[current] = nums[i];
                }
            }
        }
        return current + 1;
    }
}
