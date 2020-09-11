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

    /**
     * 这个要再看一下,提交不对，题目也没说清
     */
    class Solution {

        //展开，其实就是遍历
        public void flatten(TreeNode root) {
            if (root == null) return;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode pre = new TreeNode();
            while (!stack.isEmpty()) {
                //1、先序遍历，处理节点
                TreeNode pop = stack.pop();
                pop.left = null;
                pre.right = pop;
                //记录遍历时的上一节点
                pre = pop;

                //2、先加右再加左，这样就是左边先弹出
                if (pop.right != null) stack.push(pop.right);
                if (pop.left != null) stack.push(pop.left);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L114_FlattenBinaryTreeToLinkedList().new Solution();

    }
}