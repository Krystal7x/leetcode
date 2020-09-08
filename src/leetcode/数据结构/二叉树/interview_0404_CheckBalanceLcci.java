package leetcode.数据结构.二叉树;
//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。 示例 1: 给定二叉树 [3,9,20,nu
//ll,null,15,7]     3    / \   9  20     /  \    15   7 返回 true 。示例 2: 给定二叉树 [1,2,
//2,3,3,null,null,4,4]       1      / \     2   2    / \   3   3  / \ 4   4 返回 fal
//se 。 Related Topics 树 深度优先搜索
// 👍 30 👎 0


import common.TreeNode;

public class interview_0404_CheckBalanceLcci {
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
         * 这种方式每个节点会算多次，浪费
         *
         * @param root
         * @return
         */
        public boolean isBalanced2(TreeNode root) {
            if (root == null) return false;
            int left = deep2(root.left);
            int right = deep2(root.right);
            if (left - right > 1 || right - left > 1) {
                return false;
            }
            return isBalanced2(root.left) && isBalanced2(root.right);
        }

        public int deep2(TreeNode root) {
            if (root == null) return 0;
            return Math.max(deep2(root.left), deep2(root.right)) + 1;
        }


        /**
         * 这个好一点
         *
         * @param root
         * @return
         */
        //空为null
        boolean ans = true;

        public boolean isBalanced(TreeNode root) {
            //因为deep是一个后序遍历，其实在deep的时候就可以算是不是平衡了
            deep(root);
            return ans;
        }

        public int deep(TreeNode root) {
            if (root == null) return 0;
            int left = deep(root.left);
            int right = deep(root.right);
            if (Math.abs(left - right) > 1) ans = false;
            int deep = Math.max(left, right) + 1;
            return deep;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview_0404_CheckBalanceLcci().new Solution();

    }
}