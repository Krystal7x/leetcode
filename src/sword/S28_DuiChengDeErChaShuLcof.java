package sword;

//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 
// 👍 94 👎 0


import common.TreeNode;

import java.util.Stack;

public class S28_DuiChengDeErChaShuLcof {
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isSymmetric(root.left, root.right);
        }

        public boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left != null && right == null) return false;
            if (left == null && right != null) return false;
            if (left.val != right.val) return false;
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }


        /**
         * 非递归实现
         *
         * @param root
         * @return
         */
        public boolean isSymmetric2(TreeNode root) {
            if (root == null) return true;
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            TreeNode l = root.left;
            TreeNode r = root.right;
            while (l != null || r != null || s1.size() > 0 || s2.size() > 0) {
                while (l != null && r != null) {//当l r 同时存在
                    s1.push(l);
                    l = l.left;
                    s2.push(r);
                    r = r.right;
                }
                if (l != null || r != null) return false;
                //此时l 和 r 都为空
                l = s1.pop();
                r = s2.pop();
                if (l.val != r.val) return false;

                //关键
                l = l.right;
                r = r.left;
            }

            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S28_DuiChengDeErChaShuLcof().new Solution();

    }
}