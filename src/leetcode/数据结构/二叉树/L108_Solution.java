package leetcode.数据结构.二叉树;

import common.TreeNode;

/**
 * 描述:
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
