package one;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther k
 * @date 2019/6/4 下午5:01
 */
//题目：两数之和
public class S1TwoSum {


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
