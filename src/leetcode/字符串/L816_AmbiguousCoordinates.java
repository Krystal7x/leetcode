package leetcode.字符串;

//我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表
//中。 
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数
//来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 
//
// 
//
// 
//示例 1:
//输入: "(123)"
//输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
// 
//
// 
//示例 2:
//输入: "(00011)"
//输出:  ["(0.001, 1)", "(0, 0.011)"]
//解释: 
//0.0, 00, 0001 或 00.01 是不被允许的。
// 
//
// 
//示例 3:
//输入: "(0123)"
//输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 
//3)"]
// 
//
// 
//示例 4:
//输入: "(100)"
//输出: [(10, 0)]
//解释: 
//1.0 是不被允许的。
// 
//
// 
//
// 提示: 
//
// 
// 4 <= S.length <= 12. 
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
// 
//
// 
// Related Topics 字符串 
// 👍 26 👎 0


import java.util.LinkedList;
import java.util.List;

public class L816_AmbiguousCoordinates {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> ambiguousCoordinates(String S) {
            List<String> res = new LinkedList<>();
            String s = S.substring(1, S.length() - 1);
            for (int i = 1; i <= s.length() - 1; i++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i);
                if (s1.length() > 1 && Integer.parseInt(s1) == 0) continue;
                if (s2.length() > 1 && Integer.parseInt(s2) == 0) continue;
                List<String> list1 = effectiveNum(s1);
                List<String> list2 = effectiveNum(s2);
                makeUpResult(list1, list2, res);

            }
            return res;
        }

        private void makeUpResult(List<String> list1, List<String> list2, List<String> res) {
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    res.add("(" + list1.get(i) + ", " + list2.get(j) + ")");
                }
            }

        }

        public List<String> effectiveNum(String s) {
            List<String> res = new LinkedList<>();
            if (s.length() <= 1) {
                res.add(s);
                return res;
            }
            if (s.charAt(0) != '0') {
                res.add(s);
            }
            for (int i = 1; i <= s.length() - 1; i++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i);
                if (s1.length() > 1 && s1.charAt(0) == '0') continue;
                if (Integer.parseInt(s2) == 0) continue;
                if (s2.length() > 1 && s2.charAt(s2.length() - 1) == '0') continue;
                //经纬度需要大小
                String num = s1 + "." + s2;
                res.add(num);
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L816_AmbiguousCoordinates().new Solution();

    }
}