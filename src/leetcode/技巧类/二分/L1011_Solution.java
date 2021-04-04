package leetcode.技巧类.二分;

/**
 * 描述:
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 *
 * @author luokui
 * @create 2020-08-20 18:53
 */
public class L1011_Solution {
    // 寻找左侧边界的二分查找
    int shipWithinDays(int[] weights, int D) {
        // 载重可能的最小值、每个包裹能放上船啊
        int left = getMax(weights);
        // 载重可能的最大值 + 1
        int right = getSum(weights) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        return sum;
    }

    int getMax(int[] weights) {
        int ans = Integer.MIN_VALUE;
        for (int n : weights) {
            if (n > ans) {
                ans = n;
            }
        }
        return ans;
    }

    // 如果载重为 cap，是否能在 D 天内运完货物？
    boolean canFinish(int[] w, int D, int cap) {
        int ans = 0;
        int sumTmp = 0;
        for (int i = 0; i < w.length; i++) {
            sumTmp = sumTmp + w[i];
            if (sumTmp > cap) {
                i--;
                ans++;
                sumTmp = 0;
            }
        }
        if (sumTmp != 0) ans++;
        return ans <= D;
    }
}
