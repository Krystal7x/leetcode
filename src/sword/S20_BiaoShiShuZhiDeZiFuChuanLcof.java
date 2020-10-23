package sword;

//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 115 👎 0


public class S20_BiaoShiShuZhiDeZiFuChuanLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * leetcode 65
         *
         * @param s
         * @return
         */
        public boolean isNumber(String s) {
            s = s.toLowerCase().trim();
            if (s.length() == 0) return false;
            //正负
            boolean sign = false;
            //数字
            boolean num = false;
            //e
            boolean exp = false;
            //小数点
            boolean dot = false;
            int index = 0;
            char[] chars = s.toCharArray();
            if (chars[0] == '+' || chars[0] == '-') index++;
            while (index < chars.length) {
                char c = chars[index];
                if (c >= '0' && c <= '9') {
                    num = true;
                } else if (c == '.') {
                    //.1和1. 都是合法的
                    if (!exp && !dot) {
                        dot = true;
                    } else {
                        return false;
                    }
                } else if (c == 'e') {
                    if (num && !exp) {
                        exp = true;
                        num = false;
                    } else {
                        return false;
                    }
                } else if (c == '+' || c == '-') {
                    if (index - 1 >= 0 && chars[index - 1] == 'e') {
                        num = false;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
                index++;
            }

            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S20_BiaoShiShuZhiDeZiFuChuanLcof().new Solution();

    }
}