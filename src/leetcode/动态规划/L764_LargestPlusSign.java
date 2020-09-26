package leetcode.动态规划;

//在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。网格中包含 1
// 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。 
//
// 一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格 grid[x][y] = 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 
//1 组成的臂。下面给出 k" 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。 
//
// 
//
// k 阶轴对称加号标志示例: 
//
// 
//阶 1:
//000
//010
//000
//
//阶 2:
//00000
//00100
//01110
//00100
//00000
//
//阶 3:
//0000000
//0001000
//0001000
//0111110
//0001000
//0001000
//0000000
// 
//
// 
//
// 示例 1： 
//
// 
//输入: N = 5, mines = [[4, 2]]
//输出: 2
//解释:
//
//11111
//11111
//11111
//11111
//11011
//
//在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: N = 2, mines = []
//输出: 1
//解释:
//
//11
//11
//
//没有 2 阶加号标志，有 1 阶加号标志。
// 
//
// 
//
// 示例 3： 
//
// 
//输入: N = 1, mines = [[0, 0]]
//输出: 0
//解释:
//
//0
//
//没有加号标志，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 整数N 的范围： [1, 500]. 
// mines 的最大长度为 5000. 
// mines[i] 是长度为2的由2个 [0, N-1] 中的数组成. 
// (另外,使用 C, C++, 或者 C# 编程将以稍小的时间限制进行判断.) 
// 
//
// 
// Related Topics 动态规划 
// 👍 55 👎 0


public class L764_LargestPlusSign {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orderOfLargestPlusSign(int N, int[][] mines) {
            //构造数组
            int[][] matrix = matrix(N, mines);

            int[][] up = new int[N][N];
            int[][] left = new int[N][N];

            //1、初始化两个dp
            up[0][0] = matrix[0][0];
            left[0][0] = matrix[0][0];
            //i0 连续的0个数
            for (int i = 1; i < N; i++) {
                up[i][0] = matrix[i][0] == 1 ? up[i - 1][0] + 1 : 0;
                left[i][0] = matrix[i][0] == 1 ? 1 : 0;
            }
            //0i 连续的0个数
            for (int i = 1; i < N; i++) {
                left[0][i] = matrix[0][i] == 1 ? left[0][i - 1] + 1 : 0;
                up[0][i] = matrix[0][i] == 1 ? 1 : 0;
            }
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    up[i][j] = matrix[i][j] == 1 ? up[i - 1][j] + 1 : 0;
                    left[i][j] = matrix[i][j] == 1 ? left[i][j - 1] + 1 : 0;
                }

            }

            //2、开始计算
            int length = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //是1才能有机会
                    if (matrix[i][j] == 1) {
                        int tmp = Math.min(up[i][j], left[i][j]);
                        while (tmp > length) {
                            if (j + tmp - 1 < N && i + tmp - 1 < N && left[i][j + tmp - 1] >= 2 * tmp - 1 && up[i + tmp - 1][j] >= 2 * tmp - 1) {
                                length = tmp;
                                break;
                            }
                            tmp--;
                        }
                    }

                }
            }
            return length;

        }


        private int[][] matrix(int n, int[][] mines) {
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 1;
                }
            }
            for (int i = 0; i < mines.length; i++) {
                matrix[mines[i][0]][mines[i][1]] = 0;

            }
            return matrix;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L764_LargestPlusSign().new Solution();
        System.out.println(solution.orderOfLargestPlusSign(3, new int[][]{{0, 0}}));

    }
}