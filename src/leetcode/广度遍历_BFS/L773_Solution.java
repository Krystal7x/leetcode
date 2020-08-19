package leetcode.广度遍历_BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 描述:滑动拼图问题
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * <p>
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * @author luokui
 * @create 2020-08-19 16:45
 */
public class L773_Solution {
    int slidingPuzzle(int[][] board) {
        StringBuilder startBuilder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                startBuilder.append((char) (board[i][j] + '0'));
            }
        }
        String start = startBuilder.toString();
        String target = "123450";
        int[][] neighbor = {
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}
        };
        Queue<String> q = new LinkedList();
        Set<String> visited = new HashSet<>();
        int step = 0;
        q.add(start);
        while (!q.isEmpty()) {

            int size = q.size();
            for (int k = 0; k < size; k++) {
                String s = q.poll();
                if (target.equals(s)) {
                    return step;
                }
                visited.add(s);
                int index = findZero(s);
                for (int i = 0; i < neighbor[index].length; i++) {
                    String ss = swap(s, index, neighbor[index][i]);
                    if (!visited.contains(ss)) {
                        q.add(ss);
                    }
                }
            }
            step++;
        }
        return step;

    }


    int findZero(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0')
                return i;
        }
        return -1;
    }

    String swap(String s, int index, int i) {
        char[] chars = s.toCharArray();
        char temp = chars[index];
        chars[index] = chars[i];
        chars[i] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(new L773_Solution().slidingPuzzle(a));
    }
}
