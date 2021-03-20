package leetcode.动态规划;

//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1] 
//输出: 0 
//解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 数组 动态规划 
// 👍 500 👎 0


public class L123_BestTimeToBuyAndSellStockIii {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            return maxProfit(prices, 2);
        }

        /**
         * 股票买卖重点
         *
         * @param prices
         * @param K
         * @return
         */
        public int maxProfit(int[] prices, int K) {
            if (prices == null || prices.length < 2) return 0;
            int length = prices.length;

            //dp[i][k][1]含义 第i天最多k次交易时的最大利润,0持有，1卖出
            int[][][] dp = new int[length + 1][K + 1][2];

            // 没开始走价格时，卖出利润当然是 0 。
            dp[0][K][1] = 0;

            //还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
            for (int i = 0; i <= K; i++) {
                dp[0][i][0] = Integer.MIN_VALUE;
            }

            for (int i = 0; i <= length; i++) {
                
                //不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
                dp[i][0][0] = Integer.MIN_VALUE;

                //不允许交易的情况下，不会有利润，所以是0。
                dp[i][0][1] = 0;
            }

            for (int i = 1; i <= length; i++) {
                for (int k = 1; k <= K; k++) {
                    //持有的最大利润
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k - 1][1] - prices[i - 1]);
                    //卖出的最大利润
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] + prices[i - 1]);
                }

            }

            return dp[length][K][1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L123_BestTimeToBuyAndSellStockIii().new Solution();

    }
}