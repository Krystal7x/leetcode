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