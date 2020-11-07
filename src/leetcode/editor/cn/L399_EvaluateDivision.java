package leetcode.editor.cn;

//给出方程式 A / B = k, 其中 A 和 B 均为用字符串表示的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，
//则返回 -1.0。 
//
// 输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"
//],["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//给定：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//返回：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], que
//ries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["
//a","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= equations[i][0].length, equations[i][1].length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= queries[i][0].length, queries[i][1].length <= 5 
// equations[i][0], equations[i][1], queries[i][0], queries[i][1] 由小写英文字母与数字组成 
// 
// Related Topics 并查集 图 
// 👍 252 👎 0


import java.util.List;

//L399、除法求值 ----
public class L399_EvaluateDivision{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    
	public static void main(String[] args) {
		Solution solution = new L399_EvaluateDivision().new Solution();
		
	}
}