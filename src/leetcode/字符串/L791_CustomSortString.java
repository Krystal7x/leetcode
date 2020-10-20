package leetcode.字符串;

//字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。 
//
// S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。 
//
// 返回任意一种符合条件的字符串T。 
//
// 
//示例:
//输入:
//S = "cba"
//T = "abcd"
//输出: "cbad"
//解释: 
//S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a". 
//由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
// 
//
// 注意: 
//
// 
// S的最大长度为26，其中没有重复的字符。 
// T的最大长度为200。 
// S和T只包含小写字符。 
// 
// Related Topics 字符串 
// 👍 62 👎 0


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class L791_CustomSortString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String customSortString(String S, String T) {
            Map<Character, Integer> sort = new HashMap<>();
            for (int i = 0; i < S.length(); i++) {
                sort.put(S.charAt(i), i);
            }
            Character[] tmpArr = new Character[T.length()];

            for (int i = 0; i < T.length(); i++) {
                tmpArr[i] = T.charAt(i);
            }
            Arrays.sort(tmpArr, Comparator.comparingInt(a -> sort.getOrDefault(a, 100)));

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < T.length(); i++) {
                sb.append(tmpArr[i]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L791_CustomSortString().new Solution();

    }
}