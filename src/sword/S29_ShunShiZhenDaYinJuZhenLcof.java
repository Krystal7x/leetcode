package sword;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 146 👎 0


public class S29_ShunShiZhenDaYinJuZhenLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
            int[] ans = new int[matrix.length * matrix[0].length];
            int index = 0;
            int top = 0;
            int bottom = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;
            while (true) {
                //上
                for (int i = left; i <= right; i++) {
                    ans[index++] = matrix[top][i];
                }
                top++;
                if (top > bottom) break;

                //右
                for (int i = top; i <= bottom; i++) {
                    ans[index++] = matrix[i][right];
                }
                right--;
                if (right < left) break;

                //下
                for (int i = right; i >= left; i--) {
                    ans[index++] = matrix[bottom][i];
                }
                bottom--;
                if (bottom < top) break;

                //左
                for (int i = bottom; i >= top; i--) {
                    ans[index++] = matrix[i][left];
                }
                left++;
                if (left > right) break;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S29_ShunShiZhenDaYinJuZhenLcof().new Solution();

    }
}