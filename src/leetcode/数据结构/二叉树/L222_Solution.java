package leetcode.数据结构.二叉树;

import common.TreeNode;

/**
 * 描述:
 * 给出一个完全二叉树，求出该树的节点个数。
 * log n * log n 的时间复杂度
 *
 * @author luokui
 * @create 2020-06-22 11:37
 */
public class L222_Solution {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = 0, rh = 0;
        TreeNode l = root;
        TreeNode r = root;
        while (l != null) {
            l = l.left;
            lh++;
        }
        while (r != null) {
            r = r.right;
            rh++;
        }
        if (lh == rh) {
            return ((Double) Math.pow(2, lh)).intValue() - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
