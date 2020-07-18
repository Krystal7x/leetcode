package leetcode.技巧类.位操作;

/**
 * 描述:
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * @author luokui
 * @create 2020-07-17 17:32
 */
public class L191_Solution {

    int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }
}
