package leetcode.数据结构.数组;

/**
 * 描述:二次
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author luokui
 * @create 2020-05-30 18:42
 */
public class L123_Solution {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        //正序
        int min = prices[0];
        //dp[]含义，正着卖，到i为止的最大收益
        int[] seq = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            seq[i] = Math.max(seq[i - 1], prices[i] - min);
        }

        //逆序
        int max = prices[prices.length - 1];
        //dp[]含义，反着卖，到i为止的最大收益
        int[] rev = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            rev[i] = Math.max(rev[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        //得出结果
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(seq[i] + rev[i], result);
        }
        return result;

    }
}
