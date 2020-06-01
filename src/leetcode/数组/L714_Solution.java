package leetcode.数组;

import javax.annotation.Resource;
import java.awt.image.RescaleOp;

/**
 * 描述:无数次 和122一样
 *
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；
 * 非负整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
 * 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * @author luokui
 * @create 2020-05-30 15:41
 */
public class L714_Solution {

    public int maxProfit(int[] prices, int fee) {
        int sell = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, hold + prices[i] - fee);
            hold = Math.max(hold, sell - prices[i]);
        }
        return Math.max(sell, hold);

    }
}
