package interview;

import java.util.Comparator;

/**
 * Created by bczhang on 2016/5/19.
 *
 */
public class QuickSort {
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    /**
     * quicksort the array of objects.
     *
     * @param arr[]  - an array of objects
     * @param left  - the start index - from where to begin sorting
     * @param right  - the last index.
     * @param comp  - an object that implemnts the Compare interface to resolve thecomparison.
     */
    public static void quicksort(int arr[], int left, int right) {
        int i, last;

        if (left >= right) { /* do nothing if array contains fewer than two */
            return;          /* two elements */
        }
        swap(arr, left, (left+right) / 2);
        last = left;
        for (i = left+1; i <= right; i++) {
            if ((arr[i]-arr[left] )< 0) {
                swap(arr, ++last, i);
            }
        }
        swap(arr, left, last);
        quicksort(arr, left, last-1);
        quicksort(arr, last+1, right);
    }

    public static void quicksort(int arr[]) {
        quicksort(arr, 0, arr.length-1);
    }


    public static void main(String[] args){
        int arr[]={2,1,0,3,1,9,0};
        quicksort(arr);
        for(int c:arr)
            System.out.print(c+" ");

    }



}
