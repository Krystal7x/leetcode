package leetcode.技巧类.双指针;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther k
 * @date 2019/6/4 下午5:01
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 */
public class L1TwoSum {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int m=target-nums[i];
           if(map.containsKey(m)&&map.get(m)!=i){
            return new int[]{i, map.get(m) };
           }
        }
        return null;
    }
}
