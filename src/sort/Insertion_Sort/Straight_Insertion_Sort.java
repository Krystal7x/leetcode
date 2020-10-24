package sort.Insertion_Sort;

/**
 * 插入排序—直接插入排序
 *
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
 * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
 *
 * 如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。
 * 所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，
 * 所以插入排序是稳定!!!!
 * (稳定通俗地讲就是能保证排序前2个相等的数其在序列的前后位置顺序和排序后它们两个的前后位置顺序相同)的!!!
 */
public class Straight_Insertion_Sort {/// 直接插入排序
     /// arry要排序的数组
     public  static int[] InsertSort( int[] arry) {
             //直接插入排序是将待比较的数值与它的前一个数值进行比较，所以外层循环是从第二个数值开始的
             for (int i = 1; i < arry.length; i++) {
                 //如果当前元素小于其前面的元素
                if (arry[i] < arry[i - 1]) {
                    //用一个变量来保存当前待比较的数值，因为当一趟比较完成时，我们要将待比较数值置入比它小的数值的后一位
                    int temp = arry[i];
                    int j = 0;
                    for (j = i - 1; j >= 0 && temp < arry[j]; j--) {
                       arry[j + 1] = arry[j];
                    }
                        arry[j + 1] = temp;
                   }
             }
         return arry;
        }

    public static void main(String[] args) {
        int[] arry = new int[] { 34,1,221,50,44,58,12};
        arry=Straight_Insertion_Sort.InsertSort(arry);
         for (int i = 0; i < arry.length; i++) {
           System.out.println(arry[i]);
            }
    }


}
