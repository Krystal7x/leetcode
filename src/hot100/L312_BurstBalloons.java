package hot100;

//有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 lef
//t 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 说明: 
//
// 
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// 示例: 
//
// 输入: [3,1,5,8]
//输出: 167 
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// 
// Related Topics 分治算法 动态规划 
// 👍 566 👎 0


//L312、戳气球 ----  https://mp.weixin.qq.com/s/I0yo0XZamm-jMpG-_B3G8g
public class L312_BurstBalloons {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int maxCoins(int[] nums) {
            int length = nums.length;
            //加上头尾两个节点
            int[] tmp = new int[length + 2];
            tmp[0] = 1;
            tmp[length + 1] = 1;
            for (int i = 0; i < length; i++) {
                tmp[i + 1] = nums[i];
            }
            //dp[i][j] = x表示，戳破气球i和气球j之间（开区间，不包括i和j）的所有气球，可以获得的最高分数为x。
            // 开区间  i到j  的最大值
            int[][] dp = new int[length + 2][length + 2];
            //从下往上
            for (int i = length; i >= 0; i--) {
                //从左往右
                for (int j = i + 1; j < dp.length; j++) {
                    //k是这个区间   最后一个   被戳爆的气球！
                    // 从i到j 此时长度一定>=3了
                    for (int k = i + 1; k < j; k++) {
                        // 择优做选择
                        dp[i][j] = Math.max(
                                dp[i][j],
                                dp[i][k] + dp[k][j] + tmp[i] * tmp[j] * tmp[k]
                        );
                    }

                }
            }
            return dp[0][length + 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L312_BurstBalloons().new Solution();

    }
}