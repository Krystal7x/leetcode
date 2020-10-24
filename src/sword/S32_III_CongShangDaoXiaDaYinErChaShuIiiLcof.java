package sword;

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
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
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 50 👎 0


import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class S32_III_CongShangDaoXiaDaYinErChaShuIiiLcof {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) return ans;
            Stack<TreeNode> left = new Stack<>();
            Stack<TreeNode> right = new Stack<>();
            left.add(root);
            while (!left.isEmpty() || !right.isEmpty()) {
                if (!left.isEmpty()) {
                    int size = left.size();
                    List<Integer> list = new LinkedList<>();
                    for (int i = 0; i < size; i++) {
                        TreeNode node = left.pop();
                        list.add(node.val);
                        if (node.left != null) right.add(node.left);
                        if (node.right != null) right.add(node.right);

                    }
                    ans.add(list);
                }

                if (!right.isEmpty()) {
                    int size = right.size();
                    List<Integer> list = new LinkedList<>();
                    for (int i = 0; i < size; i++) {
                        TreeNode node = right.pop();
                        list.add(node.val);
                        if (node.right != null) left.add(node.right);
                        if (node.left != null) left.add(node.left);
                    }
                    ans.add(list);
                }


            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S32_III_CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();

    }
}