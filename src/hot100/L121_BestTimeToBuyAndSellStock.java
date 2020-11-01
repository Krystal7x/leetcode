package hot100;

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1190 👎 0

//L121、买卖股票的最佳时机   -----
public class L121_BestTimeToBuyAndSellStock {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int length = prices.length;
            //dp[i][1]含义 第i天时的最大利润,0持有，1卖出
            int[][] dp = new int[length + 1][2];
            dp[0][0] = Integer.MIN_VALUE;
            dp[0][1] = 0;
            for (int i = 1; i <= length; i++) {
                //因为你只能持有一次，所以持有的利润只能根据-prices[i - 1]来算，这是与122的区别
                dp[i][0] = Math.max(dp[i - 1][0], -prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
            }
            return dp[length][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L121_BestTimeToBuyAndSellStock().new Solution();

    }
}