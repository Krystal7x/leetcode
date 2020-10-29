package sort.Swap_Sort;

/**
 * 基本思想：
 * 设要排序的数组是A[0]……A[N-1]，首先任意选取一个数据（通常选用数组的第一个数）作为关键数据，然后将所有比它小的数都放到它前面，所有比它大的数都放到它后面，这个过程称为一趟快速排序。值得注意的是，快速排序不是一种稳定的排序算法，也就是说，多个相同的值的相对位置也许会在算法结束时产生变动。
 * 一趟快速排序的算法是：
 * 1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
 * 2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
 * 3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]互换；
 * 4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换；
 * 5）重复第3、4步，直到i=j； (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i， j指针位置不变。另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）。
 * <p>
 * 快速排序是一个不稳定的排序方法!!!!!
 */
public class Quick_Sort {
    public static void QuickSort(int[] arry, int left, int right) {
        //左边索引小于右边，则还未排序完成 　　
        if (left < right) {
            //取中间的元素作为比较基准，小于他的往左边移，大于他的往右边移 　　
            int middle = arry[(left + right) / 2];
            int i = left - 1;
            int j = right + 1;
            while (true) {
                //移动下标，左边的往右移动，右边的向左移动
                while (arry[++i] < middle && i < right) {
                }
                while (arry[--j] > middle && j > 0) {
                }
                if (i >= j) {
                    break;
                }
                //交换位置
                int number = arry[i];
                arry[i] = arry[j];
                arry[j] = number;
            }
            QuickSort(arry, left, i - 1);
            QuickSort(arry, j + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arry = new int[]{21, 34, 11111, 2, 50};
        Quick_Sort.QuickSort(arry, 0, arry.length - 1);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }

}
