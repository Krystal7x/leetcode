package leetcode.k;

/**
 * @auther k
 * @date 2019/6/16 下午2:20
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */

public class L26RemoveDuplicatesInSortedArray {

    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0){
            return  0;
        }
        if (nums.length < 2){
            return  1;
        }
        int length = nums.length - 1;
        for (int i = 1;i <= length; i++){
            if(nums[i-1] == nums[i]){
                if(nums[i-1] == nums[length]){
                    return i;
                }else {
                    for (int j = i; j < length; j++) {
                        nums[j] = nums[j + 1];
                    }
                    //数组同一个位置再进行一次判断
                    i--;
                }
            }
        }
        int result = 0;
        for(int i = 1;i <= length; i++){
            result = i+1;
            if(nums[i-1] >= nums[i]){
               break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        L26RemoveDuplicatesInSortedArray a = new L26RemoveDuplicatesInSortedArray();
        System.out.println(a.removeDuplicates(nums));
        for(int i : nums){
            System.out.println(i);
        }


    }

}
