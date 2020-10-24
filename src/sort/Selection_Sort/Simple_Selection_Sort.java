package sort.Selection_Sort;

/**
 * 基本思想：
 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
 然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，
 依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
 不稳定！！！！（举个例子，序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法）
 */
public class Simple_Selection_Sort {
    public static int[]  SimpleSelectSort( int[] arry){
        int tmp = 0;
        int t = 0;//最小数标记


        for (int i = 0; i < arry.length; i++){
            t = i;
             for (int j = i + 1; j < arry.length; j++){
                 if (arry[t] > arry[j]){
                     t = j;
                 }
               }
            tmp = arry[i];
            arry[i] = arry[t];
            arry[t] = tmp;
        }
        return arry;
    }

    public static void main(String[] args) {
        int[] arry = new int[] { 34,1,221,50,44,58,12};
        arry= Simple_Selection_Sort.SimpleSelectSort(arry);
        for (int i = 0; i < arry.length; i++){
            System.out.println(arry[i]);
        }
    }
}
