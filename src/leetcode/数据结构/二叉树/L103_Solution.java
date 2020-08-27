package leetcode.数据结构.二叉树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 描述:
 * 之字输出二叉树
 *
 * @author luokui
 * @create 2020-08-26 20:49
 */
public class L103_Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.add(root);
        while (!left.isEmpty() || !right.isEmpty()) {
            List<Integer> tmpLeft = new LinkedList<>();
            while (!left.isEmpty()) {
                TreeNode n = left.pop();
                tmpLeft.add(n.val);
                if (n.left != null) right.push(n.left);
                if (n.right != null) right.push(n.right);

            }
            if (tmpLeft.size() > 0) {
                ans.add(tmpLeft);
            }
            List<Integer> tmpRight = new LinkedList<>();
            while (!right.isEmpty()) {
                TreeNode n = right.pop();
                tmpRight.add(n.val);
                if (n.right != null) left.push(n.right);
                if (n.left != null) left.push(n.left);
            }
            if (tmpRight.size() > 0) {
                ans.add(tmpRight);
            }

        }
        return ans;
    }

}
