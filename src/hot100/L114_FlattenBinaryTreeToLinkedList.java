package hot100;

//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 607 👎 0


import common.TreeNode;

//L114、二叉树展开为链表   -----
public class L114_FlattenBinaryTreeToLinkedList {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) return;
            flattenNode(root);

        }


        public TreeNode flattenNode(TreeNode root) {
            if (root == null) return null;
            // 1、左右子树已经被拉平成一条链表
            TreeNode left = flattenNode(root.left);
            TreeNode right = flattenNode(root.right);
            root.left = null;
            root.right = left;
            TreeNode pre = root;
            while (left != null) {
                pre = left;
                left = left.right;
            }
            pre.right = right;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L114_FlattenBinaryTreeToLinkedList().new Solution();

    }
}