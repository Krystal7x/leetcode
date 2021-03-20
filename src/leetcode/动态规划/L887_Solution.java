package leetcode.动态规划;

/**
 * 描述:
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * <p>
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * <p>
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * <p>
 * 你的目标是确切地知道 F 的值是多少。
 * <p>
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * @author luokui
 * @create 2020-06-08 21:03
 */
//https://mp.weixin.qq.com/s/xn4LjWfaKTPQeCXR0qDqZg
public class L887_Solution {
    //最传统的动态规划，居然超时
    public int superEggDrop2(int K, int N) {

        int[][] dp = new int[N + 1][K + 1];
        //鸡蛋只有一个时，一定是i
        for (int i = 1; i <= N; i++) dp[i][1] = i;
        //只有一层楼时，就是1
        for (int i = 1; i <= K; i++) dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                //最差为i次
                dp[i][j] = i;
                //每层楼开始
                for (int k = 1; k <= i; k++) {
                    //如果鸡蛋碎了，那么鸡蛋的个数K应该减一，搜索的楼层区间应该从[1..N]变为[1..i-1]共i-1层楼；
                    //如果鸡蛋没碎，那么鸡蛋的个数K不变，搜索的楼层区间应该从 [1..N]变为[i+1..N]共N-i层楼。
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
                }
            }
        }
        return dp[N][K];
    }

    /**
     * 二分优化
     */
    public int superEggDrop(int K, int N) {

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) dp[i][1] = i;
        for (int i = 1; i <= K; i++) dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = i;
                int x = 1;
                int y = i;
                while (x <= y) {
                    int mid = (x + y) / 2;
                    int broke = dp[mid - 1][j - 1];
                    int not_broke = dp[i - mid][j];
                    if (broke > not_broke) {
                        y = mid - 1;
                        dp[i][j] = Math.min(dp[i][j], broke + 1);
                    } else {
                        x = mid + 1;
                        dp[i][j] = Math.min(dp[i][j], not_broke + 1);
                    }
                }
            }
        }
        return dp[N][K];
    }
}
