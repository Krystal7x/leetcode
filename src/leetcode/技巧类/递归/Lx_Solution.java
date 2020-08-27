package leetcode.技巧类.递归;

/**
 * 描述:
 * 汉诺塔
 *
 * @author luokui
 * @create 2020-08-27 17:14
 */
public class Lx_Solution {

    /**
     * 将 n 个圆盘从 a 经由 b 移动到 c 上
     */
    void Hanoi(int n, char a, char b, char c) {
        if (n == 0) return;
        Hanoi(n - 1, a, c, b);
        move(a, c);
        Hanoi(n - 1, b, a, c);

    }

    void move(char a, char b) {
        System.out.println(a + " -> " + b);
    }
}
