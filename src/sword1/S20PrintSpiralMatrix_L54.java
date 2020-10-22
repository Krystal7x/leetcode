package sword1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther k
 * @date 2019-07-06 15:50
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 解题思路
 * 先得到矩阵的行和列数，然后依次旋转打印数据，一次旋转打印结束后，往对角分别前进和后退一个单位。
 * 要注意单行和单列的情况。
 */

public class S20PrintSpiralMatrix_L54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<Integer>();

        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            //上：从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            //右：从上到下
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            //下：从右到左
            if (top != bottom) {
                //防止单行情况
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            //左：从下到上
            if (left != right) {
                //防止单列情况
                for (int i = bottom - 1; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;

    }
}
