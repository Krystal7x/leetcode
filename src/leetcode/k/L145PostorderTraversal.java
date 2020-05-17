package leetcode.k;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther k
 * @date 2019-07-06 17:28
 *
 * 后续遍历
 */

public class L145PostorderTraversal {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    public void postorderTraversal(TreeNode root, List res) {
        if (null == root) {
            return;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);

    }
}
