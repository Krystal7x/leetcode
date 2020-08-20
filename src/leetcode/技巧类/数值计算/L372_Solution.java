package leetcode.技巧类.数值计算;

import java.util.Stack;

/**
 * 描述:
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 示例 1:
 *
 * 输入: a = 2, b = [3]
 * 输出: 8
 * 示例 2:
 *
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 *
 *
 * @author luokui
 * @create 2020-08-20 15:36
 */
public class L372_Solution {

    int mod = 1337;


    int superPow(int a, int[] b) {
        Stack<Integer> bs = new Stack<>();
        for (int n : b) {
            bs.push(n);
        }
        return superPow(a, bs);
    }

    int superPow(int a, Stack<Integer> bs) {
        int res = 1;
        while (!bs.isEmpty()) {
            int n = bs.pop();
            res = res * pow(a, n) * pow(superPow(a, bs), 10);
            res = res % mod;
        }
        return res;
    }

    int pow(int a, int n) {
        a = a % mod;
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = res * a;
            res = res % mod;
        }
        return res;
    }
}
