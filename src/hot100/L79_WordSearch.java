package hot100;

//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 664 👎 0


//L79、单词搜索 ---- 
public class L79_WordSearch {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            boolean ans = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        ans = ans || exist(board, visited, i, j, word, 0);
                    }

                }
            }
            return ans;
        }

        private boolean exist(char[][] board, boolean[][] visited, int x, int y, String word, int index) {
            if (index >= word.length()) return true;
            if (x < 0 || x > visited.length - 1) return false;
            if (y < 0 || x > visited[0].length - 1) return false;
            if (board[x][y] != word.charAt(index)) return false;
            if (visited[x][y]) return false;
            boolean ans = false;
            visited[x][y] = true;
            ans = exist(board, visited, x + 1, y, word, index + 1)
                    || exist(board, visited, x - 1, y, word, index + 1)
                    || exist(board, visited, x, y + 1, word, index + 1)
                    || exist(board, visited, x, y - 1, word, index + 1);
            visited[x][y] = false;
            return ans;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L79_WordSearch().new Solution();

    }
}