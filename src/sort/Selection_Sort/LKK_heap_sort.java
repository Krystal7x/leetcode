package sort.Selection_Sort;

/**
 * Created by k on 2018/9/5.
 */
public class LKK_heap_sort {

    public static void main(String[] args) {
        int [] H = new int[]{3,1,5,7,2,4,45,666,9,6,10,8,23};
        System.out.println("初始值：");
        LKK_heap_sort.print(H,H.length);
        LKK_heap_sort.HeapSort(H,H.length);
        //selectSort(a, 8);
        System.out.println("结果：");
        LKK_heap_sort.print(H,H.length);
    }



    public static void print(int [] H ,int length ){
        for(int i=0;i<length;i++){
            System.out.print(H[i]+" ");
        }
        System.out.println();
    }
    private static void HeapSort(int[] array, int length) {
        LKK_heap_sort.buildpSort(array, length);
        for(int i=length-1;i>=0;i--) {
            int temp = array[i]; array[i] = array[0]; array[0] = temp;
            LKK_heap_sort.adjustHeap(array,0,i);
        }

    }
    private static void buildpSort(int[] array, int length) {
        for(int i=(length-1)/2;i>=0;i--) {
            LKK_heap_sort.adjustHeap(array, i,length);
        }
    }

    private static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        int child= 2*i+1;
        while(child<length){
            if(child+1<length&&array[child]<array[child+1]){child++;}
            if(array[child]>temp){
                array[i]=array[child];
                i=child;
                child=2*i+1;
            }else{break;}/////////////////////////////////////////////////////////////////////////////////
            array[i]=temp;
        }
    }
}
