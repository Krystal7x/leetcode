package leetcode.字符串;

//给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。 
//
// 在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。 
//
// 返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。 
//
// 
//
// 示例 1： 
//
// 输入：S = "cba", K = 1
//输出："acb"
//解释：
//在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
//在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
// 
//
// 示例 2： 
//
// 输入：S = "baaca", K = 3
//输出："aaabc"
//解释：
//在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
//在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= S.length <= 1000 
// S 只由小写字母组成。 
// 
// Related Topics 数学 字符串 
// 👍 41 👎 0


import java.util.Arrays;

public class L899_OrderlyQueue {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 思路：结论题，
         * <p>
         * 1）当K=1时，每次最多只能将当前字符串的首字母加入字符串的尾部，此时我们只需要枚举字符串的断点，并将前半部分拼接在后半部分后比较字典序大小即可。
         * <p>
         * 2）当k>1时，假如K=2，很容易能够证明我们可以做到任意交换两个 相邻位置 的字符。
         * 例如我们需要交换i位置和j位置上的字符，
         * 此时我们可以首先将前i-1个字符按顺序移到串尾，然后我们将i+1位置上的字符移动到串尾，
         * 再将i位置上的字符移动到串尾，此时得到的字符串是：s[i+2],s[i+3],...,s[n],s[1],s[2],...,s[i-1],s[i+1],s[i],
         * 最后将i+1到n位置上的字符移到串尾就得到：s[1],s[2],...,s[i-1],s[i+1],s[i],s[i+2],s[i+3],...,s[n].
         * 可以发现s[i]和s[i+1]位置上的字符发生了互换。
         * <p>
         * 当我们可以任意交换两个相邻位置上的字符时，我们就可以采用冒牌排序的方式给字符串排序。换句话说，当k>1时，直接输出有序字符串即可。
         *
         * @param S
         * @param K
         * @return
         */
        public String orderlyQueue(String S, int K) {
            String ans = S;
            int len = S.length();
            if (K == 1) {
                for (int i = 0; i < len; i++) {
                    String tmp = S.substring(i) + S.substring(0, i);
                    if (tmp.compareTo(ans) < 0)
                        ans = tmp;
                }
                return ans;
            } else {
                char[] c = S.toCharArray();
                Arrays.parallelSort(c);
                return new String(c);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L899_OrderlyQueue().new Solution();

    }
}