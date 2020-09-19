package leetcode.动态规划;

//编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。 
//
// 示例: 
//
// 输入: 25
//输出: 9
//解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次) 
//
// 提示： 
//
// 
// n <= 10^9 
// 
// Related Topics 数学 动态规划 
// 👍 24 👎 0


public class interview1706_NumberOf2sInRangeLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这种题不是一个规律可以全部总结的
         * 得分几种情况，分类总结规律
         *
         * @param n
         * @return
         */
        public int numberOf2sInRange(int n) {
            if (n == 0) {
                return 0;
            }
            //位数
            int digit = (int) Math.log10(n) + 1;
            // dp[i][0] = numberOf2sInRange(n % pow(10, i)) 保存0~n的1-i位组成的数包含2的个数
            // dp[i][1] = numberOf2sInRange(99..9) 保存i位均为9包含2的个数
            int[][] dp = new int[digit + 1][2];
            int s = n % 10;
            if (s > 1) {
                dp[1][0] = 1;
                dp[1][1] = 1;
            } else {
                dp[1][0] = 0;
                dp[1][1] = 1;
            }

            for (int i = 2; i <= digit; i++) {
                int k = n / (int) Math.pow(10, i - 1) % 10;
                dp[i][0] = k * dp[i - 1][1] + dp[i - 1][0];
                if (k > 2) {
                    dp[i][0] = dp[i][0] + (int) Math.pow(10, i - 1);
                }
                if (k == 2) {
                    dp[i][0] = dp[i][0] + (n % (int) Math.pow(10, i - 1)) + 1;
                }
                dp[i][1] = 10 * dp[i - 1][1] + (int) Math.pow(10, i - 1);
            }
            return dp[digit][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview1706_NumberOf2sInRangeLcci().new Solution();
        System.out.println(solution.numberOf2sInRange(25));

    }
}