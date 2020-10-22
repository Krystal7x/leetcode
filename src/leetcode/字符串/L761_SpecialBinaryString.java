package leetcode.字符串;

//特殊的二进制序列是具有以下两个性质的二进制序列： 
//
// 
// 0 的数量与 1 的数量相等。 
// 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。 
// 
//
// 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一
//个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。) 
//
// 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？ 
//
// 示例 1: 
//
// 
//输入: S = "11011000"
//输出: "11100100"
//解释:
//将子串 "10" （在S[1]出现） 和 "1100" （在S[3]出现）进行交换。
//这是在进行若干次操作后按字典序排列最大的结果。
// 
//
// 说明: 
//
// 
// S 的长度不超过 50。 
// S 保证为一个满足上述定义的特殊 的二进制序列。 
// 
// Related Topics 递归 字符串 
// 👍 47 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L761_SpecialBinaryString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 把这个题目比作合法的括弧对，我们可以把‘1’映射到‘(’，把'0'映射到'0'，
         * 这样一组合法的括弧对其实也就意味着一串合法的special string：
         * 1）合法的括弧堆中，‘(’和')‘的个数一定是相同的；
         * 2）合法括弧对的任意一个前缀中，'('的出现次数都不会少于')'。
         * <p>
         * 如果在一个串中，我们定义所有没有嵌套关系的括弧对都属于同一级，而在一个括弧对之内的同级括弧对都更低一级，
         * 那么通过观察可知，在同一级括弧对中，嵌套越深的括弧对越需要靠前，
         * 因此我们的解法就是：首先将同级的括弧对都找出来，并且分别递归处理，递归调用LargestSpecialString，
         * 然后将这些括弧对再进行降序排列，结果就是LargestSpecialString对应的括弧对。
         * <p>
         * 示例中给出的11011000就相当于(()(()))。我们在本级它只有一个括弧对，而它的下一级则有两个，即()和(())，
         * 显然第二个嵌套更深，所以两个更换位置，形成(())()，再加上原来最外层的括弧对，就形成了((())())，
         * 这不就对应着11011000的最终结果11100100吗？
         *
         * @param s
         * @return
         */
        public String makeLargestSpecial(String s) {
            if (s.length() == 0) return s;
            int cnt = 0;
            int left = 0;
            List<String> sortList = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1') cnt++;
                else cnt--;
                //当cnt为0时，说明找到了一个特殊序列，且以1开头，0结尾
                if (cnt == 0) {
                    //递归处理子问题
                    sortList.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
            sortList.sort(Collections.reverseOrder());
            return String.join("", sortList);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L761_SpecialBinaryString().new Solution();

    }
}