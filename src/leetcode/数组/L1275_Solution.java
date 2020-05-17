package leetcode.数组;

/**
 * A 和 B 在一个 3 x 3 的网格上玩井字棋。
 * <p>
 * 井字棋游戏的规则如下：
 * <p>
 * 玩家轮流将棋子放在空方格 (" ") 上。
 * 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
 * "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
 * 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
 * 如果所有方块都放满棋子（不为空），游戏也会结束。
 * 游戏结束后，棋子无法再进行任何移动。
 * 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
 * <p>
 * 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
 *
 * @author k
 * @date 2020-05-17 14:14
 */

public class L1275_Solution {

    public String tictactoe(int[][] moves) {
        int a = 0, b = 0, len = moves.length;
        // ac records all cases of winning
        int[] ac = {7, 56, 448, 73, 146, 292, 273, 84};

        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                //用位记录每步的走法
                a = a ^ 1 << 3 * moves[i][0] + moves[i][1];

            } else {
                b = b ^ 1 << 3 * moves[i][0] + moves[i][1];
            }
        }
        //直接和预测的结果与一下，看哪一位相符
        for (int r : ac) {
            if ((a & r) == r) {
                return "A";
            }
            if ((b & r) == r) {
                return "B";
            }
        }
        //都不符合，则看其他
        if (moves.length == 9) {
            return "Draw";
        }

        return "Pending";
    }

}
