package leetcode.数据结构.数组;

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
// 👍 133 👎 0


public class Sword29_ShunShiZhenDaYinJuZhenLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[0];

            //左右边界
            int l = 0, r = matrix[0].length - 1;
            //上下边界
            int t = 0, b = matrix.length - 1;
            //结果
            int[] res = new int[(r + 1) * (b + 1)];
            int x = 0;
            while (true) {
                //1、 left to right.
                for (int i = l; i <= r; i++) {
                    res[x++] = matrix[t][i];
                }
                //上边界+1
                if (++t > b) break;

                //2、 toppick to bottom.
                for (int i = t; i <= b; i++) {
                    res[x++] = matrix[i][r];
                }
                //右边界-1
                if (l > --r) break;

                //3、right to left.
                for (int i = r; i >= l; i--) {
                    res[x++] = matrix[b][i];
                }
                // 下边界-1
                if (t > --b) break;

                //4、 bottom to toppick.
                for (int i = b; i >= t; i--) {
                    res[x++] = matrix[i][l];
                }
                //左边界 +1
                if (++l > r) break;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Sword29_ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

    }
}