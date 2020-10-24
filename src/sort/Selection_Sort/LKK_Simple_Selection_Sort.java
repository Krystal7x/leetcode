package sort.Selection_Sort;

/**
 * Created by k on 2018/9/5.
 */
public class LKK_Simple_Selection_Sort {



    public static void main(String[] args) {
        int[] arry = new int[] { 34,1,221,50,44,58,12,1,23,21,43};
        LKK_Simple_Selection_Sort.LKK_SimpleSelectSort(arry);
        for (int i = 0; i < arry.length; i++){
            System.out.println(arry[i]);
        }
    }

    private static void LKK_SimpleSelectSort(int[] arry) {
        for (int i=0;i<arry.length;i++){
            int big = i;
            for (int j=i+1;j<arry.length;j++){
                if(arry[j]>arry[big]){
                    big=j;
                }
            }
            int temp =arry[i];
            arry[i]=arry[big];
            arry[big]=temp;
        }
    }

}
