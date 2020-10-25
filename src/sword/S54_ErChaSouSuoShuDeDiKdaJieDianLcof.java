package sword;

//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 74 👎 0


import common.TreeNode;

import java.util.Stack;

public class S54_ErChaSouSuoShuDeDiKdaJieDianLcof {
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
        public int kthLargest(TreeNode root, int k) {
            if (root == null) return 0;
            //正序第几
            int num = nodeNum(root) - k + 1;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode n = root;
            while (n != null || !stack.isEmpty()) {
                while (n != null) {
                    stack.push(n);
                    n = n.left;

                }
                if (!stack.isEmpty()) {
                    n = stack.pop();
                    num--;
                    if (0 == num) return n.val;
                    n = n.right;
                }
            }
            return 0;
        }

        public int nodeNum(TreeNode root) {
            if (root == null) return 0;
            return 1 + nodeNum(root.left) + nodeNum(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S54_ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();

    }
}