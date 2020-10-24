package sort.Insertion_Sort;

/**
 * Created by k on 2018/9/5.
 */
public class LKK_Straight_Insertion_Sort {

    public static void main(String[] args) {
        int[] arry = new int[] { 34,1,221,50,44,58,12,12,2,33,4};
       LKK_Straight_Insertion_Sort.LKK_InsertSort(arry);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }

    private static void LKK_InsertSort(int[] array) {
      for(int i=1;i<array.length;i++){
          if(array[i]<array[i-1]){
              int temp =array[i];
              int j=i-1;
              for(j=i-1;j>=0&&array[j]>temp;j--){
                  array[j+1]=array[j];
              }
              array[j+1]=temp;
          }

      }
    }
}
