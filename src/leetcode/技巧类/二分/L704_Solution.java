package leetcode.技巧类.二分;

/**
 * 描述:
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * @author luokui
 * @create 2020-07-18 18:16
 */
public class L704_Solution {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }

        }
        return -1;
    }
}
