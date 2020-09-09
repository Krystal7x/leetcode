package leetcode.数据结构.二叉树;

//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 696 👎 0

import common.TreeNode;

public class L124_BinaryTreeMaximumPathSum {
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxPathSum2(root);
            return ans;
        }

        public int maxPathSum2(TreeNode root) {
            if (root == null) return 0;
            int left = Math.max(maxPathSum2(root.left), 0);
            int right = Math.max(maxPathSum2(root.right), 0);

            ans = Math.max(ans, left + right + root.val);

            return left > right ? left + root.val : right + root.val;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L124_BinaryTreeMaximumPathSum().new Solution();

    }
}