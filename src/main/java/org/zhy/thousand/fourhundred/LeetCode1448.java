package org.zhy.thousand.fourhundred;

import org.zhy.structure.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 */
public class LeetCode1448 {

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        new LeetCode1448().goodNodes(node0);
    }

    public int goodNodes(TreeNode root) {
        return getGoodNodes(root, Integer.MIN_VALUE);
    }

    private int getGoodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val >= max) {
            sum++;
            max = root.val;
        }
        if (root.left != null) {
            sum += getGoodNodes(root.left, max);
        }
        if (root.right != null) {
            sum += getGoodNodes(root.right, max);
        }
        return sum;
    }
}
