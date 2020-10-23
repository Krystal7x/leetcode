package sword;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 172 👎 0


public class S13_JiQiRenDeYunDongFanWeiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            if (m <= 0 || n <= 0) return 0;
            int ans;
            boolean[][] visited = new boolean[m][n];
            ans = movingCount(visited, 0, 0, k);
            return ans;

        }

        private int movingCount(boolean[][] visited, int x, int y, int k) {
            if (x < 0 || y < 0 || x > visited.length - 1 || y > visited[0].length - 1) return 0;
            if (visited[x][y]) return 0;
            if (!canEnter(x, y, k)) return 0;
            int ans = 0;
            visited[x][y] = true;
            ans += 1 + movingCount(visited, x - 1, y, k)
                    + movingCount(visited, x + 1, y, k)
                    + movingCount(visited, x, y - 1, k)
                    + movingCount(visited, x, y + 1, k);
            return ans;
        }

        boolean canEnter(int x, int y, int k) {
            int count = 0;
            while (x > 0) {
                count += x % 10;
                x = x / 10;
            }
            while (y > 0) {
                count += y % 10;
                y = y / 10;
            }
            return count <= k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S13_JiQiRenDeYunDongFanWeiLcof().new Solution();

    }
}