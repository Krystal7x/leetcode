package leetcode.动态规划;

//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 
// 👍 328 👎 0


public class L718_MaximumLengthOfRepeatedSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 最长公共子数组
         *
         * @param A
         * @param B
         * @return
         */
        public int findLength(int[] A, int[] B) {
            if (A.length == 0 || B.length == 0) return 0;
            int l1 = A.length;
            int l2 = B.length;
            int ans = 0;
            int[][] dp = new int[l1 + 1][l2 + 1];
            for (int i = 1; i <= l1; i++) {
                for (int j = 1; j <= l2; j++) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }


        /**
         * 1143 最长公共子序列的做法，然后在反向输出数组
         *
         * @param A
         * @param B
         * @return
         */
        public int findLength2(int[] A, int[] B) {
            if (A.length == 0 || B.length == 0) return 0;
            int[][] dp = findLengthDp(A, B);
            return dp[A.length][B.length];

        }

        public int[][] findLengthDp(int[] A, int[] B) {
            int l1 = A.length;
            int l2 = B.length;
            int[][] dp = new int[l1 + 1][l2 + 1];
            for (int i = 1; i <= l1; i++) {
                for (int j = 1; j <= l2; j++) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp;
        }


        public int[] findLengthArr(int[] A, int[] B) {
            int[][] dp = findLengthDp(A, B);
            int length = dp[A.length][B.length];
            int[] ans = new int[length];

            int m = A.length - 1;
            int n = B.length - 1;
            while (m >= 0 || n >= 0) {
                if (A[m] == B[n]) {
                    ans[--length] = A[m];
                    m--;
                    n--;
                } else if (m == 0) {
                    n--;
                } else if (n == 0) {
                    m--;
                } else {
                    if (dp[m][n + 1] > dp[m + 1][n]) {
                        m--;
                    } else {
                        n--;
                    }
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L718_MaximumLengthOfRepeatedSubarray().new Solution();

    }
}