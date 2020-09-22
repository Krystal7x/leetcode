package leetcode.数据结构.数组;

//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 494 👎 0


import java.util.LinkedList;
import java.util.List;

public class L54_SpiralMatrix {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new LinkedList<>();
            if (matrix.length == 0) return res;

            //左右边界
            int l = 0, r = matrix[0].length - 1;
            //上下边界
            int t = 0, b = matrix.length - 1;
            //结果

            while (true) {
                //1、 left to right.
                for (int i = l; i <= r; i++) {
                    res.add(matrix[t][i]);
                }
                //上边界+1
                if (++t > b) break;

                //2、 top to bottom.
                for (int i = t; i <= b; i++) {
                    res.add(matrix[i][r]);
                }
                //右边界-1
                if (l > --r) break;

                //3、right to left.
                for (int i = r; i >= l; i--) {
                    res.add(matrix[b][i]);
                }
                // 下边界-1
                if (t > --b) break;

                //4、 bottom to top.
                for (int i = b; i >= t; i--) {
                    res.add(matrix[i][l]);
                }
                //左边界 +1
                if (++l > r) break;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L54_SpiralMatrix().new Solution();

    }
}