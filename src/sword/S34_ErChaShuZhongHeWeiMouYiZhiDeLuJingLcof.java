package sword;

//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
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
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 100 👎 0


import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class S34_ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) return ans;
            Stack<Integer> stack = new Stack<>();
            pathSum(root, sum, stack, ans);

            return ans;
        }

        private void pathSum(TreeNode root, int target, Stack<Integer> stack, List<List<Integer>> ans) {
            if (root.left == null && root.right == null && root.val == target) {
                stack.push(root.val);
                ans.add(new LinkedList<>(stack));
                stack.pop();
                return;
            }
            if (root.left != null) {
                stack.push(root.val);
                pathSum(root.left, target - root.val, stack, ans);
                stack.pop();
            }
            if (root.right != null) {
                stack.push(root.val);
                pathSum(root.right, target - root.val, stack, ans);
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S34_ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();

    }
}