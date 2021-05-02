package toppick;

//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 694 👎 0


import java.util.Arrays;

//L179、最大数 ----
public class L179_LargestNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            if (nums.length == 0) return "";
            String[] strs = new String[nums.length];
            int tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) tmp++;
                strs[i] = String.valueOf(nums[i]);
            }
            if (tmp == nums.length) return "0";

            Arrays.sort(strs, (o1, o2) -> {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                sb.append(strs[i]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L179_LargestNumber().new Solution();
        System.out.println(solution.largestNumber(new int[]{3, 30, 34, 5, 9}));

    }
}