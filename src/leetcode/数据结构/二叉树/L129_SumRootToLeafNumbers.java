package leetcode.数据结构.二叉树;

//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 190 👎 0

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L129_SumRootToLeafNumbers {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int ans = 0;

        public int sumNumbers(TreeNode root) {
            if (root == null) return 0;
            Stack<TreeNode> stack = new Stack<>();
            sumNumbers(root, stack);
            return ans;

        }

        public void sumNumbers(TreeNode root, Stack<TreeNode> stack) {
            if (root == null) return;

            if (root.left == null && root.right == null) {
                stack.push(root);
                sum(stack);
                stack.pop();
                return;
            }
            stack.push(root);
            sumNumbers(root.left, stack);
            sumNumbers(root.right, stack);
            stack.pop();
        }

        public void sum(Stack<TreeNode> stack) {
            LinkedList<TreeNode> list = new LinkedList<>(stack);
            int sum = 0;
            for (TreeNode n : list) {
                sum = sum * 10 + n.val;
            }
            ans += sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L129_SumRootToLeafNumbers().new Solution();

    }
}