package hot100;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 782 👎 0


//L169、多数元素 ----
public class L169_MajorityElement {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            if (nums.length == 0) return 0;
            int ans = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count > 0) {
                    if (nums[i] == ans) {
                        count++;
                    } else {
                        count--;
                    }
                } else {
                    ans = nums[i];
                    count++;
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L169_MajorityElement().new Solution();

    }
}