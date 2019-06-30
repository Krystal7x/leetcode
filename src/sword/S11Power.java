package sword;

/**
 * @auther k
 * @date 2019-06-30 12:04
 * <p>
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 解题思路
 * 指数为负时，可以先对指数求绝对值，算出次方的结果后再取倒数
 * 当底数为0，指数为负时，会出现对0求倒数情况，要特殊处理
 * 0的0次方在数学上没有意义，因此无论输出0还是1都是可以接受的
 * 在计算次方的时候，除了简单的遍历，我们可以使用递归的思想，来减少计算量：
 */

public class S11Power {
    public double Power(double base, int exponent) {
        int n = exponent;
        if (exponent == 0) {
            // 当指数为0底数为0时，没有意义，返回0或者返回1都可以
            return 1;
        } else if (exponent < 0) {
            if (base == 0) {
                throw new RuntimeException("分母不能为0");
            }
            n = -exponent;
        }
        double res = PowerUnsignedExponent(base, n);
        return exponent < 0 ? 1 / res : res;
    }

    public double PowerUnsignedExponent(double base, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        //递归
        double res = PowerUnsignedExponent(base, n / 2);
        res *= res;
        if (n % 2 == 1) {
            res *= base;
        }
        return res;
    }
}
