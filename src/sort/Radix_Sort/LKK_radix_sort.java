package sort.Radix_Sort;

/**
 * Created by k on 2018/9/5.
 */
public class LKK_radix_sort {

    public static void main(String[] args) {
        int[] array = {50, 123, 543, 187, 49, 30, 0, 2, 11, 100};
        System.out.print("排序前:\t\t");
        printAll(array);
        LKK_radix_sort.sort(array);
        System.out.print("排序后:\t\t");
        printAll(array);
    }

    public static void  sort(int[] list) {
        LKK_radix_sort.radix(list, 0, list.length - 1, 3);
    }

    public static int getDigit(int x, int d) {
        int a[] = {
                1, 1, 10, 100
        }; // 本实例中的最大数是百位数，所以只要到100就可以了
        return ((x / a[d]) % 10);
    }
    public static void radix(int[] list, int begin, int end, int digit){
       int []count =new int[10];
        int[]  temp = new int[end-begin+1];

        for(int d=1;d<=digit;d++){
            for(int i=0;i<count.length;i++){count[i]=0;}
            for(int i=0;i<list.length;i++){int dig= getDigit(list[i],d);count[dig]++;}
            for(int i=1;i<count.length;i++){count[i]=count[i]+count[i-1];}
            for(int i=list.length-1;i>=0;i--){
                int dig= getDigit(list[i],d);
                temp[count[dig]-1]=list[i];
                count[dig]--;
            }
            for(int i=0;i<list.length;i++){list[i]=temp[i];}
        }
    }

    // 打印完整序列
    public static void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}
