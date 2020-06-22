package leetcode.数据结构.二叉树;

import common.TreeNode;

/**
 * 描述:
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * @author luokui
 * @create 2020-06-22 10:43
 */
public class L450_Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode min = minNode(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);

        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    TreeNode minNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
