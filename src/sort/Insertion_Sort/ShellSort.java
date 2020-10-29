package sort.Insertion_Sort;

import java.util.Arrays;

/**
 * 插入排序—希尔排序
 * 我们简单处理增量序列：增量序列d = {n/2 ,n/4, n/8 .....1} n为要排序数的个数
 * 即：先将要排序的一组记录按某个增量d（n/2,n为要排序数的个数）分成若干组子序列，
 * 每组中记录的下标相差d.对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。
 * 继续不断缩小增量直至为1，最后使用直接插入排序完成排序。
 * 希尔排序是非稳定排序算法!!!!!
 */
public class ShellSort {
    public static void shellSortSmallToBig(int[] data) {
        int j = 0;
        int temp = 0;
        //表示增量
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            //两层循环真正开始
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
        shellSortSmallToBig(data);
        System.out.println(Arrays.toString(data));
    }
}
