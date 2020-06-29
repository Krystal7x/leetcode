package leetcode.数据结构.队列;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 *
 * @author luokui
 * @create 2020-06-23 15:49
 */
public class L239_Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        DullList dullList = new DullList();
        for (int i = 0; i < length; i++) {
            if (i < k - 1) {
                dullList.push(nums[i]);
            } else {
                dullList.push(nums[i]);
                ans[i - k + 1] = dullList.max();
                dullList.pop(nums[i - k + 1]);
            }
        }
        return ans;
    }

    class DullList {
        LinkedList<Integer> list = new LinkedList<>();

        public void push(int n) {
            while (!list.isEmpty() && list.get(list.size() - 1) < n) {
                list.remove(list.size() - 1);
            }
            list.add(n);
        }

        public void pop(int n) {
            if (!list.isEmpty() && list.get(0) == n) {
                list.remove(0);
            }

        }

        public int max() {
            return list.get(0);
        }

    }
}
