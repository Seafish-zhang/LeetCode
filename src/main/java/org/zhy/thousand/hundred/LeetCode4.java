package org.zhy.thousand.hundred;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class LeetCode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        boolean single = (m + n) % 2 != 0;
        if (m == 0) {
            if (single) {
                return nums2[n / 2];
            } else {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            }
        } else if (n == 0) {
            if (single) {
                return nums1[m / 2];
            } else {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            }
        } else {
            int[] tmp = new int[(m + n) / 2 + 1];
            int count = 0;
            int target = (m + n) / 2;
            int i = 0;
            int j = 0;
            while (count <= target) {
                if (i == m) {
                    while (i + j <= target) {
                        tmp[count++] = nums2[j++];
                    }
                    break;
                }
                if (j == n) {
                    while (i + j <= target) {
                        tmp[count++] = nums1[i++];
                    }
                    break;
                }
                if (nums1[i] < nums2[j]) {
                    tmp[count++] = nums1[i++];
                } else {
                    tmp[count++] = nums2[j++];
                }
            }
            if (single) {
                return tmp[target];
            } else {
                return (tmp[target - 1] + tmp[target]) / 2.0;
            }
        }
    }
}
