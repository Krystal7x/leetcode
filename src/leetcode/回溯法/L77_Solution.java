package leetcode.回溯法;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @author luokui
 * @create 2020-06-29 17:49
 */
public class L77_Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) {
            ans.add(new LinkedList<Integer>());
            return ans;
        }
        combine(n, k, 1, new LinkedList<>());
        return ans;

    }

    public void combine(int n, int k, int start, List<Integer> stack) {
        if (stack.size() == k) {
            ans.add(new LinkedList<>(stack));
            return;
        }
        for (int i = start; i <= n; i++) {
            stack.add(i);
            combine(n, k, start + 1, stack);
            stack.remove(stack.size() - 1);
        }

    }
}
