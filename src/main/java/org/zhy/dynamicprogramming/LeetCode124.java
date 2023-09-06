package org.zhy.dynamicprogramming;

import org.zhy.structure.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class LeetCode124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getCurrentMaxPath(root);
        return max;
    }

    private int getCurrentMaxPath(TreeNode node) {
        if (node == null) {
            // 没有节点，和为 0
            return 0;
        }
        // 左子树最大链和
        int lVal = getCurrentMaxPath(node.left);
        // 右子树最大链和
        int rVal = getCurrentMaxPath(node.right);
        // 两条链拼成路径
        max = Math.max(max, lVal + rVal + node.val);
        // 当前子树最大链和
        return Math.max(Math.max(lVal, rVal) + node.val, 0);
    }

}
