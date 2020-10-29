package sort.Swap_Sort;

/**
 * 基本思想：
 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
 * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 * <p>
 * 所以冒泡排序是一种稳定排序算法!!!!!
 */
public class Bubble_Sort {
    public static void BubbleSort(int[] arry) {
        for (int i = 0; i < arry.length - 1; i++) {
            for (int j = 0; j < arry.length - 1 - i; j++) {
                //比较相邻的两个元素，如果前面的比后面的大，则交换位置
                if (arry[j] > arry[j + 1]) {
                    int temp = arry[j + 1];
                    arry[j + 1] = arry[j];
                    arry[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arry = new int[]{34, 1, 221, 50, 44, 58, 12};
        Bubble_Sort.BubbleSort(arry);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }

}
