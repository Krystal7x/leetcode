package sort.Swap_Sort;

/**
 * Created by k on 2018/9/19.
 */
public class LKK_quick_sort2 {

    public static void QuickSort2(int[] arr,int low,int high) {
        if(low<high) {
            int privot = arr[low];
            int i = low;
            int j = high;
            while (i < j) {
                while (j > i && arr[j] <= privot) {
                    j--;
                }
                arr[i] = arr[j];
                while (j > i && arr[i] >= privot) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i]=privot;
            QuickSort2(arr,low,i-1);
            QuickSort2(arr,j+1,high);
        }


    }



    public static void main(String[] args) {
        int[] arry = new int[] {32,89,4,123,251,4,3};
        QuickSort2(arry,0,arry.length-1);
        for (int i = 0; i < arry.length; i++){
            System.out.println(arry[i]);
        }
    }
}
