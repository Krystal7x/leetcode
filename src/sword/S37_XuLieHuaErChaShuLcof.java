package sword;

//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 82 👎 0


import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class S37_XuLieHuaErChaShuLcof {
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder str = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode n = queue.poll();
                    if (n == null) {
                        str.append("null" + " ");
                        continue;
                    } else {
                        str.append(n.val + " ");
                    }
                    queue.add(n.left);
                    queue.add(n.right);
                }

            }
            return str.toString().trim();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] vals = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode n = queue.poll();
                    //这个是易错点！！！！！！
                    if (n == null) {
                        continue;
                    } else {
                        TreeNode left = getNode(vals[index++]);
                        TreeNode right = getNode(vals[index++]);
                        n.left = left;
                        n.right = right;
                        queue.add(left);
                        queue.add(right);
                    }
                }
            }
            return root;
        }


        public TreeNode getNode(String str) {
            if (str.equals("null")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(str));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {


    }
}