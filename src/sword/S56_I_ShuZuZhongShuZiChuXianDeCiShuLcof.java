package sword;

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 244 👎 0


public class S56_I_ShuZuZhongShuZiChuXianDeCiShuLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {

            int[] ans = new int[2];
            int xor = 0;
            for (int i = 0; i < nums.length; i++) {
                xor = xor ^ nums[i];
            }
            int move = 1;
            while ((xor & move) == 0) {
                move = move << 1;
            }
            int a = 0;
            int b = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & move) == 1) {
                    a = a ^ nums[i];
                } else {
                    b = b ^ nums[i];
                }
            }
            ans[0] = a;
            ans[1] = b;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S56_I_ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();

    }
}