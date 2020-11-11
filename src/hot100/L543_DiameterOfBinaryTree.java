package hot100;

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 531 👎 0


import common.TreeNode;

//L543、二叉树的直径 ----
public class L543_DiameterOfBinaryTree {

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
        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            lengthTree(root);
            return max;
        }

        private int lengthTree(TreeNode root) {
            if (root == null) return 0;
            int left = lengthTree(root.left);
            int right = lengthTree(root.right);
            max = Math.max(max, left + right);
            return Math.max(left, right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L543_DiameterOfBinaryTree().new Solution();
        solution.diameterOfBinaryTree(TreeNode.getTestTree("4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2"));

    }
}