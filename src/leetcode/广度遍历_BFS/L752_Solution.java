package leetcode.广度遍历_BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 描述:密码锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * @author luokui
 * @create 2020-08-19 15:56
 */
public class L752_Solution {
    int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList();
        Set<String> dead = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        q.add("0000");
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (target.equals(s)) {
                    return ans;
                }
                if (visited.contains(s)) {
                    continue;
                }
                visited.add(s);
                for (int j = 0; j < 4; j++) {
                    String up = up(s, j);
                    if (!dead.contains(s)) {
                        q.add(up);
                    }
                    String down = down(s, j);
                    if (!dead.contains(s)) {
                        q.add(down);
                    }

                }


            }
            ans++;
        }

        return -1;
    }


    String up(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index]++;
        }
        return new String(chars);
    }

    String down(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index]--;
        }
        return new String(chars);
    }

}
