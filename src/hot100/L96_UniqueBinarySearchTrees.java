package hot100;
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 789 👎 0

//L96、不同的二叉搜索树 ----
public class L96_UniqueBinarySearchTrees {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n; i++) {
                for (int j = 1; j <= i; j++) {
                    //j-1个节点的可能次数 * i-j个节点的可能次数
                    dp[i] = dp[j - 1] * dp[i - j] + dp[i];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L96_UniqueBinarySearchTrees().new Solution();

    }
}