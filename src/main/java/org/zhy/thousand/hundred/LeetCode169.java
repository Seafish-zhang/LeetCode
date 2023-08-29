package org.zhy.thousand.hundred;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class LeetCode169 {

    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
                count = 1;
            } else if (result == num) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
