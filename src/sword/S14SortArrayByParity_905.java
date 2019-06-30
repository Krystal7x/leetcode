package sword;

/**
 * @auther k
 * @date 2019-06-30 12:20
 * <p>
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 参考代码
 * 1.最简单的方法就是把奇数和偶数按顺序挑出来，分别放到vector里，最后再把偶数的vector接到奇数vector的末尾。
 * 2.如果不能开僻额外的空间，可以尝试有类似于冒泡排序的方法,如果当前的值为偶数，后一个值为奇数，则两个数对换位置：
 */

public class S14SortArrayByParity_905 {
    /**
     * 偶数和偶数之间的相对位置不变。即稳定
     * 偶数在前
     *
     * @param A
     * @return
     */

    public int[] sortArrayByParity1(int[] A) {
        if (A == null) {
            return null;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] % 2 == 0) {
                        int tmp = A[i];
                        A[i] = A[j];
                        A[j] = tmp;
                        break;
                    }
                }
            }
        }
        return A;
    }

    /**
     * 偶数和偶数之间的相对位置可变。即不稳定
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {

        return A;
    }

    public static void main(String[] args) {
        S14SortArrayByParity_905 a = new S14SortArrayByParity_905();
        int[] n = new int[]{3, 1, 2, 4};
        a.sortArrayByParity1(n);
    }
}
