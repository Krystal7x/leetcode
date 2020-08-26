package leetcode.数据结构.数组;

/**
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 * @author k
 * @date 2020-05-16 18:20
 */


public class L1010_Solution {

    //暴力-超时
   /* public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        if (time == null || time.length == 0) {
            return result;
        }
        int length = time.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    result++;
                }
            }
        }
        return result;
    }*/


    //取余法
    public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        if (time == null || time.length == 0) {
            return result;
        }
        int[] map = new int[60];
        int length = time.length;
        for (int i = 0; i < length; i++) {
            map[time[i] % 60]++;
        }
        result = result + com(map[0], 2);
        result = result + com(map[30], 2);

        for (int i = 1; i <= 29; i++) {
            result = result + map[i] * map[60 - i];
        }

        return result;
    }

    // 求组合数
    public int com(int n, int k) {
        int count = 1;
        for (int i = 1; i <= k; i++) {
            count = count * (n - i + 1) / i;
        }
        return count;
    }
}
