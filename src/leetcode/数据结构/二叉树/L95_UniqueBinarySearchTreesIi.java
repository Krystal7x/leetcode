package leetcode.数据结构.二叉树;
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 621 👎 0

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class L95_UniqueBinarySearchTreesIi {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> ans = new LinkedList<>();
            if (n == 0) {
                return ans;
            }
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> ans = new LinkedList<>();
            if (start > end) {
                ans.add(null);
                return ans;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = generateTrees(start, i - 1);
                List<TreeNode> right = generateTrees(i + 1, end);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode n = new TreeNode(i);
                        n.left = l;
                        n.right = r;
                        ans.add(n);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L95_UniqueBinarySearchTreesIi().new Solution();

    }
}