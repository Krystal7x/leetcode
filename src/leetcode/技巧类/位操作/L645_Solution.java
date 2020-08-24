package leetcode.技巧类.位操作;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，
 * 再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 *
 * @author luokui
 * @create 2020-08-24 11:55
 */
public class L645_Solution {

    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        //重复
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]) - 1;
            if (nums[abs] < 0) {
                ans[0] = Math.abs(nums[i]);
            } else {
                nums[abs] = -nums[abs];
            }
        }
        //缺少的
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[1] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new L645_Solution().findErrorNums(new int[]{1, 2, 2, 4}));
    }
}
