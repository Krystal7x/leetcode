package sword1;

import common.TreeNode;

/**
 * @auther k
 * @date 2019-06-29 15:45
 * <p>
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * 解题思路
 * 我们知道，前序遍历的第一个节点就是树的根节点，所以我们先根据前序遍历序列的第一个数字创建根结点，
 * 接下来在中序遍历序列中找到根结点的位置，根节点的左边就是左子树，右边就是右子树，这样就能确定左、右子树结点的数量。
 * 在前序遍历和中序遍历的序列中划分了左、右子树结点的值之后，就可以递归地去分别构建它的左右子树。
 */

public class S6BuildTree_L105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        TreeNode node = preBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return node;
    }

    /**
     * 先序与中序返回二叉树
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    public TreeNode preBuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        if (preStart == preEnd || inStart == inEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int n = preorder[preStart];
        int length = 0;
        for (int i = inStart; i < inorder.length; i++) {
            if (n == inorder[i]) {
                length = i;
            }
        }
        TreeNode node = new TreeNode(n);
        node.left = preBuildTree(preorder, preStart + 1, preStart + length - inStart, inorder, inStart, length - 1);
        node.right = preBuildTree(preorder, preStart + length - inStart + 1, preEnd, inorder, length + 1, inEnd);
        return node;
    }

}
