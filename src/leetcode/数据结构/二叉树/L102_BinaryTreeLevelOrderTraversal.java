package leetcode.数据结构.二叉树;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 624 👎 0

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102_BinaryTreeLevelOrderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> list = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode n = q.poll();
                    list.add(n.val);
                    if (n.left != null) q.add(n.left);
                    if (n.right != null) q.add(n.right);
                }
                ans.add(list);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L102_BinaryTreeLevelOrderTraversal().new Solution();

    }
}