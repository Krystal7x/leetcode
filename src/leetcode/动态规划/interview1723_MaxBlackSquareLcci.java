package leetcode.动态规划;

//给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。 
//
// 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 
//最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//   [1,0,1],
//   [0,0,1],
//   [0,0,1]
//]
//输出: [1,0,2]
//解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
// 
//
// 示例 2: 
//
// 输入:
//[
//   [0,1,1],
//   [1,0,1],
//   [1,1,0]
//]
//输出: [0,0,1]
// 
//
// 提示： 
//
// 
// matrix.length == matrix[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 12 👎 0


public class interview1723_MaxBlackSquareLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findSquare(int[][] matrix) {
            if (matrix == null || matrix.length == 0)  return new int[0];
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] up = new int[row][col];
            int[][] left = new int[row][col];

            //1、初始化两个dp
            up[0][0] = matrix[0][0] == 0 ? 1 : 0;
            left[0][0] = matrix[0][0] == 0 ? 1 : 0;
            //i0 连续的0个数
            for (int i = 1; i < row; i++) {
                up[i][0] = matrix[i][0] == 0 ? up[i - 1][0] + 1 : 0;
                left[i][0] = matrix[i][0] == 0 ? 1 : 0;
            }
            //0i 连续的0个数
            for (int i = 1; i < col; i++) {
                left[0][i] = matrix[0][i] == 0 ? left[0][i - 1] + 1 : 0;
                up[0][i] = matrix[0][i] == 0 ? 1 : 0;
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    up[i][j] = matrix[i][j] == 0 ? up[i - 1][j] + 1 : 0;
                    left[i][j] = matrix[i][j] == 0 ? left[i][j - 1] + 1 : 0;
                }

            }

            //2、开始计算
            int length = 0;
            int[] ans = new int[3];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    //是0才能有机会
                    if (matrix[i][j] == 0) {
                        int tmp = Math.min(up[i][j], left[i][j]);
                        while (tmp > length) {
                            if (up[i][j - tmp + 1] >= tmp && left[i - tmp + 1][j] >= tmp) {
                                ans[0] = i - tmp + 1;
                                ans[1] = j - tmp + 1;
                                ans[2] = tmp;
                                length = tmp;
                                break;
                            }
                            tmp--;
                        }
                    }

                }
            }
            if (length == 0) return new int[0];
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview1723_MaxBlackSquareLcci().new Solution();

    }
}