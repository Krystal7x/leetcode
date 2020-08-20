package leetcode.技巧类.数值计算;

/**
 * 描述:
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @author luokui
 * @create 2020-08-19 17:29
 */
public class L204_Solution {
    int countPrimes(int n) {
        //0表示是素数，1表示不是
        int[] isPrimes = new int[n];

        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i] == 0) {
                for (int j = i * 2; j < n; j = j + i) {
                    isPrimes[j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i] == 0) {
                ans++;
            }
        }
        return ans;

    }
}
