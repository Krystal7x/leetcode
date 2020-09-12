package leetcode.动态规划;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 589 👎 0

import common.MockData;

import java.util.LinkedList;
import java.util.List;

public class L120_Triangle {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
            int deep = triangle.size();
            int size = triangle.get(deep - 1).size();
            //dp[i]含义：到i位置的最小值
            int[] dp = new int[size];

            //初始化所有值
            for (int i = 0; i < size; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            dp[0] = triangle.get(0).get(0);

            //遍历
            for (int i = 1; i < size; i++) {
                List<Integer> list = triangle.get(i);
                int length = list.size();
                for (int j = length - 1; j >= 0; j--) {
                    if (j == 0) {
                        dp[j] = list.get(j) + dp[j];
                    } else {
                        dp[j] = list.get(j) + Math.min(dp[j], dp[j - 1]);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                min = Math.min(min, dp[i]);

            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L120_Triangle().new Solution();
        System.out.println(solution.minimumTotal(MockData.getDoubleList("2", "3,4", "6,5,7", "4,1,8,3")));

    }
}