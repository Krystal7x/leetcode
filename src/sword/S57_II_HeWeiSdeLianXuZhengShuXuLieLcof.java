package sword;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 170 👎 0


import java.util.ArrayList;
import java.util.List;

public class S57_II_HeWeiSdeLianXuZhengShuXuLieLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {

            int left = 1; // 滑动窗口的左边界
            int right = 1; // 滑动窗口的右边界
            int sum = 0; // 滑动窗口中数字的和
            List<int[]> res = new ArrayList<>();

            while (left <= target / 2) {
                if (sum < target) {
                    // 右边界向右移动
                    sum += right;
                    right++;
                } else if (sum > target) {
                    // 左边界向右移动
                    sum -= left;
                    left++;
                } else {
                    // 记录结果
                    int[] arr = new int[right - left];
                    for (int k = left; k < right; k++) {
                        arr[k - left] = k;
                    }
                    res.add(arr);
                    // 左边界向右移动
                    sum -= left;
                    left++;
                }
            }

            return res.toArray(new int[res.size()][]);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S57_II_HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();

    }
}