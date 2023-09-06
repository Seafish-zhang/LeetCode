package org.zhy.dynamicprogramming;

import org.zhy.structure.TreeNode;

import java.util.HashMap;

/**
 * 337. 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 */
public class LeetCode337 {

    public int rob(TreeNode root) {
        int[] result = robDp(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robDp(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = robDp(root.left);
        int[] right = robDp(root.right);
        //[0]表示不偷当前的，则等于左孩子最大值加上右孩子最大值
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //[0]表示偷当前的，则等于不偷左孩子最大值加上不偷右孩子最大值再加上当前值
        result[1] = left[0] + right[0] + root.val;
        return result;
    }

    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        // 如果偷当前节点也可以偷节点的孙节点
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }

        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }
        // 判断是偷当前节点，还是偷当前节点的子节点
        return Math.max(money, rob(root.left) + rob(root.right));
    }

    public int rob3(TreeNode root) {
        HashMap<TreeNode, Integer> exist = new HashMap<>();
        return robNoRepeat(root, exist);
    }

    public int robNoRepeat(TreeNode root, HashMap<TreeNode, Integer> exist) {
        // 不重复计算
        if (root == null) {
            return 0;
        }
        if (exist.containsKey(root)) {
            return exist.get(root);
        }
        int money = root.val;

        if (root.left != null) {
            money += (robNoRepeat(root.left.left, exist) + robNoRepeat(root.left.right, exist));
        }
        if (root.right != null) {
            money += (robNoRepeat(root.right.left, exist) + robNoRepeat(root.right.right, exist));
        }
        int result = Math.max(money, robNoRepeat(root.left, exist) + robNoRepeat(root.right, exist));
        exist.put(root, result);
        return result;
    }
}
