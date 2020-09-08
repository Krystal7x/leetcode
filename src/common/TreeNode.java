package common;

/**
 * @auther k
 * @date 2019-06-29 15:41
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int v) {
        val = v;
    }

    /**
     *     3
     *    / \
     *   5   1
     *  / \ / \
     * 6  2 0  8
     *   / \
     *  7   4
     *
     * @return
     */
    public static TreeNode getTestTree() {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n5.left = n8;
        n5.right = n9;
        return n1;


    }


}
