package hot100;

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 615 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//L239、滑动窗口最大值 ----
public class L239_SlidingWindowMaximum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> list = new ArrayList<>();
            if (nums.length == 0) return new int[0];
            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                //弹出条件，注意一下
                if (i >= k && stack.peekFirst() == nums[i - k]) stack.removeFirst();
                //单调
                while (!stack.isEmpty() && stack.peekLast() < nums[i]) {
                    stack.removeLast();
                }
                stack.add(nums[i]);
                if (i >= k - 1) {
                    list.add(stack.peekFirst());
                }
            }
            return list.stream().mapToInt(Integer::valueOf).toArray();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L239_SlidingWindowMaximum().new Solution();

    }
}