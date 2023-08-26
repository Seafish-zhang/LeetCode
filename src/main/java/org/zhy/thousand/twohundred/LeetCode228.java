package org.zhy.thousand.twohundred;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class LeetCode228 {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int start = nums[0];
        boolean right = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                if (right) {
                    result.add(start + "->" + nums[i - 1]);
                } else {
                    result.add(start + "");
                }
                start = nums[i];
                right = false;
            } else {
                right = true;
            }
        }
        if (right) {
            result.add(start + "->" + nums[nums.length - 1]);
        } else {
            result.add(start + "");
        }

        return result;
    }
}
