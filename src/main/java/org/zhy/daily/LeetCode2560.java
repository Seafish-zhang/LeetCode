package org.zhy.daily;

/**
 * 2560. 打家劫舍 IV
 * 沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 * 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 * 返回小偷的 最小 窃取能力。
 */
public class LeetCode2560 {

    public int minCapability(int[] nums, int k) {
        // 二分查找，窃取能力的左右边界初始为最小金额和最大金额
        int left = Integer.MAX_VALUE, right = 0;
        for(int num: nums){
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        // 二分查找，搜索区间左右闭合[left, right]
        int mid;
        int res = 0;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if(check(nums, k , mid)){   // 窃取能力为mid时，能满足偷至少k间房屋
                res = mid;  // 这是一个潜在的答案，记录
                right = mid - 1;    // 缩小右边界以寻找更小的窃取能力
            }else{   // 窃取能力为mid时，不满足偷至少k间房屋
                left = mid + 1; // 增大左边界提高窃取能力从而提高偷的房屋数量
            }
        }
        return res;
    }

    // 判断窃取能力为y时，能偷的房屋数是否满足至少k间房屋
    private boolean check(int[] nums, int k, int y){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= y){
                count++;
                i++;
            }
        }
        return count >= k;
    }
}
