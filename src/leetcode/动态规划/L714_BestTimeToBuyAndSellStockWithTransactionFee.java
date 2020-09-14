package leetcode.动态规划;

//给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
//
// 示例 1: 
//
// 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出: 8
//解释: 能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8. 
//
// 注意: 
//
// 
// 0 < prices.length <= 50000. 
// 0 < prices[i] < 50000. 
// 0 <= fee < 50000. 
// 
// Related Topics 贪心算法 数组 动态规划 
// 👍 247 👎 0


public class L714_BestTimeToBuyAndSellStockWithTransactionFee {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * L122 演变  就是买入时多算一次手续
         *
         * @param prices
         * @param fee
         * @return
         */
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length < 2) return 0;
            int length = prices.length;

            //dp[i][1]含义 第i天时的最大利润,0持有，1卖出
            int[][] dp = new int[length + 1][2];

            // 没开始走价格时，卖出利润当然是 0 。
            dp[0][1] = 0;
            //还没开始的时候，是不可能持有股票的
            dp[0][0] = Integer.MIN_VALUE;

            for (int i = 1; i <= length; i++) {
                //持有的最大利润
                //因为你能持有无数次，所以持有的利润可以根据卖出再持有来算，这是与121的区别
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i - 1] - fee);
                //卖出的最大利润
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
            }
            return dp[length][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L714_BestTimeToBuyAndSellStockWithTransactionFee().new Solution();

    }
}