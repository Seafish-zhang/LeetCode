package org.zhy.daily;

import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LeetCode146 {


    class LRUCache {
        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            // 将 key 变为最近使用
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int val) {
            if (cache.containsKey(key)) {
                // 修改 key 的值
                cache.put(key, val);
                // 将 key 变为最近使用
                makeRecently(key);
                return;
            }

            if (cache.size() >= this.cap) {
                // 链表头部就是最久未使用的 key
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            // 将新的 key 添加链表尾部
            cache.put(key, val);
        }

        private void makeRecently(int key) {
            int val = cache.get(key);
            // 删除 key，重新插入到队尾
            cache.remove(key);
            cache.put(key, val);
        }
    }
}
