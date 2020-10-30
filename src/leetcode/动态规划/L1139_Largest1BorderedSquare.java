package leetcode.动态规划;

//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 动态规划 
// 👍 51 👎 0


public class L1139_Largest1BorderedSquare {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int row = grid.length;
            int col = grid[0].length;
            int[][] up = new int[row][col];
            int[][] left = new int[row][col];
            //初始化
            up[0][0] = grid[0][0];
            left[0][0] = grid[0][0];

            //初始化往上和往左的dp
            for (int i = 1; i < row; i++) {
                if (grid[i][0] == 0) {
                    up[i][0] = 0;
                    left[i][0] = 0;
                } else {
                    //grid[i][0]=1
                    up[i][0] = up[i - 1][0] + grid[i][0];
                    left[i][0] = grid[i][0];
                }
            }
            for (int i = 1; i < col; i++) {
                if (grid[0][i] == 0) {
                    up[0][i] = 0;
                    left[0][i] = 0;
                } else {
                    //grid[0][i]=1
                    left[0][i] = left[0][i - 1] + grid[0][i];
                    up[0][i] = grid[0][i];
                }
            }
            //初始化往上和往左的dp
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (grid[i][j] == 0) {
                        up[i][j] = 0;
                        left[i][j] = 0;
                    } else {
                        up[i][j] = up[i - 1][j] + grid[i][j];
                        left[i][j] = left[i][j - 1] + grid[i][j];
                    }
                }
            }
            //
            int ans = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        int length = Math.min(up[i][j], left[i][j]);
                        while (length > ans) {
                            if (up[i][j - length + 1] >= length && left[i - length + 1][j] >= length) {
                                ans = length;
                                break;
                            }
                            length--;
                        }
                    }
                }
            }

            return ans * ans;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L1139_Largest1BorderedSquare().new Solution();
        System.out.println(solution.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));

    }
}