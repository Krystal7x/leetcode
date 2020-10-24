package sort.Swap_Sort;

/**
 * Created by k on 2018/9/5.
 */
public class LKK_Bubble_Sort {

    public static void main(String[] args) {
        int[] arry = new int[]{34, 1, 221, 50, 44, 58, 12,3,43,45,66};
        LKK_Bubble_Sort.LKK_Bubble_Sort(arry);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }

    private static void LKK_Bubble_Sort(int[] arry) {
        for(int i=0;i<arry.length;i++){
            for(int j=0;j<arry.length-i-1;j++){
                if(arry[j]<arry[j+1]){
                    int temp=arry[j];
                    arry[j]=arry[j+1];
                    arry[j+1]=temp;
                }

            }
        }
    }
}
