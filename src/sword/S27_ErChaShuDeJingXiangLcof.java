package sword;

//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 
// 👍 75 👎 0


import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class S27_ErChaShuDeJingXiangLcof {
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
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) return null;

            TreeNode left = mirrorTree(root.left);
            TreeNode right = mirrorTree(root.right);
            root.left = right;
            root.right = left;

            return root;
        }


        /**
         * 非递归实现
         *
         * @param root
         */
        public void mirrorTreeWithQueue(TreeNode root) {
            if (root == null)
                return;
            //如果树为 null 直接返回。否则将根节点入队列。
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                //队列不为空时，节点出队，交换该节点的左右子树。
                TreeNode root1 = queue.poll();
                Swap(root);
                if (root1.right != null) {
                    queue.add(root1.right);
                    //如果左子树不为 null 入队
                }
                if (root1.left != null) {
                    queue.add(root1.left);
                    //如果右子树不为 null 入队。
                }
            }
        }

        public void Swap(TreeNode root) {
            TreeNode temp;
            temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S27_ErChaShuDeJingXiangLcof().new Solution();

    }
}