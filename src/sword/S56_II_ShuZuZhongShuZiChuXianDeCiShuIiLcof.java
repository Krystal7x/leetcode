package sword;

//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 93 👎 0


public class S56_II_ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int singleNumber(int[] nums) {
            if (nums.length == 0) return -1;
            int[] bitSum = new int[32];
            for (int num : nums) {
                int bitMask = 1;
                for (int i = 31; i >= 0; i--) {
                    //bitSum[0]为符号位
                    if ((num & bitMask) != 0) bitSum[i]++;
                    bitMask = bitMask << 1;
                }
            }
            int res = 0;
            //这个看看
            for (int i = 0; i < 32; i++) {
                res = res << 1;
                res += bitSum[i] % 3;
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S56_II_ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        System.out.println(solution.singleNumber(new int[]{3, 3, 4, 3}));

    }
}