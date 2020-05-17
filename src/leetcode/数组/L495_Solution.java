package leetcode.数组;

/**
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 * <p>
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 * <p>
 *  
 * <p>
 * 示例1:
 * <p>
 * 输入: [1,4], 2
 * 输出: 4
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
 * 所以最终输出 4 秒。
 * 示例2:
 * <p>
 * 输入: [1,2], 2
 * 输出: 3
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
 * 由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
 * 所以最终输出 3 。
 *
 * @author k
 * @date 2020-05-17 18:21
 */

public class L495_Solution {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }

        //中毒时间
        int result = duration;
        //中毒到期时间点
        int time = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if ((timeSeries[i] < time) && (time - timeSeries[i]) > duration) {
                continue;
            }
            //此时间点还在中毒期间
            if ((timeSeries[i] < time) && (time - timeSeries[i]) < duration) {
                result = result + (duration + timeSeries[i] - time);
                time = timeSeries[i] + duration;
            }
            //中毒时间已过
            if (timeSeries[i] >= time) {
                result = result + duration;
                time = timeSeries[i] + duration;
            }


        }
        return result;

    }


    /**
     * 人家想的多简单啊
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public static int findPoisonedDuration2(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        if (timeSeries.length <= 1) {
            return duration;
        }
        int sumdura = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if ((timeSeries[i] - timeSeries[i - 1]) > duration) {
                sumdura += duration;
            } else {
                sumdura += timeSeries[i] - timeSeries[i - 1];
            }
        }
        sumdura += duration;
        return sumdura;
    }


    public static void main(String[] args) {
        int[] timeSeries = {1, 2};
        L495_Solution.findPoisonedDuration(timeSeries, 2);
    }
}
