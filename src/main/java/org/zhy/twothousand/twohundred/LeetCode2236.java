package org.zhy.twothousand.twohundred;

import org.zhy.structure.TreeNode;

/**
 * 2236. 判断根结点是否等于子结点之和
 * 给你一个 二叉树 的根结点 root，该二叉树由恰好 3 个结点组成：根结点、左子结点和右子结点。
 * 如果根结点值等于两个子结点值之和，返回 true ，否则返回 false 。
 */
public class LeetCode2236 {

    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.val == getTreeNodeAllValue(root.left) + getTreeNodeAllValue(root.right);
    }

    private int getTreeNodeAllValue(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return root.val + getTreeNodeAllValue(root.left) + getTreeNodeAllValue(root.right);
        }
    }
}
