package sword;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 46 👎 0


public class S05_TiHuanKongGeLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            int space = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') space++;
            }
            char[] chars = new char[s.length() + space * 2];
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {
                    chars[j++] = s.charAt(i);
                } else {
                    chars[j++] = '%';
                    chars[j++] = '2';
                    chars[j++] = '0';
                }

            }
            return new String(chars);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S05_TiHuanKongGeLcof().new Solution();

    }
}