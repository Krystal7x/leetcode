package sword1;

/**
 * @auther k
 * @date 2019-06-30 11:21
 * <p>
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * <p>
 * 解题思路
 * 公式:
 * f(n) = n, n <= 1
 * f(n) = f(n-1) + f(n-2), n > 1
 * 1,可以直接使用递归的方法
 * 2,递归的方法可能会遇到Stack Overflow，所以我们可以考虑用动态规划的方法来实现。
 * 采用自底向上方法来保存了先前计算的值，为后面的调用服务。
 */

public class S9Fibonacci_L509 {
    /**
     * 递归调用，可能会Stack Overflow
     *
     * @param N
     * @return
     */

    public int fib1(int N) {
        if (N <= 1) {
            return N;
        }
        return fib1(N - 1) + fib1(N - 2);
    }

    /**
     * 动态规划用变量保存前面的结果
     *
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int f1 = 0;
        int f2 = 1;
        int result = f1 + f2;
        for (int i = 3; i <= N; i++) {
            f1 = f2;
            f2 = result;
            result = f1 + f2;
        }

        return result;
    }


}
