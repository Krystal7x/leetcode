package leetcode.数据结构.二叉树;//设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
//     3
//   / \
//  5   1
// / \ / \
//6  2 0  8
//  / \
// 7   4
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。 
//
// 说明: 
//
// 所有节点的值都是唯一的。
//p、q 为不同节点且均存在于给定的二叉树中。 
// Related Topics 树 
// 👍 18 👎 0

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class interview_0408_FirstCommonAncestorLcci {
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ans = null;
            List<TreeNode> pPath = getPath(root, p);
            List<TreeNode> qPath = getPath(root, q);
            int pSize = pPath.size();
            int qSize = qPath.size();
            int length = Math.min(pSize, qSize);
            for (int i = 0; i < length; i++) {
                if (pPath.get(i).val == qPath.get(i).val) {
                    ans = pPath.get(i);
                } else {
                    break;
                }
            }
            return ans;

        }


        List<TreeNode> getPath(TreeNode root, TreeNode n) {
            Stack<TreeNode> stack = new Stack<>();
            getPath2(root, n, stack);
            return new LinkedList<>(stack);
        }


        public boolean getPath2(TreeNode root, TreeNode n, Stack<TreeNode> stack) {
            if (root == null) return false;
            stack.push(root);
            if (n.val == root.val) return true;
            boolean a = getPath2(root.left, n, stack);
            boolean b = getPath2(root.right, n, stack);
            if (a || b) return true;
            stack.pop();
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview_0408_FirstCommonAncestorLcci().new Solution();
    }
}