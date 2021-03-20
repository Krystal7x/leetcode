package hot100;

//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 563 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//L739、每日温度 ----
public class L739_DailyTemperatures {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            if (T.length == 0) return new int[0];
            int[] ans = new int[T.length];
            //数字，位置
            Map<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            //写入最后一位
            map.put(T[T.length - 1], T.length - 1);
            stack.push(T[T.length - 1]);

            for (int i = T.length - 2; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= T[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = 0;
                } else {
                    ans[i] = map.get(stack.peek()) - i;
                }
                map.put(T[i], i);
                stack.push(T[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L739_DailyTemperatures().new Solution();

    }
}