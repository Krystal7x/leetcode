package hot100;

//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 596 👎 0


//L309、最佳买卖股票时机含冷冻期 ---- 
public class L309_BestTimeToBuyAndSellStockWithCooldown {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * L122 演变  就是买入时只能从前一天卖出时计算
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int length = prices.length;

            //dp[i][1]含义 第i天时的最大利润,0持有，1卖出
            int[][] dp = new int[length + 1][2];

            // 没开始走价格时，卖出利润当然是 0 。
            dp[0][1] = 0;
            //还没开始的时候，是不可能持有股票的
            dp[0][0] = Integer.MIN_VALUE;
            //第一个物品持有
            dp[1][0] = -prices[0];
            //第一个物品不持有
            dp[1][1] = 0;
            for (int i = 2; i <= length; i++) {
                //持有的最大利润
                //持有最大值，就是前一天就持有，或者前两天卖出今天买入
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i - 1]);
                //卖出最大值，就是前一天就卖出，或者昨天持有今天卖出
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
            }
            return dp[length][1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L309_BestTimeToBuyAndSellStockWithCooldown().new Solution();

    }
}