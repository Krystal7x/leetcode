package leetcode.技巧类.二分;

/**
 * 描述:
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例 2：
 *
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 *
 *
 * @author luokui
 * @create 2020-08-20 18:35
 */
public class L875_Solution {
    int minEatingSpeed(int[] piles, int H) {
        int pmax = getMax(piles);
        int left = 1;
        int right = pmax;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return right;
    }

    // 时间复杂度 O(N)
    boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }


    int getMax(int[] piles) {
        int ans = Integer.MIN_VALUE;
        for (int n : piles) {
            if (n > ans) {
                ans = n;
            }
        }
        return ans;
    }
}
