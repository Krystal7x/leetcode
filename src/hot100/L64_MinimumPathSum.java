package hot100;

//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 665 👎 0

public class L64_MinimumPathSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            for (int i = 1; i < grid.length; i++) {
                grid[i][0] = grid[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < grid[0].length; i++) {
                grid[0][i] = grid[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L64_MinimumPathSum().new Solution();

    }
}