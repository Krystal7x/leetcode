package sort.Insertion_Sort;

import java.util.Arrays;

/**
 * Created by k on 2018/9/5.
 */
public class LKK_ShellSort {
    public static void main(String[] args) {
        int[] data = new int[] { 26, 53, 67, 48, 57, 13, 48, 32, 60, 50 };
        LKK_ShellSort.shellincrement(data);
        System.out.println(Arrays.toString(data));
    }


    private static void shellincrement(int[] data) {
        for(int increment =data.length/2;increment>0;increment=increment/2) {
            LKK_ShellSort.shellSortSmallToBig(data,increment);
        }
    }
    private static void shellSortSmallToBig(int[] data,int increment) {

            for(int i = increment; i < data.length; i++){
                if(data[i]>data[i-increment]){
                    int temp = data[i];
                    int j = i-increment;
                    for ( j = i-increment;j>=0&&data[j]<temp;j=j-increment){
                        data[j+increment]=data[j];
                    }
                    data[j+increment]=temp;
                }
            }
    }
}
