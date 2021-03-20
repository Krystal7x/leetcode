package hot100;

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


import java.util.HashMap;
import java.util.List;
import java.util.Map;

//L399、除法求值 ----
public class L399_EvaluateDivision {

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        Map<String, String> parents;
        Map<String, Double> val;

        /**
         * 压缩路径
         * 重点
         */
        public String find(String x) {

            if (!x.equals(parents.get(x))) {
                String tmpParent = parents.get(x);
                String root = find(tmpParent);
                double oldVal = val.get(x);
                val.put(x, oldVal * val.get(tmpParent));
                parents.put(x, root);
            }
            return parents.get(x);
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            parents = new HashMap<>();
            val = new HashMap<>();
            //1、构造并查集
            int i = 0;
            for (List<String> equation : equations) {
                String from = equation.get(0);
                String to = equation.get(1);
                double cur = values[i];
                if (!parents.containsKey(from) && !parents.containsKey(to)) {
                    parents.put(from, to);
                    val.put(from, cur);
                    parents.put(to, to);
                    val.put(to, 1.0);
                } else if (!parents.containsKey(from)) {
                    parents.put(from, to);
                    val.put(from, cur);
                } else if (!parents.containsKey(to)) {
                    parents.put(to, from);
                    val.put(to, 1 / cur);
                } else {
                    String pa = find(from);
                    String pb = find(to);
                    if (!pa.equals(pb)) {
                        parents.put(pa, pb);
                        val.put(pa, cur * val.get(to) / val.get(from));
                    }
                }
                i++;
            }
            //找出相当于与根节点的比值
            i = 0;
            double[] res = new double[queries.size()];
            for (List<String> query : queries) {
                String from = query.get(0);
                String to = query.get(1);
                if (!parents.containsKey(from) || !parents.containsKey(to)) {
                    res[i++] = -1;
                    continue;
                }
                String pa = find(from);
                String pb = find(to);
                if (!pa.equals(pb)){res[i] = -1;}
                else {
                    res[i] = val.get(from) / val.get(to);
                }
                i++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L399_EvaluateDivision().new Solution();

    }
}