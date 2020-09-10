package leetcode.数据结构.二叉树;

//从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。 
//
// 
//
// 示例： 
//给定如下二叉树 
//
//         2
//       / \
//      1   3
// 
//
// 返回： 
//
// [
//   [2,1,3],
//   [2,3,1]
//]
// 
// Related Topics 树 动态规划 
// 👍 36 👎 0

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class interview_0409_BstSequencesLcci {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 全排列问题，参考回溯法公式
     */
    class Solution {

        public List<List<Integer>> BSTSequences(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            Queue<TreeNode> q = new LinkedList<>();
            List<Integer> list = new LinkedList<>();
            if (root == null) {
                ans.add(list);
                return ans;
            }
            q.add(root);
            BSTSequences(q, list, ans);
            return ans;

        }

        /**
         * @param q    可选列表
         * @param list 已选列表
         * @param ans
         */
        private void BSTSequences(Queue<TreeNode> q, List<Integer> list, List<List<Integer>> ans) {
            if (q.isEmpty()) {
                ans.add(new LinkedList<>(list));
            }
            for (TreeNode n : q) {
                Queue<TreeNode> newQueue = getQueue(q, n);
                list.add(n.val);
                if (n.left != null) newQueue.add(n.left);
                if (n.right != null) newQueue.add(n.right);
                BSTSequences(newQueue, list, ans);
                list.remove(list.size() - 1);
            }
        }

        public Queue<TreeNode> getQueue(Queue<TreeNode> queue, TreeNode n) {
            Queue<TreeNode> q = new LinkedList<>();
            for (TreeNode t : queue) {
                if (t.val != n.val) {
                    q.add(t);
                }
            }
            return q;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview_0409_BstSequencesLcci().new Solution();

    }
}