package leetcode.动态规划;

//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 70 👎 0


public class Sword47_LiWuDeZuiDaJieZhiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
            int length = grid.length;
            int width = grid[0].length;
            int[][] dp = new int[length][width];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < length; i++) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            }
            for (int i = 1; i < width; i++) {
                dp[0][i] = grid[0][i] + dp[0][i - 1];
            }
            for (int i = 1; i < length; i++) {
                for (int j = 1; j < width; j++) {
                    dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            return dp[length - 1][width - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Sword47_LiWuDeZuiDaJieZhiLcof().new Solution();

    }
}