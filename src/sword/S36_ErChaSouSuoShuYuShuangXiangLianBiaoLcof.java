package sword;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 分治算法 
// 👍 122 👎 0


import common.Node;
import common.TreeNode;

import java.util.Stack;

public class S36_ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {


        /**
         * 将二叉树转为链表，可以借助原始的 right 引用作为 next 引用，left 引用作为 pre 引用，来构造双向链表。
         * <p>
         * 核心思想：在中序遍历的时候修改每个节点的 right 和 left 指向
         * <p>
         * 那么第一次获取到最左边的叶子节点的时候就要把头指针设定好，同时第一个节点不需要管理right 和 left 的指向，
         * 所以在接下来的遍历中需要排除第一个节点的操作流程。
         * <p>
         * 然后从第二个节点开始操作流程就一致了，即把 pre 的 next 指向自己，把自己的 left 指向 pre，然后自己成为新的 pre
         *
         * @param root
         * @return
         */
        public TreeNode Convert(TreeNode root) {
            if (root == null)
                return null;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            TreeNode ans = null;
            TreeNode pre = null;// 用于保存中序遍历序列的上一节点
            boolean isFirst = true;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                if (isFirst) {
                    ans = p;// 将中序遍历序列中的第一个节点记为root
                    pre = p;
                    isFirst = false;
                } else {
                    pre.right = p;
                    p.left = pre;
                    pre = p;
                }
                p = p.right;
            }
            return ans;
        }


        /**
         * 完全没用上搜索二叉树这个条件
         *
         * @param root
         * @return
         */
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            Node head = root;
            while (head.left != null) {
                head = head.left;
            }
            Node tail = root;
            while (tail.right != null) {
                tail = tail.right;
            }
            Node left = orderLeft(root.left);
            Node right = orderRight(root.right);
            if (left != null) {
                root.left = left;
                left.right = root;
            }
            if (right != null) {
                root.right = right;
                right.left = root;
            }

            head.left = tail;
            tail.right = head;
            return head;

        }


        public Node orderLeft(Node root) {
            if (root == null) return null;
            Node left = orderLeft(root.left);
            if (left != null) {
                root.left = left;
                left.right = root;
            }
            Node right = orderRight(root.right);
            if (right == null) return root;
            root.right = right;
            right.left = root;
            //返回最后边的节点
            Node ans = right;
            while (ans.right != null) ans = ans.right;
            return ans;
        }


        public Node orderRight(Node root) {
            if (root == null) return null;
            Node left = orderLeft(root.left);
            if (left != null) {
                root.left = left;
                left.right = root;
            }
            //返回最前边的节点
            Node ans = root;
            while (ans.left != null) ans = ans.left;

            Node right = orderRight(root.right);
            if (right == null) return ans;
            root.right = right;
            right.left = root;

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S36_ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();

    }
}