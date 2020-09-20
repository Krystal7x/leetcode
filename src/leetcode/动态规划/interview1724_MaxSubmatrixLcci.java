package leetcode.动态规划;

//给定一个正整数和负整数组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。 
//
// 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满
//足条件的子矩阵，返回任意一个均可。 
//
// 注意：本题相对书上原题稍作改动 
//
// 示例: 
//
// 输入:
//[
//   [-1,0],
//   [0,-1]
//]
//输出: [0,1,0,1]
//解释: 输入中标粗的元素即为输出所表示的矩阵 
//
// 说明： 
//
// 
// 1 <= matrix.length, matrix[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 27 👎 0


public class interview1724_MaxSubmatrixLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getMaxMatrix(int[][] matrix) {
            int[] ans = new int[4];
            int N = matrix.length;
            int M = matrix[0].length;
            int[] dp = new int[M];
            int max = Integer.MIN_VALUE;
            int sum;
            int r1 = 0;
            int c1 = 0;
            for (int i = 0; i < N; i++) {
                //清空dp
                cleanDP(dp, M);
                for (int j = i; j < N; j++) {
                    //加上一行后。从头开始算sum
                    sum = 0;
                    for (int k = 0; k < M; k++) {
                        dp[k] = dp[k] + matrix[j][k];
                        if (sum > 0) {
                            //累计前面的值
                            sum = sum + dp[k];

                        } else {
                            //从头开始
                            sum = dp[k];
                            r1 = i;
                            c1 = k;
                        }
                        if (sum > max) {
                            max = sum;
                            ans[0] = r1;
                            ans[1] = c1;
                            ans[2] = j;
                            ans[3] = k;
                        }


                    }

                }


            }
            return ans;

        }

        public void cleanDP(int[] dp, int M) {
            for (int i = 0; i < M; i++) {
                dp[i] = 0;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview1724_MaxSubmatrixLcci().new Solution();

    }
}