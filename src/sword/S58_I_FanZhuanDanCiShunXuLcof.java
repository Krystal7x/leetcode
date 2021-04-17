package sword;

//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//则输出"student. a am I"。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/ 
//
//
// 注意：此题对比原题有改动 
// Related Topics 字符串 
// 👍 43 👎 0


public class S58_I_FanZhuanDanCiShunXuLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseWords(String s) {
            char[] chars = s.toCharArray();

            reverse(chars, 0, s.length() - 1);

            int i1 = 0, i2 = 0;
            //反转每一个单词
            while (i1 < chars.length) {
                if (chars[i1] == ' ') {
                    i1++;
                    i2++;
                    continue;
                }
                while (chars[i2] != ' ') {
                    i2++;
                    if (i2 >= chars.length) break;
                }
                reverse(chars, i1, i2 - 1);
                i1 = i2;

            }

            //去除空格
            char[] ans = new char[chars.length];
            int l1 = 0, l2 = 0;
            while (l1 < chars.length) {
                if (chars[l1] == ' ') {
                    l1++;
                    continue;
                }
                while (chars[l1] != ' ') {
                    ans[l2++] = chars[l1++];
                    if (l1 >= chars.length) break;
                }
                if (l2 < ans.length) {
                    ans[l2++] = ' ';
                }
            }
            return new String(ans).trim();
        }

        private void reverse(char[] chars, int left, int right) {
            while (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S58_I_FanZhuanDanCiShunXuLcof().new Solution();

    }
}