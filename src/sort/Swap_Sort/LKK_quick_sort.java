package sort.Swap_Sort;

/**
 * Created by k on 2018/9/5.
 */
public class LKK_quick_sort {

    public static void main(String[] args) {
        int[] arry = new int[] { 1,1,1,21,34,11,111,2,50,32,89,4,123,251,4,3};
        LKK_quick_sort.QuickSort(arry,0,arry.length-1);
        for (int i = 0; i < arry.length; i++){
            System.out.println(arry[i]);
        }
    }

    public static void QuickSort(int[] arry, int start, int end) {
     if(start<end){
         int i=start-1;
         int j=end+1;
         int middle=arry[(i+j)/2];
         while(true){
             while(i<end&&arry[++i]>middle);
             while(j>start&&arry[--j]<middle);
             if(i>j)break;
             int temp= arry[i];
             arry[i]=arry[j];
             arry[j]=temp;
         }
         QuickSort(arry, start, i-1);
         QuickSort(arry, j+1,end);
     }
    }
}
