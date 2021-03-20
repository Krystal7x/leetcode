package sword;

//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a
//-binary-search-tree/ 
// Related Topics 树 
// 👍 66 👎 0


import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class S68_I_ErChaSouSuoShuDeZuiJinGongGongZuXianLcof {
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


        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val > root.val && q.val > root.val) {//如果都大于，则最近的一定在root的右子树里，继续找
                return lowestCommonAncestor1(root.right, p, q);
            } else if (p.val < root.val && q.val < root.val) { //如果都小于，则最近的一定在root的左子树里，继续找
                return lowestCommonAncestor1(root.left, p, q);
            }
            return root;//如果一左一右就直接返回root
        }


        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Stack<TreeNode> pStack = new Stack<>();
            List<TreeNode> pList = new LinkedList<>();
            findTreeList(root, p, pStack, pList);
            int pSize = pList.size();
            Stack<TreeNode> qStack = new Stack<>();
            List<TreeNode> qList = new LinkedList<>();
            findTreeList(root, q, qStack, qList);
            int qSize = qList.size();

            int size = Math.min(pSize, qSize);
            TreeNode ans = null;
            for (int i = 0; i < size; i++) {
                if (pList.get(i).val == qList.get(i).val) {
                    ans = pList.get(i);
                }

            }
            return ans;
        }

        public void findTreeList(TreeNode root, TreeNode n, Stack<TreeNode> stack, List<TreeNode> list) {
            if (root == null) return;
            if (root.val == n.val) {
                list.addAll(stack);
                list.add(root);
                return;
            }
            stack.push(root);
            findTreeList(root.left, n, stack, list);
            findTreeList(root.right, n, stack, list);
            stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S68_I_ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();

    }
}