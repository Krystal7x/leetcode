package leetcode.动态规划;

//给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。 
//
// 
//
// 示例 1： 
//
// 输入：matrix =
//[
//  [0,1,1,1],
//  [1,1,1,1],
//  [0,1,1,1]
//]
//输出：15
//解释： 
//边长为 1 的正方形有 10 个。
//边长为 2 的正方形有 4 个。
//边长为 3 的正方形有 1 个。
//正方形的总数 = 10 + 4 + 1 = 15.
// 
//
// 示例 2： 
//
// 输入：matrix = 
//[
//  [1,0,1],
//  [1,1,0],
//  [1,1,0]
//]
//输出：7
//解释：
//边长为 1 的正方形有 6 个。 
//边长为 2 的正方形有 1 个。
//正方形的总数 = 6 + 1 = 7.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 300 
// 1 <= arr[0].length <= 300 
// 0 <= arr[i][j] <= 1 
// 
// Related Topics 数组 动态规划 
// 👍 102 👎 0


public class L1277_CountSquareSubmatricesWithAllOnes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSquares(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return 0;
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] dp = new int[row][col];
            int count = 0;
            for (int i = 0; i < row; i++) {
                dp[i][0] = matrix[i][0];
            }
            for (int i = 0; i < col; i++) {
                dp[0][i] = matrix[0][i];
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        continue;
                    }
                    if (matrix[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }

            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    count = count + dp[i][j];
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L1277_CountSquareSubmatricesWithAllOnes().new Solution();

    }
}