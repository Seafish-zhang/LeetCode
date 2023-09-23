package org.zhy.daily;

import java.util.ArrayList;
import java.util.List;


/**
 * 1993. 树上的操作
 * 给你一棵 n 个节点的树，编号从 0 到 n - 1 ，以父节点数组 parent 的形式给出，
 * 其中 parent[i] 是第 i 个节点的父节点。树的根节点为 0 号节点，所以 parent[0] = -1 ，因为它没有父节点。你想要设计一个数据结构实现树里面对节点的加锁，解锁和升级操作。
 * 数据结构需要支持如下函数：
 * Lock：指定用户给指定节点 上锁 ，上锁后其他用户将无法给同一节点上锁。只有当节点处于未上锁的状态下，才能进行上锁操作。
 * Unlock：指定用户给指定节点 解锁 ，只有当指定节点当前正被指定用户锁住时，才能执行该解锁操作。
 * Upgrade：指定用户给指定节点 上锁 ，并且将该节点的所有子孙节点 解锁 。只有如下 3 个条件 全部 满足时才能执行升级操作：
 * 指定节点当前状态为未上锁。
 * 指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
 * 指定节点没有任何上锁的祖先节点。
 * 请你实现 LockingTree 类：
 * lock(int num, int user) 如果 id 为 user 的用户可以给节点 num 上锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 id 为 user 的用户 上锁 。
 * unlock(int num, int user) 如果 id 为 user 的用户可以给节点 num 解锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 变为 未上锁 状态。
 * upgrade(int num, int user) 如果 id 为 user 的用户可以给节点 num 升级，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 升级 。
 */
public class LeetCode1993 {

    class LockingTree {

        int[] locker;   // 上锁用户数组，记录每个节点的上锁用户
        int[] parent;   // 父节点数组
        List<List<Integer>> children;   // 子节点列表

        /**
         * LockingTree(int[] parent) 用父节点数组初始化数据结构。
         *
         * @param parent 父节点数组
         */
        public LockingTree(int[] parent) {
            // 初始化数据
            int n = parent.length;
            locker = new int[n];
            children = new ArrayList<>();
            this.parent = parent;
            for (int i = 0; i < n; i++) {
                children.add(new ArrayList<>());
            }
            for (int i = 1; i < n; i++) {
                children.get(parent[i]).add(i); // 从根节点之后开始，根据每一对父子节点关系记录到对应的子节点列表中
            }
        }

        /**
         * lock(int num, int user) 如果 id 为 user 的用户可以给节点 num 上锁，那么返回 true ，
         * 否则返回 false 。如果可以执行此操作，节点 num 会被 id 为 user 的用户 上锁 。
         *
         * @param num  节点 num
         * @param user 用户id
         * @return 是否可以上锁
         */
        public boolean lock(int num, int user) {
            if (locker[num] == 0) {
                locker[num] = user; // 未上锁的节点才能上锁
                return true;
            }
            return false;
        }

        /**
         * unlock(int num, int user) 如果 id 为 user 的用户可以给节点 num 解锁，那么返回 true ，
         * 否则返回 false 。如果可以执行此操作，节点 num 变为 未上锁 状态。
         *
         * @param num  节点 num
         * @param user 用户id
         * @return 是否可以解锁
         */
        public boolean unlock(int num, int user) {
            if (locker[num] == user) {
                locker[num] = 0;    // 解锁用户为上锁用户才能解锁
                return true;
            }
            return false;
        }

        /**
         * upgrade(int num, int user) 如果 id 为 user 的用户可以给节点 num 升级，那么返回 true ，
         * 否则返回 false 。如果可以执行此操作，节点 num 会被 升级 。
         *
         * @param num  节点 num
         * @param user 用户id
         * @return 是否可以升级
         */
        public boolean upgrade(int num, int user) {
            if (locker[num] == 0 && !isAncetorsLocked(num) && checkAndUnlockDescendants(num)) {
                locker[num] = user;
                return true;
            }
            return false;
        }

        /**
         * 返回节点num是否有祖先节点上锁
         */
        private boolean isAncetorsLocked(int num) {
            int anc = parent[num];    // 获取num的祖先节点，初始为num的父节点
            while (anc != -1) {
                if (locker[anc] > 0) return true;   // 找到上锁的祖先节点，直接返回false
                anc = parent[anc];  // 向上更新祖先节点
            }
            return false;   // 搜索到根都没有上锁的祖先节点，返回false
        }

        /**
         * 检查节点num是否有后代节点上锁，并将上锁节点解锁
         */
        private boolean checkAndUnlockDescendants(int num) {
            boolean flag = false;   // 标记是否有后代节点上锁，初始为false
            for (int child : children.get(num)) {
                flag |= locker[child] > 0;  // 更新flag，只要有子节点上锁整个结果就为true，因此用或运算更新
                locker[child] = 0;  // 未上锁的节点保持未上锁，上锁节点解锁
                flag |= checkAndUnlockDescendants(child);   // 递归搜索子节点的后代节点，并用结果更新flag
            }
            return flag;
        }
    }
}
