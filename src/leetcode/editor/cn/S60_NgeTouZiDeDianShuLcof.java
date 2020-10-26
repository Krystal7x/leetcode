package leetcode.editor.cn;

//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// 👍 128 👎 0


public class S60_NgeTouZiDeDianShuLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dice = new int[]{1, 2, 3, 4, 5, 6};

        public double[] twoSum(int n) {
            //所有可能的结果
            int[] diceSum = new int[6 * n + 1];
            //所有可能出现的和
            for (int target = n; target <= 6 * n; target++) {
                twoSum(diceSum, target, 0, n, 0);
            }
            //计算概率
            int count = 0;
            int may = 0;
            for (int i = 0; i < diceSum.length; i++) {
                if (diceSum[i] != 0) {
                    may++;
                    count += diceSum[i];
                }
            }
            int index = 0;
            double[] ans = new double[may];
            for (int i = 0; i < diceSum.length; i++) {
                if (diceSum[i] != 0) {
                    ans[index++] = (diceSum[i] + 0.0d) / count;
                }
            }
            return ans;
        }

        /**
         * @param diceSum 记录结果
         * @param target  目标值
         * @param sum     目前的和
         * @param n       一共扔几次
         * @param k       目前是第几次
         */
        public void twoSum(int[] diceSum, int target, int sum, int n, int k) {
            if (sum > target) return;
            if (target - sum > (n - k) * 6) return;
            if (k == n) {
                if (sum == target) {
                    diceSum[target]++;
                }
                return;
            }
            for (int i = 0; i < dice.length; i++) {
                twoSum(diceSum, target, sum + dice[i], n, k + 1);
            }
        }

    }

//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S60_NgeTouZiDeDianShuLcof().new Solution();

    }
}