package sword;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 49 👎 0


public class S21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            if (nums.length <= 1) return nums;
            int left = 0;
            int right = nums.length - 1;
            while (true) {
                while (left < nums.length && nums[left] % 2 == 1) left++;
                while (right >= 0 && nums[right] % 2 == 0) right--;
                //交换
                if (right < left) break;
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();

    }
}