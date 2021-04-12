package hot100;

//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 669 👎 0


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//L56、合并区间 ----
public class L56_MergeIntervals {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> ans = new LinkedList<>();
            if (intervals.length <= 1) return intervals;
            Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
            int left = intervals[0][0];
            int right = intervals[0][1];

            for (int i = 1; i <= intervals.length; i++) {
                //到最后了
                if (i == intervals.length) {
                    int[] gap = new int[2];
                    gap[0] = left;
                    gap[1] = right;
                    ans.add(gap);
                    continue;
                }
                //1、开始节点一样，可以直接跳过
                if (intervals[i][0] == left) {
                    continue;
                }
                //2、完全在中间，可以直接跳过
                if (intervals[i][0] > left && intervals[i][1] <= right) {
                    continue;
                }
                //3、交叉，延长right
                if (intervals[i][0] > left && intervals[i][0] <= right && intervals[i][1] > right) {
                    right = intervals[i][1];
                    continue;
                }
                //3、
                if (intervals[i][0] > right) {
                    int[] gap = new int[2];
                    gap[0] = left;
                    gap[1] = right;
                    ans.add(gap);
                    left = intervals[i][0];
                    right = intervals[i][1];
                    continue;
                }

            }
            return ans.toArray(new int[ans.size()][]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L56_MergeIntervals().new Solution();

    }
}