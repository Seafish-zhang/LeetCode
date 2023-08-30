package org.zhy.thousand.hundred;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class LeetCode34 {


    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[mid] != target) {
            return new int[]{-1, -1};
        } else {
            int start = mid;
            int end = mid;
            while (start > 0) {
                if (nums[start - 1] == target) {
                    start -= 1;
                } else {
                    break;
                }
            }
            while (end < nums.length - 1) {
                if (nums[end + 1] == target) {
                    end += 1;
                } else {
                    break;
                }
            }
            return new int[]{start, end};
        }
    }
}
