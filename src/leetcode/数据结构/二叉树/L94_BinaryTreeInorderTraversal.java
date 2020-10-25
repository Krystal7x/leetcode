package leetcode.数据结构.二叉树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


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


        /**
         * 先序遍历（递归）
         *
         * @param root
         * @param list
         */
        public void preorderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) return;
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }


        /**
         * 先序遍历（非递归）
         *
         * @param root
         * @param list
         */
        public void preorderTraversal2(TreeNode root, List<Integer> list) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                //先处理右节点，可是使栈弹出的时候，先处理左节点
                if (pop.right != null) stack.push(pop.right);
                if (pop.left != null) stack.push(pop.left);

            }

        }

        /**
         * 中序遍历（递归）
         *
         * @param root
         * @param list
         */
        public void inorderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }

        /**
         * 中序遍历（非递归）
         *
         * @param root
         * @param list
         */
        public void inorderTraversal2(TreeNode root, List<Integer> list) {
            if (root == null) return;
            Stack<TreeNode> s = new Stack<>();
            while (!s.isEmpty() || root != null) {
                //先把左边全部压进栈
                while (root != null) {
                    s.add(root);
                    root = root.left;
                }
                //弹出栈
                if (!s.isEmpty()) {
                    root = s.pop();
                    list.add(root.val);
                    //右节点不为空，则在下一次循环中压一个进栈，然后又开始循环他的左节点
                    root = root.right;
                }
            }
        }

        /**
         * 后续遍历（递归）
         *
         * @param root
         * @param list
         */
        public void postorderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) return;
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }

        /**
         * 后续遍历（非递归）
         *
         * @param root
         */
        public void postorderTraversal2(TreeNode root, List<Integer> list) {
            if (root == null) return;
            //双栈法
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                //加入s2时要按照 中右左 的顺序
                stack2.push(pop);
                if (pop.left != null) stack1.push(pop.left);
                if (pop.right != null) stack1.push(pop.right);
            }
            while (!stack2.isEmpty()) {
                TreeNode pop = stack2.pop();
                list.add(pop.val);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L94_BinaryTreeInorderTraversal().new Solution();

    }
}
