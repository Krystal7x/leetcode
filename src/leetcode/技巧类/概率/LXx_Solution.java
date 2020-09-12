package leetcode.技巧类.概率;

import common.ListNode;

import java.util.Random;

/**
 * 描述:
 *
 * @author luokui
 * @create 2020-08-24 17:04
 */
public class LXx_Solution {
        int[] xipai(int[] nums) {
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (r.nextInt(2) >= 1) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }
}
