package toppick;

//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2: 
//
// 输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//] 
//
// 进阶: 
//
// 
// 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个常数空间的解决方案吗？ 
// 
// Related Topics 数组 
// 👍 330 👎 0


//L73、矩阵置零 ---- 
public class L73_SetMatrixZeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            int row = -1;
            int col = -1;

            //1
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }
            //2
            if (row == -1) return;
            //3、标记
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[row][j] = 0;
                        matrix[i][col] = 0;
                    }
                }
            }
            //行 记0
            for (int i = 0; i < matrix.length; i++) {
                if (i != row && matrix[i][col] == 0) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            //列 记0
            for (int j = 0; j < matrix[0].length; j++) {
                if (j != col && matrix[row][j] == 0) {
                    for (int i = 0; i < matrix.length; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            //row col 记0
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
            return;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L73_SetMatrixZeroes().new Solution();

    }
}