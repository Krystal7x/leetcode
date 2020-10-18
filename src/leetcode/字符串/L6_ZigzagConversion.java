package leetcode.字符串;

//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串 
// 👍 869 👎 0


import java.util.LinkedList;
import java.util.List;

public class L6_ZigzagConversion {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;
            int minRow = Math.min(s.length(), numRows);
            List<StringBuilder> list = new LinkedList<>();
            for (int i = 0; i < minRow; i++) {
                list.add(new StringBuilder());
            }
            int index = 0;
            boolean direction = true;
            for (int i = 0; i < s.length(); i++) {
                list.get(index).append(s.charAt(i));
                if (index == minRow - 1) direction = false;
                if (index == 0) direction = true;
                index += direction ? 1 : -1;
            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder item : list) {
                res.append(item);
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L6_ZigzagConversion().new Solution();

    }
}