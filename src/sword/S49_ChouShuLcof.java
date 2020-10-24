package sword;

//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 80 👎 0


public class S49_ChouShuLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            int two = 1;
            int three = 1;
            int five = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int n2 = dp[two] * 2;
                int n3 = dp[three] * 3;
                int n5 = dp[five] * 5;
                dp[i] = Math.min(Math.min(n2, n3), n5);
                if (dp[i] == n2) two++;
                if (dp[i] == n3) three++;
                if (dp[i] == n5) five++;

            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S49_ChouShuLcof().new Solution();

    }
}