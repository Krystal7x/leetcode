package sword;

import common.TreeNode;

/**
 * @auther k
 * @date 2019-06-29 16:32
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 */

public class S6BuildTree_L106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length != inorder.length) {
            return null;
        }
        TreeNode node = endBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return node;
    }

    /**
     * 中序与后续返回二叉树
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param postorder
     * @param postStart
     * @param postEnd
     * @return
     */
    public TreeNode endBuildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        if (postStart == postEnd || inStart == inEnd) {
            return new TreeNode(postorder[postEnd]);
        }
        int n = postorder[postEnd];
        int length = 0;
        for (int i = inStart; i < inorder.length; i++) {
            if (n == inorder[i]) {
                length = i;
            }
        }
        TreeNode node = new TreeNode(n);
        node.left = endBuildTree(inorder,inStart,length-1,postorder,postStart,postStart+length-inStart-1);
        node.right = endBuildTree(inorder,length+1,inEnd,postorder,postStart+length-inStart,postEnd-1);
        return node;
    }

}
