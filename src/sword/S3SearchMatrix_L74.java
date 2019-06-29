package sword;

/**
 * @auther k
 * @date 2019-06-29 14:37
 *
 *题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * 解题思路
 *
 * 二维数组是有序的，从右上角来看，向左数字递减，向下数字递增。
 * 因此从右上角开始查找，
 *
 * 当要查找数字比右上角数字大时，下移；
 * 当要查找数字比右上角数字小时，左移；
 * 如果出了边界，则说明二维数组中不存在该整数。
 */

public class S3SearchMatrix_L74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                x--;
                continue;
            }
            if (matrix[x][y] < target) {
                y++;
                continue;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        S3SearchMatrix_L74 a = new S3SearchMatrix_L74();
        int[][] m = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(a.searchMatrix(m, 3));
    }

}
