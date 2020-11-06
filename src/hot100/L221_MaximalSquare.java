package hot100;

//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划 
// 👍 606 👎 0


//L221、最大正方形 ---- 
public class L221_MaximalSquare {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return 0;
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m + 1][n + 1];
            int ans = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            return ans * ans;
        }


        public int maximalSquare2(char[][] matrix) {
            if (matrix == null || matrix.length == 0) return 0;
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] dp = new int[row][col];
            int max = 0;
            for (int i = 0; i < row; i++) {
                dp[i][0] = matrix[i][0] - 48;
                max = Math.max(max, dp[i][0]);
            }
            for (int i = 0; i < col; i++) {
                dp[0][i] = matrix[0][i] - 48;
                max = Math.max(max, dp[0][i]);
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] - 48 == 0) {
                        dp[i][j] = 0;
                    }
                    if (matrix[i][j] - 48 == 1) {
                        if (dp[i - 1][j - 1] > 0 && dp[i - 1][j] > 0 && dp[i][j - 1] > 0) {
                            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        } else {
                            dp[i][j] = 1;
                        }
                    }
                    max = Math.max(max, dp[i][j]);
                }

            }
            return max * max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L221_MaximalSquare().new Solution();

    }
}