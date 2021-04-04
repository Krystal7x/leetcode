package leetcode.深度遍历_DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * @author luokui
 * @create 2020-07-18 17:25
 */
public class L51_Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<>();
        if (n <= 0) {
            return ans;
        }
        String[][] dp = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = ".";
            }
        }
        choose(dp, 0, ans);
        return ans;
    }

    public void choose(String[][] dp, int row, List<List<String>> ans) {
        int n = dp.length;
        if (row == n) {
            result(dp, ans);
            return;
        }
        for (int col = 0; col < n; col++) {
            dp[row][col] = "Q";
            if (isValid(dp, row, col)) {
                choose(dp, row + 1, ans);
            }
            dp[row][col] = ".";
        }

    }

    public boolean isValid(String[][] dp, int row, int col) {
        int n = dp.length;
        for (int i = row + 1; i < n; i++) {
            if (dp[i][col].equals("Q")) return false;
        }
        for (int i = row - 1; i >= 0; i--) {
            if (dp[i][col].equals("Q")) return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (dp[i][j].equals("Q")) return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (dp[i][j].equals("Q")) return false;
        }

        return true;

    }

    public void result(String[][] dp, List<List<String>> ans) {
        int n = dp.length;
        List<String> one = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(dp[i][j]);
            }
            one.add(s.toString());
        }
        ans.add(one);
    }

    public static void main(String[] args) {
        L51_Solution n = new L51_Solution();
        n.solveNQueens(4);
    }

}
