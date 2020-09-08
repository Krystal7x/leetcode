package leetcode.数据结构.二叉树;
//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 361 👎 0

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class L111_MinimumDepthOfBinaryTree {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            int deep = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left != null) queue.add(poll.left);
                    if (poll.right != null) queue.add(poll.right);
                    if (poll.left == null && poll.right == null) return deep;
                }
                deep++;
            }
            return deep;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L111_MinimumDepthOfBinaryTree().new Solution();

    }
}