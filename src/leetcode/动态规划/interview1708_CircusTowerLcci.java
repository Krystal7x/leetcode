package leetcode.动态规划;

//有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请
//编写代码计算叠罗汉最多能叠几个人。 
//
// 示例： 
//
// 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
//输出：6
//解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190) 
//
//
// 提示： 
//
// 
// height.length == weight.length <= 10000 
// 
// Related Topics 排序 二分查找 动态规划 
// 👍 42 👎 0


import java.util.Arrays;

public class interview1708_CircusTowerLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 是对的，TM又超时
         *
         * @param height
         * @param weight
         * @return
         */
        public int bestSeqAtIndex2(int[] height, int[] weight) {
            if (height == null || height.length == 0 || weight == null || weight.length == 0) return 0;
            int length = height.length;
            int[][] num = new int[length][2];
            for (int i = 0; i < length; i++) {
                num[i][0] = height[i];
                num[i][1] = weight[i];
            }
            Arrays.sort(num, (int[] o1, int[] o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
            int[] dp = new int[length];
            for (int i = 0; i < length; i++) {
                dp[i] = 1;
            }
            int max = 1;
            for (int i = 1; i < length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (num[i][0] > num[j][0] && num[i][1] > num[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }

                }
                max = Math.max(max, dp[i]);

            }
            return max;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview1708_CircusTowerLcci().new Solution();

    }
}