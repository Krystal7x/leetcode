package hot100;

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1577 👎 0


public class L10_RegularExpressionMatching {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 递归解法，测试有错，但是完全看不出来
         * "mississppi", "mis*is*p*."
         *
         * @param s
         * @param p
         * @return
         */
        public  boolean isMatch2(String s, String p) {
            return isMatch2(s, 0, p, 0);

        }

        public  boolean isMatch2(String s, int i, String p, int j) {
            if (i == s.length()) return j == p.length();
            if (j == p.length()) return false;
            char a = p.charAt(j);
            char b = p.charAt(j);
            boolean isMatch = a == b || b == '.';

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                if (isMatch) {
                    //*0次，1次，多次
                    return isMatch2(s, i, p, j + 2) || isMatch2(s, i + 1, p, j + 2) || isMatch2(s, i + 1, p, j);
                } else {
                    //*0次
                    return isMatch2(s, i, p, j + 2);
                }
            } else {
                return isMatch && isMatch2(s, i + 1, p, j + 1);
            }
        }


        /**
         * 动态规划解法
         *
         * @param s
         * @param p
         * @return
         */
        //动态规划解法，考虑dp[i][j]的意义，即s的前i个字符能否被p的前j个字符匹配
        //若有dp[i-1][j-1]，思考状态转移方程是什么，即dp[i][j]=？
        //第一种情况：s[i]与p[j]都是字母，则直接比较，若相等即dp[i][j]=dp[i-1][j-1],否则为false
        //第二种情况：p[j]为“.”，这种情况相当于上述情况：dp[i][j]=dp[i-1][j-1]
        //第三种情况较麻烦：p[j]为“*”，*的含义是匹配零个或多个前面的字符，所以要考虑p[j-1]，如果p[j-1]匹配不上s[i]，则*处也匹配不上
        //所以按照p[j-1]与s[i]是否相等可以分为两种情况：
        //s[i]!=p[j-1] and p[j-1]!=.，dp[i][j]=dp[i][j-2]
        //s[i]==p[j-1] or p[j-1]=. ，dp[i][j]又有三种情况：
        //1、*匹配前面字符的多个字符：dp[i][j]=dp[i-1][j]
        //2、*匹配前面字符的一个字符：dp[i][j]=dp[i][j-1]
        //3、*匹配前面字符的零个字符：dp[i][j]=dp[i][j-2]
        //综上，可得出dp[i][j]赋值的各个情形，赋值从dp[0][0]开始，故dp[i][j]一定能从之前的值中得出
        public  boolean isMatch(String s, String p) {
            //首先要排除特殊情况
            if (s == null || p == null) return false;
            //初始化矩阵dp
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            //首先可以初始化第1行
            for (int i = 1; i <= p.length(); i++) {
                if (p.charAt(i - 1) == '*' && dp[0][i - 2])
                    dp[0][i] = true;
            }
            for (int m = 1; m <= s.length(); m++) {
                for (int n = 1; n <= p.length(); n++) {
                    if (s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '.')
                        dp[m][n] = dp[m - 1][n - 1];
                    else if (p.charAt(n - 1) == '*') {
                        //不匹配，只能0次
                        if (p.charAt(n - 2) != s.charAt(m - 1) && p.charAt(n - 2) != '.') {
                            dp[m][n] = dp[m][n - 2];
                        } else {
                            //多次，一次，0次
                            dp[m][n] = (dp[m - 1][n] || dp[m][n - 1] || dp[m][n - 2]);
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L10_RegularExpressionMatching().new Solution();

    }
}