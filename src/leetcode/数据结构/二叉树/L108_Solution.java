package leetcode.数据结构.二叉树;

import common.TreeNode;

/**
 * 描述:
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * @author luokui
 * @create 2020-08-27 20:34
 */
public class L108_Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = sortedArrayToBST(nums, left, mid - 1);
        n.right = sortedArrayToBST(nums, mid + 1, right);
        return n;

    }

}
