package sort.Merge_Sort;

import java.util.ArrayList;

/**
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * 归并操作的工作原理如下：
 第一步：申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 第二步：设定两个指针，最初位置分别为两个已经排序序列的起始位置
 第三步：比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 重复步骤3直到某一指针超出序列尾
 将另一序列剩下的所有元素直接复制到合并序列尾

 是稳定的排序！！！！
 */
public class Merge_Sort {
    /// 归并排序
    public static void MergeSort( int[] arry, int first, int last) {
        //这是关键
        //至少三个？？
        if (first + 1 < last) {
            int mid = (first + last) / 2;
            MergeSort(arry, first, mid);
            MergeSort(arry, mid, last);
            Merger(arry, first, mid, last);
        }
    }

    /// 归并
    private static void Merger(int[] arry, int first, int mid, int last) {
        ArrayList<Integer> tempV = new ArrayList<Integer>();
        int indexA, indexB;
        //设置indexA，并扫描subArray1 [first,mid]
        //设置indexB,并扫描subArray2 [mid,last]
        indexA = first;
        indexB = mid;
        //在没有比较完两个子标的情况下，比较 v[indexA]和v[indexB]
        //将其中小的放到临时变量tempV中
        while (indexA < mid && indexB < last)
        {
            if (arry[indexA] < arry[indexB])
            {
                tempV.add(arry[indexA]);
                indexA++;
            }
            else
            {
                tempV.add(arry[indexB]);
                indexB++;
            }
        }
        //复制没有比较完子表中的元素
        while (indexA < mid)
        {
            tempV.add(arry[indexA]);
            indexA++;
        }
        while (indexB < last)
        {
            tempV.add(arry[indexB]);
            indexB++;
        }
        //改变数组中的值，，
        int index = 0;
        while (tempV.size() > 0)
        {
            arry[first + index] = tempV.get(index);
            index++;
            if(index>=tempV.size()){break;}
        }
    }

    public static void main(String[] args) {
        int[] arry = new int[] {3,4,1};
        Merge_Sort.MergeSort(arry,0,arry.length);//没有减1
        for (int i = 0; i < arry.length; i++){
            System.out.println(arry[i]);
        }
    }

}
