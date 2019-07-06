package sword;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @auther k
 * @date 2019-07-06 16:58
 * <p>
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * <p>
 * 解题思路
 * 就是二叉树的层序遍历。借助一个队列就可以实现。
 * 使用两个队列一个存放节点，一个存放值。先将根节点加入到队列中，然后遍历队列中的元素，遍历过程中，访问该元素的左右节点，再将左右子节点加入到队列中来。
 * 注意Queue创建的方式：Queue<TreeNode> queue = new LinkedList<TreeNode>();
 * 用add将元素添加到队列中，用remove来移除并返回队首元素。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */

public class S23LevelOrder_L102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        while (true) {
            if (!queue1.isEmpty()) {
                ArrayList<Integer> l1 = new ArrayList<Integer>();
                while (!queue1.isEmpty()) {
                    TreeNode n = queue1.remove();
                    l1.add(n.val);
                    if (null != n.left) {
                        queue2.add(n.left);
                    }
                    if (null != n.right) {
                        queue2.add(n.right);
                    }
                }
                res.add(l1);
            }
            if (!queue2.isEmpty()) {
                ArrayList<Integer> l2 = new ArrayList<Integer>();
                while (!queue2.isEmpty()) {
                    TreeNode n = queue2.remove();
                    l2.add(n.val);
                    if (null != n.left) {
                        queue1.add(n.left);
                    }
                    if (null != n.right) {
                        queue1.add(n.right);
                    }
                }
                res.add(l2);
            }

            if (queue1.isEmpty() && queue2.isEmpty()) {
                break;
            }
        }

        return res;

    }


}
