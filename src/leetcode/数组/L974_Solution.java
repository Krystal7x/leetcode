package leetcode.数组;

/**
 * 描述:
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * <p>
 * <p>
 * 方法一：前缀和与哈希表
 * 思路
 * <p>
 * 通常，涉及连续子数组问题的时候，我们使用前缀和来解决。我们令 P[i] = A[0] + A[1] + ... + A[i]。
 * 那么，每个连续子数组的和 sum(i, j) 就可以写成 P[j] - P[i-1] （其中 j > i 且 i > 0） 的形式。
 * 那么判断子数组的和能否被 K 整除就可以写成 (P[j] - P[i-1])%K == 0，
 * 根据 同余定理 ，只要 P[j]%K == P[i-1]%K，就可以保证上面的式子成立。
 * <p>
 * 根据上面的思路，我们只需要一次遍历计算所有前缀和模 K 的值的数量，然后用排列组合的方法来计算答案即可。
 *
 * @author luokui
 * @create 2020-05-20 10:17
 */
public class L974_Solution {
    //[2,-2,2,-4]

    public int subarraysDivByK2(int[] A, int K) {
        int result = 0;
        //计算前缀和
        int[] arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                arr[i] = A[i];
            } else {
                arr[i] = A[i] + arr[i - 1];
            }
        }
        //同余定理，取所有前缀和与k的余数
        //(P[j] - P[i-1])%K == 0，根据 同余定理 ，只要 P[j]%K == P[i-1]%K，就可以保证上面的式子成立。
        //要考虑取模为负值的情况  //负数时,因为是前缀相减，所有需要这样
        int[] yu = new int[K];
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i] % K;
            if (a < 0) a = K + a;
            yu[a]++;
        }

        //先处理不是0的情况
        for (int i = 0; i < K; i++) {
            if (yu[i] > 1) {
                int a = yu[i];
                for (int n = 1; n < a; n++) {
                    result = result + n;
                }
            }
        }
        //0的情况需要加上
        if (yu[0] != 0) {
            result = result + yu[0];
        }

        return result;
    }

    public int subarraysDivByK(int[] A, int K) {
        int N = A.length;
        //此时A数组保留的就是前缀和取模后的结果
        A[0] %= K;
        for (int i = 1; i < N; ++i) {
            A[i] = (A[i] + A[i - 1]) % K;
        }

        int[] count = new int[K];
        //0的情况
        count[0]++;
        for (int x : A) {
            //负数时,因为是前缀相减，所有需要这样
            count[(x % K + K) % K]++;
        }

        //
        int ans = 0;
        //1加到n = n * (n - 1) / 2
        for (int v : count) {
            ans += v * (v - 1) / 2;
        }
        return ans;
    }


    //java 取余数 是负数
    public static void main(String[] args) {
        //-1
        System.out.println(-3 % 2);

        System.out.println((-2 % 5 + 5) % 5);

    }

}
