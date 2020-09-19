package leetcode.数据结构.二叉树;

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
// 👍 542 👎 0


import common.TreeNode;

import java.util.Stack;

public class L114_FlattenBinaryTreeToLinkedList {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        // 定义：将以 root 为根的树拉平为链表
        void flatten(TreeNode root) {
            // base case
            if (root == null) return;

            flatten(root.left);
            flatten(root.right);

            /**** 后序遍历位置 ****/
            // 1、左右子树已经被拉平成一条链表
            TreeNode left = root.left;
            TreeNode right = root.right;

            // 2、将左子树作为右子树
            root.left = null;
            root.right = left;

            // 3、将原先的右子树接到当前右子树的末端
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L114_FlattenBinaryTreeToLinkedList().new Solution();

    }
}