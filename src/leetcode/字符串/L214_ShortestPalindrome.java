package leetcode.字符串;

//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 示例 1: 
//
// 输入: "aacecaaa"
//输出: "aaacecaaa"
// 
//
// 示例 2: 
//
// 输入: "abcd"
//输出: "dcbabcd" 
// Related Topics 字符串 
// 👍 279 👎 0


public class L214_ShortestPalindrome {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * TM居然超出内存
         *
         * @param s
         * @return
         */
        public String shortestPalindrome2(String s) {
            if (s.length() <= 1) return s;
            char[] chars = s.toCharArray();
            int len = chars.length;
            boolean[][] dp = new boolean[len][len];
            for (int i = len - 1; i >= 0; i--) {
                dp[i][i] = true;
                for (int j = i + 1; j < len; j++) {
                    if (chars[i] == chars[j]) {
                        if (j - i < 2 || dp[i + 1][j - 1]) dp[i][j] = true;
                    }
                }
            }
            int index = 0;
            for (int i = 0; i < len; i++) {
                if (dp[0][i]) {
                    index = i;
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i = len - 1; i > index; i--) {
                res.append(chars[i]);
            }
            res.append(s);
            return res.toString();
        }


        public String shortestPalindrome(String s) {
            String reverse = new StringBuilder(s).reverse().toString();
            int n = s.length();
            int i = 0;
            for (; i < n; i++) {
                if (s.substring(0, n - i).equals(reverse.substring(i))) {
                    break;
                }
            }
            return new StringBuilder(s.substring(n - i)).reverse() + s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L214_ShortestPalindrome().new Solution();

    }
}