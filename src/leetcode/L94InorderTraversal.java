package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @auther k
 * @date 2019-07-06 17:36
 * <p>
 * 中序遍历
 */

public class L94InorderTraversal {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    public void inorderTraversal(TreeNode root, List res) {
        if (null == root) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);

    }


    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }
        return res;
    }


}
