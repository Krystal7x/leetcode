package sword;

//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 109 👎 0


import java.util.Arrays;

public class S45_BaShuZuPaiChengZuiXiaoDeShuLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String minNumber(int[] nums) {
            String[] str = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                str[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(str, (o1, o2) -> {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                if (minString(s1, s2)) {
                    return -1;
                } else {
                    return 1;
                }
            });
            StringBuilder sb = new StringBuilder();
            for (String s : str) {
                sb.append(s);
            }
            return sb.toString();

        }


        /**
         * stack 小 返回 true
         *
         * @param s2
         * @return
         */
        private boolean minString(String s1, String s2) {
            char[] c1 = s1.toCharArray();
            int i1 = 0;
            char[] c2 = s2.toCharArray();
            int i2 = 0;

            while (i1 < c1.length && i2 < c2.length) {
                if (c1[i1] == c2[i2]) {
                    i1++;
                    i2++;
                    continue;
                }
                if (c1[i1] > c2[i2]) {
                    return false;

                }
                if (c1[i1] < c2[i2]) {
                    return true;
                }
            }
            if (i1 == c1.length) {
                return true;
            } else {
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S45_BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();

    }
}