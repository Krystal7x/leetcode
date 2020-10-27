package hot100;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2668 👎 0

public class L5_LongestPalindromicSubstring {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划,与最长子序列做法一样
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            int length = s.length();
            //dp[i][j]含义：i到j的字串是不是回文
            boolean[][] dp = new boolean[length][length];
            int left = 0;
            int right = 0;
            for (int i = length - 1; i >= 0; i--) {
                //单字符肯定是true
                dp[i][i] = true;
                for (int j = i + 1; j < length; j++) {
                    //小于3是因为aba一定是回文，同时解决了abba的情况
                    if (s.charAt(i) == s.charAt(j) && ((j - i < 3) || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        if ((j - i) > (right - left)) {
                            left = i;
                            right = j;
                        }
                    }
                }
            }
            return s.substring(left, right + 1);
        }

        /**
         * 非递归写法，就是循环每一位字符然后ij向外扩，注意aba与abba的情况
         *
         * @param s
         * @return
         */
        public String longestPalindrome2(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            int length = s.length();
            String ans = s.substring(0, 1);
            for (int i = 1; i < length; i++) {
                String palindrome1 = getPalindrome(s, i, i);
                String palindrome2 = getPalindrome(s, i - 1, i);
                if (palindrome1.length() > ans.length()) ans = palindrome1;
                if (palindrome2.length() > ans.length()) ans = palindrome2;
            }
            return ans;
        }

        private String getPalindrome(String s, int n1, int n2) {
            while (n1 >= 0 && n2 < s.length() && s.charAt(n1) == s.charAt(n2)) {
                n1--;
                n2++;
            }
            return s.substring(n1 + 1, n2);

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome2("12cabbac12"));

    }
}