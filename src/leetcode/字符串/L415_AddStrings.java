package leetcode.字符串;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 273 👎 0


public class L415_AddStrings {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            char[] numArr1 = getArr(num1, Math.max(num1.length(), num2.length()));
            char[] numArr2 = getArr(num2, Math.max(num1.length(), num2.length()));
            int[] ans = new int[Math.max(num1.length(), num2.length()) + 1];
            for (int i = 0; i < ans.length - 1; i++) {
                int n = (ans[i] + numArr1[i] - '0' + numArr2[i] - '0');
                ans[i] = n % 10;
                ans[i + 1] = n / 10;
            }
            int index = ans.length - 1;
            if (ans[ans.length - 1] == 0) index--;
            StringBuilder res = new StringBuilder();
            for (; index >= 0; index--) {
                res.append(ans[index]);
            }
            return res.toString();
        }

        char[] getArr(String s, int length) {
            char[] arr = new char[length];
            char[] numArr1 = new StringBuilder(s).reverse().toString().toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (i < numArr1.length) {
                    arr[i] = numArr1[i];
                } else {
                    arr[i] = '0';
                }
            }
            return arr;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L415_AddStrings().new Solution();

    }
}