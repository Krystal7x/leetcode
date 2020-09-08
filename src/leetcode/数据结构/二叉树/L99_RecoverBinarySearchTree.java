package leetcode.数据结构.二叉树;
//二叉搜索树中的两个节点被错误地交换。
//
// 请在不改变其结构的情况下，恢复这棵树。 
//
// 示例 1: 
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// 示例 2: 
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3 
//
// 进阶:
//
// 
// 使用 O(n) 空间复杂度的解法很容易实现。 
// 你能想出一个只使用常数空间的解决方案吗？ 
// 
// Related Topics 树 深度优先搜索 
// 👍 331 👎 0

import common.TreeNode;

import java.util.Stack;

public class L99_RecoverBinarySearchTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 中序遍历一定是递增的，若不是，则说明倒序了
         *
         * @param root
         */
        public void recoverTree(TreeNode root) {
            TreeNode n = root;
            TreeNode x1 = null;
            TreeNode x2 = null;
            TreeNode pre = new TreeNode(Integer.MIN_VALUE);
            Stack<TreeNode> stack = new Stack<>();
            while (n != null || !stack.isEmpty()) {
                while (n != null) {
                    stack.push(n);
                    n = n.left;
                }
                if (!stack.isEmpty()) {
                    n = stack.pop();
                    //说明倒序了
                    if (pre.val > n.val) {
                        x2 = n;
                        if (x1 == null) x1 = pre;
                    }
                    pre = n;
                    n = n.right;
                }
            }
            if (x1 != null && x2 != null) {
                //交换x1，x2
                int tmp = x1.val;
                x1.val = x2.val;
                x2.val = tmp;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L99_RecoverBinarySearchTree().new Solution();

    }
}