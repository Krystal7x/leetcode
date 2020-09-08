package leetcode.数据结构.二叉树;
//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 310 👎 0

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L113_PathSumIi {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            pathSum(root, sum, stack, ans);
            return ans;
        }

        public void pathSum(TreeNode root, int sum, Stack<Integer> stack, List<List<Integer>> ans) {
            if (root == null) return;
            stack.push(root.val);
            pathSum(root.left, sum - root.val, stack, ans);

            if (root.left == null && root.right == null && root.val == sum) {
                List<Integer> list = new LinkedList<>(stack);
                ans.add(list);
            }
            pathSum(root.right, sum - root.val, stack, ans);

            stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L113_PathSumIi().new Solution();

    }
}