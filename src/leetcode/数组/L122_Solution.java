package leetcode.数组;

/**
 * 描述:无数次
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author luokui
 * @create 2020-05-30 17:39
 */
public class L122_Solution {
    public int maxProfit2(int[] prices) {
        int[] sell = new int[prices.length];
        int[] hold = new int[prices.length];
        sell[0] = 0;
        hold[0] = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], sell[i - 1] - prices[i]);
        }
        return sell[prices.length - 1];
    }


    /**
     * 先我们需要理解一点，
     * 第i天买入，第j天卖出得到的收益和第i天买入，第i+p天卖出，
     * 第i+p天再买入，第j天卖出得到的收益是相同的。
     * 比如[1,2,3,4,5]，很明显我们知道最大收益是4，可以看作是第一天买入，第五天卖出，
     * 但是也可以看作是第1天买入，第二天卖出，同时买入，第三天又卖出，同时买入······
     * <p>
     *   理解了这一点，我们就清楚这里为什么能用贪心的思想了，
     * 从第一天开始买入，只要有收益就可以直接卖出，接下来再买入，
     * 同样一旦有收益就可以卖出，这是一种典型的贪心思想，局部最优达到全局最优。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //贪心法
        if (prices == null || prices.length == 0)
            return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
