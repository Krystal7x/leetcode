package leetcode.editor.cn;

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
            return null;

        }



        public int findRight(int[][] matrix, int x, int y) {
            int length = matrix[0].length;
            while (y < length) {
                if (matrix[x][y] == 0) {
                    y++;
                } else {
                    break;
                }
            }
            return y;
        }

        public int findDown(int[][] matrix, int x, int y) {
            int length = matrix.length;
            while (x < length) {
                if (matrix[x][y] == 0) {
                    x++;
                } else {
                    break;
                }
            }
            return x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview1723_MaxBlackSquareLcci().new Solution();

    }
}