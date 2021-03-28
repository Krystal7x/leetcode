package hot100;

//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 945 👎 0


//L287、寻找重复数 ---- 
public class L287_FindTheDuplicateNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 把值想像成链表，这样的话有两个节点指向同一个节点，即一定有环
         *
         * @param nums
         * @return
         */
        public int findDuplicate(int[] nums) {
            int slow = nums[0], fast = nums[nums[0]];
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            //至此，相遇了

            //找起点
            int ans = 0;
            while (ans != slow) {
                ans = nums[ans];
                slow = nums[slow];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L287_FindTheDuplicateNumber().new Solution();

    }
}