package hot100;

//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 488 👎 0


import java.util.LinkedList;
import java.util.List;

//L448、找到所有数组中消失的数字   -----
public class L448_FindAllNumbersDisappearedInAnArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 只有一个
         * 两个的话根据异或值，分成两个数组再算
         *
         * @param nums
         * @return
         */
        int missingNumber(int[] nums) {
            int n = nums.length;
            int res = 0;
            // 先和新补的索引异或一下
            res ^= n;
            // 和其他的元素、索引做异或
            for (int i = 0; i < n; i++)
                res ^= i ^ nums[i];
            return res;
        }


        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> ans = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                int abs = Math.abs(nums[i]) - 1;
                if (nums[abs] < 0) {

                } else {
                    nums[abs] = -nums[abs];
                }
            }
            //缺少的
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }


        /**
         * 交换到对应位置，和上面思想一样
         *
         * @param nums
         * @return
         */
        public List<Integer> findDisappearedNumbers2(int[] nums) {
            List<Integer> ans = new LinkedList<>();
            if (nums.length == 0) return ans;
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != nums[nums[i] - 1]) {
                    int n = nums[i];
                    int tmp = nums[n - 1];
                    nums[n - 1] = nums[i];
                    nums[i] = tmp;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L448_FindAllNumbersDisappearedInAnArray().new Solution();

    }
}