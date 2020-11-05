package hot100;

//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1] 
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？ 
//
// 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 1 <= numCourses <= 10^5 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 617 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//L207、课程表 ----
public class L207_CourseSchedule {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * BFS
         *
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] depend = new int[numCourses];
            List<List<Integer>> adjacency = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                adjacency.add(new ArrayList<>());
            }
            for (int[] cp : prerequisites) {
                //依赖度
                depend[cp[0]]++;
                //key完成后，那些value可完成
                adjacency.get(cp[1]).add(cp[0]);
            }
            //找到依赖度为0的
            for (int i = 0; i < numCourses; i++) {
                if (depend[i] == 0) queue.add(i);
            }
            // BFS TopSort.
            while (!queue.isEmpty()) {
                int pre = queue.poll();
                numCourses--;
                for (int cur : adjacency.get(pre))
                    if (--depend[cur] == 0) queue.add(cur);
            }
            return numCourses == 0;
        }

        /**
         * DFS
         *
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public boolean canFinish2(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjacency = new ArrayList<>();
            for (int i = 0; i < numCourses; i++)
                adjacency.add(new ArrayList<>());
            int[] flags = new int[numCourses];
            for (int[] cp : prerequisites)
                adjacency.get(cp[1]).add(cp[0]);
            for (int i = 0; i < numCourses; i++)
                if (!dfs(adjacency, flags, i)) return false;
            return true;
        }

        private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
            if (flags[i] == 1) return false;
            if (flags[i] == -1) return true;
            flags[i] = 1;
            for (Integer j : adjacency.get(i))
                if (!dfs(adjacency, flags, j)) return false;
            flags[i] = -1;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L207_CourseSchedule().new Solution();
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));

    }
}