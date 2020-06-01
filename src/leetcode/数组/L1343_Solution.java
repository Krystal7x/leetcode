package leetcode.数组;

import java.util.Arrays;

/**
 * 描述:
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * <p>
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 *
 * @author luokui
 * @create 2020-05-28 20:53
 */
public class L1343_Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int target = threshold * k;
        int tmpSum = 0;
        for (int i = 0; i < k; i++) {
            tmpSum = tmpSum + arr[i];
        }
        if (tmpSum >= target) result++;
        for (int i = k; i < arr.length; i++) {
            tmpSum = tmpSum + arr[i] - arr[i - k];
            if (tmpSum >= target) result++;
        }

        return result;
    }
}
