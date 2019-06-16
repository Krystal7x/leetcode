package one;

/**
 * @auther k
 * @date 2019/6/16 下午3:30
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */

public class S27RemoveElementInArr {
    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0){
            return  0;
        }
        if (nums.length < 2){
            if(nums[0] == val){return 0;}
            return  1;
        }
        int length = nums.length;
        for (int i = 0;i < length; i++){
            if(nums[i] == val){
                for (int j = length-1; j > i; j--) {
                    if(nums[j] != val){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }
        int result = 0;
        for(int i = 0;i < length; i++){
            if(nums[i] != val){
                result++;
            }
        }
        return result;
    }
}
