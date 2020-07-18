package leetcode.技巧类.位操作;

/**
 * 描述:
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * @author luokui
 * @create 2020-07-17 17:45
 */
public class L231_Solution {
    boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
