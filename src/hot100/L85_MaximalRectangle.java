package hot100;

//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix.length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 636 👎 0


import java.util.Arrays;
import java.util.Stack;

//L85、最大矩形 ----
public class L85_MaximalRectangle {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 暴力dp
         * 遍历每个点，求以这个点为矩阵右下角的所有矩阵面积。
         * 1、知道以这个点结尾的连续 1 的个数
         * 2、求出高度是 1 的矩形面积，也就是它自身的数，如图中橙色的 4，面积就是 4。
         * 3、然后向上扩展一行，高度增加一，选出当前列最小的数字，作为矩阵的宽，求出面积，对应上图的矩形框。
         * 4、然后继续向上扩展，重复步骤 3。
         *
         * @param matrix
         * @return
         */
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return 0;
            int[][] dp = new int[matrix.length][matrix[0].length];
            //1
            for (int i = 0; i < matrix.length; i++) {
                dp[i][0] = matrix[i][0] - '0';
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                }
            }

            //2 遍历节点
            int ares = 0;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    if (dp[row][col] > 0) {
                        //记录第几行
                        int up = row;
                        //记录所有行中最小的长度
                        int minWidth = dp[row][col];
                        while (up >= 0) {
                            int height = row - up + 1;
                            minWidth = Math.min(minWidth, dp[up][col]);
                            ares = Math.max(ares, height * minWidth);
                            up--;
                        }
                    }
                }

            }
            return ares;
        }


        /**
         * 解法2
         * 利用L84的解法，想像成坐标，计算每一层的面积
         *
         * @param matrix
         * @return
         */
        public int maximalRectangle2(char[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int[] heights = new int[matrix[0].length];
            int maxArea = 0;
            for (int row = 0; row < matrix.length; row++) {
                //遍历每一列，更新高度
                for (int col = 0; col < matrix[0].length; col++) {
                    if (matrix[row][col] == '1') {
                        heights[col] += 1;
                    } else {
                        heights[col] = 0;
                    }
                }
                //调用上一题的解法，更新函数
                maxArea = Math.max(maxArea, largestRectangleArea2(heights));
            }
            return maxArea;
        }

        public int largestRectangleArea2(int[] heights) {
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            int p = 0;
            while (p < heights.length) {
                //栈空入栈
                if (stack.isEmpty()) {
                    stack.push(p);
                    p++;
                } else {
                    int top = stack.peek();
                    //当前高度大于栈顶，入栈
                    if (heights[p] >= heights[top]) {
                        stack.push(p);
                        p++;
                    } else {
                        //保存栈顶高度
                        int height = heights[stack.pop()];
                        //左边第一个小于当前柱子的下标
                        int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                        //右边第一个小于当前柱子的下标
                        int RightLessMin = p;
                        //计算面积
                        int area = (RightLessMin - leftLessMin - 1) * height;
                        maxArea = Math.max(area, maxArea);
                    }
                }
            }
            while (!stack.isEmpty()) {
                //保存栈顶高度
                int height = heights[stack.pop()];
                //左边第一个小于当前柱子的下标
                int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
                int RightLessMin = heights.length;
                int area = (RightLessMin - leftLessMin - 1) * height;
                maxArea = Math.max(area, maxArea);
            }
            return maxArea;
        }


        /**
         * 这个有点难，先看第一个吧
         *
         * @param matrix
         * @return
         */
        public int maximalRectangle3(char[][] matrix) {
            if (matrix.length == 0) return 0;
            int m = matrix.length;
            int n = matrix[0].length;

            int[] left = new int[n]; // initialize left as the leftmost boundary possible
            int[] right = new int[n];
            int[] height = new int[n];

            Arrays.fill(right, n); // initialize right as the rightmost boundary possible

            int maxarea = 0;
            for (int i = 0; i < m; i++) {
                int cur_left = 0, cur_right = n;
                // update height
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') height[j]++;
                    else height[j] = 0;
                }
                // update left
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                    else {
                        left[j] = 0;
                        cur_left = j + 1;
                    }
                }
                // update right
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                    else {
                        right[j] = n;
                        cur_right = j;
                    }
                }
                // update area
                for (int j = 0; j < n; j++) {
                    maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
                }
            }
            return maxarea;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L85_MaximalRectangle().new Solution();

    }
}