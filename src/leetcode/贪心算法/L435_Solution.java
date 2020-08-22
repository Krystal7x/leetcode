package leetcode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 描述:
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 *
 * @author luokui
 * @create 2020-06-15 16:57
 */
public class L435_Solution {
    int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        int count = intervals.length;
        int sum = 0;
        //结束时间升序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int end = intervals[0][1];
        sum++;
        for (int i = 1; i < count; i++) {
            int[] tmp = intervals[i];
            if (tmp[0] >= end) {
                sum++;
                end = tmp[1];
            }
        }
        return count - sum;
    }
}
