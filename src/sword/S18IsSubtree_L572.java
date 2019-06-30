package sword;

import common.TreeNode;

/**
 * @auther k
 * @date 2019-06-30 14:09
 * <p>
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * <p>
 * 解题思路
 * 递归思想，如果根节点相同则递归调用IsSubtree()，如果根节点不相同，则判断root1的左子树和roo2是否相同，再判断右子树和root2是否相同;
 * 注意节点为空的条件，HasSubTree中，只要有树为空就返回false; IsSubtree中，要先判断root2，如果root2为空，则说明第二棵树遍历完了，即匹配成功。
 */

public class S18IsSubtree_L572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean ans = false;
        if (s != null && t != null) {
            if (s.value == t.value) {
                ans = isSubtree2(s, t);
            }
            if (!ans) {
                //关键点就在这里，需要两层递归。这是第一层
                ans = isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        }
        return ans;
    }

    boolean isSubtree2(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null) {
            return false;
        }
        if (p1.value != p2.value) {
            return false;
        }

        return isSubtree2(p1.left, p2.left) && isSubtree2(p1.right, p2.right);
    }
}
