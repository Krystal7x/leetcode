package sword;

/**
 * @auther k
 * @date 2019-06-30 11:08
 * <p>
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 解题思路
 * 采用二分查找法。
 * 需要考虑三种情况：
 * <p>
 * array[mid] > array[high]:
 * 出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
 * low = mid + 1
 * array[mid] == array[high]:
 * 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
 * 还是右边,这时只好一个一个试
 * high = high - 1
 * array[mid] < array[high]:
 * 出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
 * 边。因为右边必然都是递增的。
 * high = mid
 */

public class S8RotateArray {
    /**
     * 题目可以简化为：寻找一个非递减数组中的最小值：
     * 方法用二分
     * @param array
     * @return
     */

    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        int low = 0, high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }
        return array[low];
    }

}
