package hot100;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 817 👎 0


import common.TreeNode;

import java.util.Stack;

//L98、验证二叉搜索树 ----
public class L98_ValidateBinarySearchTree {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        /**
         * 直接中序遍历
         *
         * @param root
         * @return
         */
        boolean isValidBST(TreeNode root) {
            if (root == null) return false;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode n = root;
            int val = Integer.MIN_VALUE;
            while (!stack.isEmpty() || n != null) {
                while (n != null) {
                    stack.push(n);
                    n = n.left;
                }
                if (!stack.isEmpty()) {
                    n = stack.pop();
                    if (n.val < val) return false;
                    val = n.val;
                    n = n.right;
                }
            }
            return true;
        }


        /**
         * 递归，看不太懂了
         *
         * @param root
         * @return
         */
        boolean isValidBST2(TreeNode root) {
            if (root == null) return true;
            return isValidBST2(root, null, null);

        }

        boolean isValidBST2(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) return true;
            if (min != null && root.val <= min.val) return false;
            if (max != null && root.val >= max.val) return false;
            return isValidBST2(root.left, min, root) && isValidBST2(root.right, root, max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L98_ValidateBinarySearchTree().new Solution();

    }
}