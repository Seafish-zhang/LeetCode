package org.zhy.thousand.threehundred;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 */
public class LeetCode380 {

    class RandomizedSet {
        int[] nums = new int[200010];
        Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        int idx = -1;

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            nums[++idx] = val;
            map.put(val, idx);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int loc = map.remove(val);
            if (loc != idx) map.put(nums[idx], loc);
            nums[loc] = nums[idx--];
            return true;
        }

        public int getRandom() {
            return nums[random.nextInt(idx + 1)];
        }
    }
}
