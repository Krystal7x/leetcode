package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther k
 * @date 2019-07-06 17:36
 *
 * 中序遍历
 */

public class L94InorderTraversal {
    /**
     * 递归
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
}
