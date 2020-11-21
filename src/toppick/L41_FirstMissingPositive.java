package toppick;

//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组 
// 👍 855 👎 0


//L41、缺失的第一个正数 ---- 
public class L41_FirstMissingPositive {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums.length == 0) return 1;
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] > 0 && nums[i] < nums.length
                        && nums[i] != (i + 1) && nums[i] != nums[nums[i] - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != (i + 1)) return i + 1;
            }
            return nums.length + 1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L41_FirstMissingPositive().new Solution();

    }
}