package org.zhy;

import java.util.*;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class LeetCode18 {
    public static void main(String[] args) {
        new LeetCode18().fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        System.out.println(1000000000 + 1000000000 + 1000000000 + 1000000000);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> exist = new HashMap<>();
        int len = nums.length;
        if (len < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    //转换成long防止溢出
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        String key = "" + nums[i] + nums[j] + nums[left] + nums[right];
                        if (!exist.containsKey(key)) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            exist.put(key, 1);
                        }
                        left++;
                        right--;
                    } else if (sum < target) left++;
                    else right--;
                }
            }

        }
        return result;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int first = 0; first < n - 3; first++) {
            long x = nums[first]; // 使用 long 避免溢出
            if (first > 0 && x == nums[first - 1]) continue; // 跳过重复数字
            if (x + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) break; // 优化一
            if (x + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue; // 优化二
            for (int second = first + 1; second < n - 2; second++) { // 枚举第二个数
                int y = nums[second];
                if (second > first + 1 && y == nums[second - 1]) continue; // 跳过重复数字
                if (x + y + nums[second + 1] + nums[second + 2] > target) break; // 优化一
                if (x + y + nums[n - 2] + nums[n - 1] < target) continue; // 优化二
                int third = second + 1, fourth = n - 1;
                while (third < fourth) { // 双指针枚举第三个数和第四个数
                    long s = x + y + nums[third] + nums[fourth]; // 四数之和
                    if (s > target) fourth--;
                    else if (s < target) third++;
                    else { // s == target
                        result.add(List.of((int) x, (int) y, nums[third], nums[fourth]));
                        for (third++; third < fourth && nums[third] == nums[third - 1]; third++) ; // 跳过重复数字
                        for (fourth--; fourth > third && nums[fourth] == nums[fourth + 1]; fourth--) ; // 跳过重复数字
                    }
                }
            }
        }
        return result;
    }

}

