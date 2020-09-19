package leetcode.动态规划;

//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角
//移动到右下角的路径。 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//解释: 
//输入中标粗的位置即为输出表示的路径，即
//0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角） 
//
// 说明：r 和 c 的值均不超过 100。 
// Related Topics 动态规划 
// 👍 31 👎 0


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class interview0802_RobotInAGridLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 63题,递归需要加上visit，不然超时
         *
         * @param obstacleGrid
         * @return
         */
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            List<List<Integer>> ans = new LinkedList<>();
            List<List<Integer>> list = new LinkedList<>();
            if (obstacleGrid[0][0] == 1) {
                return ans;
            }
            if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
                return ans;
            }
            int length = obstacleGrid.length;
            int width = obstacleGrid[0].length;
            boolean[][] visit = new boolean[length][width];

            pathWithObstacles(obstacleGrid, visit, 0, 0, list, ans);
            return ans;

        }

        public void pathWithObstacles(int[][] obstacleGrid, boolean[][] visit, int x, int y, List<List<Integer>> list, List<List<Integer>> ans) {
            if (!ans.isEmpty()) return;
            if (x >= visit.length) return;
            if (y >= visit[0].length) return;
            if (obstacleGrid[x][y] == 1) return;
            if (visit[x][y]) return;
            List<Integer> pos = Arrays.asList(x, y);
            list.add(pos);
            visit[x][y] = true;
            if (x == visit.length - 1 && y == visit[0].length - 1) {
                ans.addAll(list);
                return;
            }
            pathWithObstacles(obstacleGrid, visit, x + 1, y, list, ans);
            list.remove(list.size() - 1);

            list.add(pos);
            if (x == visit.length - 1 && y == visit[0].length - 1) {
                ans.addAll(list);
                return;
            }
            pathWithObstacles(obstacleGrid, visit, x, y + 1, list, ans);
            list.remove(list.size() - 1);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview0802_RobotInAGridLcci().new Solution();

    }
}