package leetcode.动态规划;

//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 512 👎 0


public class L91_DecodeWays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            //如果第一位是0，则无法解码
            if (s == null || s.length() == 0 || s.charAt(0) == '0') {
                return 0;
            }
            //
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            for (int i = 2; i <= s.length(); i++) {
                // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
                if (Integer.parseInt(s.substring(i - 2, i)) >= 10 && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                    dp[i] += dp[i - 2];
                }
                // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
                if (s.charAt(i - 1) != '0') {
                    dp[i] += dp[i - 1];
                }
            }
            return dp[s.length()];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L91_DecodeWays().new Solution();

    }
}