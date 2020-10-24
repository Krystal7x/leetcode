package sword;

//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 146 👎 0


public class S46_BaShuZiFanYiChengZiFuChuanLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            if (num >= 0 && num <= 9) return 1;
            int length = (int) Math.log10(num) + 1;
            int[] nums = new int[length];
            for (int i = length - 1; i >= 0; i--) {
                nums[i] = num % 10;
                num = num / 10;
            }
            return translateNum(nums, 0, nums.length - 1);
        }

        private int translateNum(int[] nums, int left, int right) {
            int count = 0;
            if (left >= right) return 1;

            //1、1位一定有的
            count += translateNum(nums, left + 1, right);
            //2位数
            if (right - left > 0) {
                int tmp = nums[left] * 10 + nums[left + 1];
                //易错点！！！！ 04 和0 4 是一样的
                if (tmp >= 10 && tmp <= 25) {
                    //2、2位成立
                    count += translateNum(nums, left + 2, right);
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S46_BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        System.out.println(solution.translateNum(0));

    }
}