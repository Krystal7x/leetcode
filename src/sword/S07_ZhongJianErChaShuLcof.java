package sword;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 232 👎 0


import common.TreeNode;

public class S07_ZhongJianErChaShuLcof {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            if (preStart == preEnd || inStart == inEnd) {
                return new TreeNode(preorder[preStart]);
            }
            int rootVal = preorder[preStart];
            int gap = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) break;
                gap++;
            }
            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree(preorder, preStart + 1, preStart + gap, inorder, inStart, inStart + gap - 1);
            root.right = buildTree(preorder, preStart + gap + 1, preEnd, inorder, inStart + gap + 1, inEnd);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S07_ZhongJianErChaShuLcof().new Solution();

    }
}