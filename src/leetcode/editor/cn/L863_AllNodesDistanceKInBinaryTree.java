package leetcode.editor.cn;

//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 267 👎 0


import common.TreeNode;

import java.util.*;

//L863、二叉树中所有距离为 K 的结点 ----
public class L863_AllNodesDistanceKInBinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 往上、往下、直接广度遍历
         * 即可
         *
         * @param root
         * @param target
         * @param K
         * @return
         */
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            //结果
            List<Integer> retList = new ArrayList<>();
            //记录节点的父节点
            Map<TreeNode, TreeNode> parentsTreeMap = new HashMap<>();
            setParentTreeNode(root, null, parentsTreeMap);

            //当前节点
            Queue<TreeNode> checkQueue = new LinkedList<>();
            checkQueue.add(target);

            //已遍历的节点
            Set<TreeNode> hasCheck = new HashSet<>();
            hasCheck.add(target);

            while (!checkQueue.isEmpty() && K > 0) {
                K--;
                int size = checkQueue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = checkQueue.poll();
                    //把子节点放入
                    if (treeNode.left != null && hasCheck.add(treeNode.left))
                        checkQueue.add(treeNode.left);
                    if (treeNode.right != null && hasCheck.add(treeNode.right))
                        checkQueue.add(treeNode.right);
                    //把父节点放入
                    if (parentsTreeMap.containsKey(treeNode) && hasCheck.add(parentsTreeMap.get(treeNode)))
                        checkQueue.add(parentsTreeMap.get(treeNode));
                }
            }
            //得到结果
            while (!checkQueue.isEmpty()) {
                retList.add(checkQueue.poll().val);
            }
            return retList;
        }

        /**
         * 记录每一个节点的父节点
         *
         * @param root
         * @param parentTreeNodeMap
         * @param parent
         */
        private void setParentTreeNode(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentTreeNodeMap) {
            if (root == null) {
                return;
            }
            if (parent != null) {
                parentTreeNodeMap.put(root, parent);
            }
            setParentTreeNode(root.left, root, parentTreeNodeMap);
            setParentTreeNode(root.right, root, parentTreeNodeMap);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L863_AllNodesDistanceKInBinaryTree().new Solution();

    }
}