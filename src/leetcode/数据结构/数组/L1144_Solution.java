package leetcode.数据结构.数组;

/**
 * 描述:
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * <p>
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * <p>
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 *
 * @author luokui
 * @create 2020-05-30 12:54
 */
public class L1144_Solution {

    public int movesToMakeZigzag(int[] nums) {
        // 初始化奇偶数减小量
        int odd = 0;
        int even = 0;
        int len = nums.length;
        int left;
        int right;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                // 奇数成锯齿状时, 看偶数, 取差值+1的最大值
                left = (i > 0) && (nums[i] >= nums[i - 1]) ? (nums[i] - nums[i - 1] + 1) : 0;
                right = (i < (len - 1)) && (nums[i] >= nums[i + 1]) ? (nums[i] - nums[i + 1] + 1) : 0;
                even += Math.max(left, right);
            } else {
                // 偶数成锯齿状时, 看奇数, 取差值+1的最大值
                left = nums[i] >= nums[i - 1] ? (nums[i] - nums[i - 1] + 1) : 0;
                right = (i < (len - 1)) && (nums[i] >= nums[i + 1]) ? (nums[i] - nums[i + 1] + 1) : 0;
                odd += Math.max(left, right);
            }
        }
        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        System.out.println(new L1144_Solution().movesToMakeZigzag(new int[]{2, 7, 10, 9, 8, 9}));
    }
}
