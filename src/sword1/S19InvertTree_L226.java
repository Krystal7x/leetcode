package sword1;

import common.TreeNode;

/**
 * @auther k
 * @date 2019-07-06 15:22
 * <p>
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * <p>
 * 输入描述:
 * 二叉树的镜像定义：
 * <p>
 * 源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 * 解题思路
 * 通过对以上两棵树的观察，我们可以总结出这两棵树的根节点相同，但它们的左、右两个子节点交换了位置。所以我们可以得出求一棵树的镜像的过程：
 * 先前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点。当交换完所有非叶节点的左、右子节点之后，就得到了树的镜像。
 */

public class S19InvertTree_L226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.right != null) {
            invertTree(root.right);
        }
        if (root.left != null) {
            invertTree(root.left);
        }

        return root;
    }
}
