package sword;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 79 👎 0


public class S10_II_QingWaTiaoTaiJieWenTiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n) {
            if (n == 0) return 1;
            if (n == 1) return 1;
            if (n == 2) return 2;
            int a1 = 1;
            int a2 = 2;
            int res = 0;
            for (int i = 3; i <= n; i++) {
                res = (a1 + a2) % 1000000007;
                a1 = a2;
                a2 = res;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S10_II_QingWaTiaoTaiJieWenTiLcof().new Solution();

    }
}