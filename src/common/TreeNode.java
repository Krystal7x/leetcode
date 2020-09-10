package common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther k
 * @date 2019-06-29 15:41
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int v) {
        val = v;
    }


    /**
     * 这个写法是参考L297那里的，不是很优雅
     *
     * @param data
     * @return
     */
    public static TreeNode getTestTree(String data) {
        if (data == null || data.length() == 0) return null;
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (n == null) {
                    continue;
                } else {
                    TreeNode left = getNode(vals, index);
                    index++;
                    TreeNode right = getNode(vals, index);
                    index++;
                    n.left = left;
                    n.right = right;
                    queue.add(left);
                    queue.add(right);
                }
            }
        }
        return root;
    }


    public static TreeNode getNode(String[] nums, int index) {
        if (index < nums.length) {
            if (nums[index].equals("null")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(nums[index]));
        }
        return null;

    }


    public static void main(String[] args) {
        TreeNode n = TreeNode.getTestTree("5,3,6,2,4,null,null,1");
        System.out.println(n.val);
    }


}
