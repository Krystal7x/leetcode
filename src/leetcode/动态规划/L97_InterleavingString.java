package leetcode.动态规划;

//给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false 
// Related Topics 字符串 动态规划 
// 👍 345 👎 0


public class L97_InterleavingString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {

            if (s1.length() + s2.length() != s3.length()) return false;

            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            dp[0][0] = true;
            for (int i = 1; i <= s1.length(); i++) {
                if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0])
                    dp[i][0] = true;

            }
            for (int i = 1; i <= s2.length(); i++) {
                if (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1])
                    dp[0][i] = true;

            }
            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    if ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
                            || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])) {
                        dp[i][j] = true;
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L97_InterleavingString().new Solution();

    }
}