package leetcode.动态规划;

//在计算机界中，我们总是追求用有限的资源获取最大的收益。 
//
// 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。 
//
// 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。 
//
// 
//
// 示例 1: 
//
// 输入: strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出: 4
//解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
// 
//
// 示例 2: 
//
// 输入: strs = ["10", "0", "1"], m = 1, n = 1
//输出: 2
//解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
// Related Topics 动态规划 
// 👍 230 👎 0


public class L474_OnesAndZeroes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int zero = 0;
            int one = 0;
            int[][] dp = new int[m + 1][n + 1];

            for (String str : strs) {
                zero = 0;
                one = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '0') zero++;
                    if (str.charAt(i) == '1') one++;
                }
                //这个倒的遍历是关键
                //如果正的遍历，则一个数会被计数多次
                for (int i = m; i >= zero; i--) {
                    for (int j = n; j >= one; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L474_OnesAndZeroes().new Solution();

    }
}