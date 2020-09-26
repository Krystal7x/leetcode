package leetcode.数据结构.数组;

//给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。 
//
// 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。 
//
// 在完成所有删除操作后，请你返回列表中剩余区间的数目。 
//
// 
//
// 示例： 
//
// 
//输入：intervals = [[1,4],[3,6],[2,8]]
//输出：2
//解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 1000 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// 对于所有的 i != j：intervals[i] != intervals[j] 
// 
// Related Topics Line Sweep 
// 👍 14 👎 0


import java.util.Arrays;

public class L1288_RemoveCoveredIntervals {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int removeCoveredIntervals(int[][] intervals) {
            if (intervals == null || intervals.length == 0) return 0;
            Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
            int start = intervals[0][0];
            int end = intervals[0][1];
            int count = 1;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= start && intervals[i][1] <= end) {
                    continue;
                }
                if (intervals[i][0] <= end && intervals[i][1] >= end) {
                    end = intervals[i][1];
                }
                if (intervals[i][0] > end) {
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
                count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L1288_RemoveCoveredIntervals().new Solution();

    }
}