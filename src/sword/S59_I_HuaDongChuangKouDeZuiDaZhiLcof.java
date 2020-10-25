package sword;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
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
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 132 👎 0


import java.util.LinkedList;

public class S59_I_HuaDongChuangKouDeZuiDaZhiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k < 1 || nums.length < k) {
                return new int[0];
            }

            int index = 0;
            int[] res = new int[nums.length - k + 1];
            LinkedList<Integer> queue = new LinkedList<>();

            for (int right = 0; right < nums.length; right++) {
                // 在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
                // 那么为了维持从大到小的原则，我必须让尾部元素弹出
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]) {
                    queue.pollLast();
                }
                // 在队列尾部添加位置
                queue.addLast(right);
                // 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
                if (queue.peekFirst() == (right - k)) {
                    queue.pollFirst();
                }
                // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
                if (right >= (k - 1)) {
                    res[index++] = nums[queue.peekFirst()];
                }
            }
            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S59_I_HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        System.out.println(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

    }
}