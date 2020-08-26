package leetcode.数据结构.数组;

/**
 * 描述:
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 * @author luokui
 * @create 2020-05-26 20:33
 */
public class interview1604 {

    public String tictactoe(String[] board) {
        String result = "";
        int N = board.length;
        //空格数量
        int blank = 0;
        int[] mapX = new int[2 * N + 2];
        int[] mapO = new int[2 * N + 2];

        for (int i = 0; i < N; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < N; j++) {
                int x = i;
                int y = N + j;
                Character c = chars[j];
                if (chars[j] != ' ') {
                    if (c == 'X') {
                        mapX[x]++;
                        if (mapX[x] == N) return c.toString();
                        mapX[y]++;
                        if (mapX[y] == N) return c.toString();
                        if (i == j) {
                            mapX[2 * N]++;
                            if (mapX[2 * N] == N) return c.toString();
                        }
                        if ((i + j) == (N - 1)) {
                            mapX[2 * N + 1]++;
                            if (mapX[2 * N + 1] == N) return c.toString();
                        }
                    }
                    if (c == 'O') {
                        mapO[x]++;
                        if (mapO[x] == N) return c.toString();
                        mapO[y]++;
                        if (mapO[y] == N) return c.toString();
                        if (i == j) {
                            mapO[2 * N]++;
                            if (mapO[2 * N] == N) return c.toString();
                        }
                        if ((i + j) == (N - 1)) {
                            mapO[2 * N + 1]++;
                            if (mapO[2 * N + 1] == N) return c.toString();
                        }
                    }
                } else {
                    blank++;
                }


            }

        }
        if (blank == 0) {
            return "Draw";
        }
        return "Pending";
    }
}
