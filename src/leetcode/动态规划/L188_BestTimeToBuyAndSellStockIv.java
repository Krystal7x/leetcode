package leetcode.动态规划;

//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
// 
//
// 示例 2: 
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。
// 
// Related Topics 动态规划 
// 👍 297 👎 0


public class L188_BestTimeToBuyAndSellStockIv {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 答案是对的，超出内存限制
         *
         * @param K
         * @param prices
         * @return
         */
        public int maxProfit(int K, int[] prices) {

            if (prices == null || prices.length < 2) return 0;
            int length = prices.length;

            //一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。
            if (K > length / 2) {
                return new L122_BestTimeToBuyAndSellStockIi().new Solution().maxProfit(prices);
            }

            //dp[i][k][1]含义 第i天最多k次交易时的最大利润,0持有，1卖出
            int[][][] dp = new int[length + 1][K + 1][2];

            // 没开始走价格时，卖出利润当然是 0 。
            dp[0][K][1] = 0;

            //还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
            for (int k = 0; k <= K; k++) {
                dp[0][k][0] = Integer.MIN_VALUE;
            }

            for (int i = 0; i <= length; i++) {
                //不允许交易的情况下，不会有利润，所以是0。
                dp[i][0][1] = 0;
                //不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
                dp[i][0][0] = Integer.MIN_VALUE;

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
        Solution solution = new L188_BestTimeToBuyAndSellStockIv().new Solution();

    }
}