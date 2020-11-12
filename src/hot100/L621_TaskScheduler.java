package hot100;

//给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务
//都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。 
//
// 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的最短时间。 
//
// 
//
// 示例 ： 
//
// 输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 
//
// 提示： 
//
// 
// 任务的总个数为 [1, 10000]。 
// n 的取值范围为 [0, 100]。 
// 
// Related Topics 贪心算法 队列 数组 
// 👍 418 👎 0


import java.util.Arrays;

//L621、任务调度器 ----
public class L621_TaskScheduler {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 这题带给我的理解 就是 很多时候不用去记录
        // 比如 ABC 不用记录 ABC 给他们排序保存， 只需要 用过 或者使用 计数器这些东西足够

        /**
         * [A,A,A,A,B,B,C]  -> [A:3, B:2,C:1] -> [0.....,1,2,3]  n=2 的情况，
         * 然后使用每次的 n + 1 个任务 比如 A B C 这时候再执行 A 正好不需要冷却。
         * 如果是 A B （等待） A 就需要冷却
         */

        public int leastInterval(char[] tasks, int n) {

            int[] map = new int[26];
            // 将 task 字符转入 map 中存储
            for (char c : tasks)
                map[c - 'A']++;   // 转换使用数字存储
            // 然后定义一个数字 记录全局时间。
            int time = 0;
            Arrays.sort(map);  // 排序 [0.....1,2,3]

            while (map[25] > 0) {
                int i = 0; // 记录 n 的轮次 是否满足了
                while (i <= n) { // 这里 要 <= n 这样 才能 n+1 轮次
                    // 首先要判断下 最大轮次是否已经走完
                    if (map[25] == 0)
                        break;
                    if (i < 26 && map[25 - i] > 0)
                        map[25 - i]--;  // 走轮次
                    time++;
                    i++;
                }
                Arrays.sort(map);  // 再重新排序 看是否最大的已经走完 [A:3,B:3,C:2]  A 可能会先走完
            }

            return time;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L621_TaskScheduler().new Solution();

    }
}