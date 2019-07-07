package sword;

import common.TreeNode;

import java.util.Stack;

/**
 * @auther k
 * @date 2019-07-07 14:38
 * <p>
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * <p>
 * 解题思路
 * 题目可能比较难理解，可以看如下的图，我们有一棵二叉搜索树，要求得右边的双向链表。
 * <p>
 * <p>
 * 在二叉搜索树中，左子结点的值总是小于父结点的值，右子节点的值总是大于父结点的值。因此我们在转换成排序双向链表时，原先指向左子结点的指针调整为链表中指向前一个结点的指针，原先指向右子节点的指针调整为链表中指向后一个结点的指针。
 * 因为中序遍历是按照从小到大的顺序遍历二叉搜索树，所以我们用中序遍历树中的每一个节点得到的正好是要求的排好序的。遍历过程如下：
 * 每次遍历节点的左孩子、右孩子，把左孩子指向转换链表的尾节点，并把末尾指针的右孩子指向自己。右孩子指向节点的右孩子。如果没有右孩子就返回。这一过程可以用递归实现。
 */

public class S27ConvertBstToList {
    /**
     * 递归解法
     */

    TreeNode head = null;
    TreeNode end = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return head;
    }

    public void ConvertSub(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        //中序遍历
        Convert(pRootOfTree.left);
        if (end == null) {
            head = pRootOfTree;
            end = pRootOfTree;
        } else {
            end.right = pRootOfTree;
            pRootOfTree.left = end;
            end = pRootOfTree;
        }
        Convert(pRootOfTree.right);
    }

    /**
     * 非递归的中序遍历，要记住
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert2(TreeNode pRootOfTree) {
        TreeNode head = null;
        TreeNode pre = null;
        //用的是栈
        Stack<TreeNode> stack = new Stack<>();
        while(pRootOfTree != null || !stack.isEmpty()) {
            //左边全部入栈
            while (pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            pRootOfTree = stack.pop();
            if (head == null) {
                head = pRootOfTree;
                pre = pRootOfTree;
            } else {
                pre.right = pRootOfTree;
                pRootOfTree.left = pre;
                pre = pRootOfTree;
            }
            //重点
            pRootOfTree = pRootOfTree.right;
        }
        return head;
    }
}
