package leetcode.数据结构.二叉树;

import common.TreeNode;

/**
 * 描述:镜像二叉树
 *
 * @author luokui
 * @create 2020-08-26 19:49
 */
public class L101_Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right == null) return false;
        if (left == null && right != null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }
}
