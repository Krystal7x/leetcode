package leetcode.动态规划;

//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 示例: 
//
// 输入: 13
//输出: 6 
//解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。 
// Related Topics 数学 
// 👍 163 👎 0


public class L233_NumberOfDigitOne {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            if (n == 0) return 0;
            int digit = (int) Math.log10(n) + 1;
            int[][] dp = new int[digit + 1][2];
            dp[1][0] = n % 10 >= 1 ? 1 : 0;
            dp[1][1] = 1;
            for (int i = 2; i <= digit; i++) {
                int k = n / (int) (Math.pow(10, i - 1)) % 10;
                dp[i][0] = k * dp[i - 1][1] + dp[i - 1][0];
                if (k == 1) {
                    dp[i][0] += n % (int) (Math.pow(10, i - 1)) + 1;
                }
                if (k > 1) {
                    dp[i][0] += Math.pow(10, i - 1);
                }
                dp[i][1] = 10 * dp[i - 1][1] + (int) Math.pow(10, i - 1);

            }
            return dp[digit][0];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L233_NumberOfDigitOne().new Solution();

    }
}