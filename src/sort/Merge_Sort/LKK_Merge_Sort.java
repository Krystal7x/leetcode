package sort.Merge_Sort;

/**
 * Created by k on 2018/9/5.
 */
public class LKK_Merge_Sort {
    public static void main(String[] args) {
        int[] arry = new int[] {3,4,1,34,54};
        //没有减1
        LKK_Merge_Sort.MergeSort(arry,0,arry.length-1);
        for (int i = 0; i < arry.length; i++){
            System.out.println(arry[i]);
        }
    }

    private static void MergeSort(int[] arry, int start, int end) {
      if(start<end){
          int mid=(start+end)/2;
          MergeSort(arry,start,mid);
          MergeSort(arry,mid+1,end);
          Merger(arry,start,mid,end);
      }
    }

    private static void Merger(int[] a, int low, int mid, int high){
        int[] temp = new int[high-low+1] ;
        int i=low;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=high){
            if(a[i]>a[j]){
                temp[k++]=a[i++];
            }else{
                temp[k++]=a[j++];
            }
        }

        while(i<=mid){
            temp[k++]=a[i++];
        }
        while(j<=high){
            temp[k++]=a[j++];
        }
        for(int o=0;o<temp.length;o++){
            a[low+o]=temp[o];
        }
    }
}
