package leetcode.技巧类.双指针;

/**
 * 描述:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author luokui
 * @create 2020-08-21 16:01
 */
public class L42_Solution {


    /**
     * 双指针
     *
     * @param height
     * @return
     */
    int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int l_max = height[left];
        int r_max = height[right];
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            if (l_max < r_max) {
                ans += l_max - height[left];
                left++;
            } else {
                ans += r_max - height[right];
                right--;
            }
        }
        return ans;
    }


    /**
     * 数组
     *
     * @param height
     * @return
     */
    int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int[] l_max = new int[height.length];
        int[] r_max = new int[height.length];
        l_max[0] = height[0];
        r_max[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            ans = ans + Math.max(l_max[i], r_max[i]);
        }
        return ans;
    }
}
