package leetcode.数据结构.二叉树;


//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
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
// Related Topics 树 深度优先搜索 数组 
// 👍 659 👎 0

import common.TreeNode;

public class L105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
                return null;

            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd) return null;
            int val = preorder[preStart];
            int index = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == val) break;
                index++;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            root.left = buildTree(preorder, preStart + 1, preStart + index, inorder, inStart, inStart + index - 1);
            root.right = buildTree(preorder, preStart + index + 1, preEnd, inorder, inStart + index + 1, inEnd);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});

    }
}