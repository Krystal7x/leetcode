package leetcode.数据结构.二叉树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;


//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 660 👎 0

/**
 * 描述:
 *
 * @author luokui
 * @create 2020-09-07 16:52
 */
public class L94_BinaryTreeInorderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            inorderTraversal(root, ans);
            return ans;
        }

        public void inorderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L94_BinaryTreeInorderTraversal().new Solution();

    }
}
