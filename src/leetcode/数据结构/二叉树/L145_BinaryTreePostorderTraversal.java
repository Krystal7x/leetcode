package leetcode.数据结构.二叉树;

//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 463 👎 0


import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L145_BinaryTreePostorderTraversal {
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
        /**
         * 递归
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            if (null == root) {
                return Collections.emptyList();
            }
            List<Integer> res = new ArrayList<>();
            postorderTraversal(root, res);
            return res;
        }

        public void postorderTraversal(TreeNode root, List res) {
            if (null == root) {
                return;
            }
            postorderTraversal(root.left, res);
            postorderTraversal(root.right, res);
            res.add(root.val);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L145_BinaryTreePostorderTraversal().new Solution();

    }
}