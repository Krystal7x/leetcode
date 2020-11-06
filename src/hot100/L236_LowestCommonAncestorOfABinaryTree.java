package hot100;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 816 👎 0


import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//L236、二叉树的最近公共祖先 ----
public class L236_LowestCommonAncestorOfABinaryTree {

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
        Solution solution = new L236_LowestCommonAncestorOfABinaryTree().new Solution();

    }
}