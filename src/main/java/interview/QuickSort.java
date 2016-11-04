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
            System.out.print(arr[i]+" ");
        }
        System.out.println();
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
    /**
     * public static int binarySearch(Integer[] srcArray, int des) {
     int low = 0;
     int high = srcArray.length - 1;

     while ((low <= high) && (low <= srcArray.length - 1)
     && (high <= srcArray.length - 1)) {
     int middle = (high + low) >> 1;
     if (des == srcArray[middle]) {
     return middle;
     } else if (des < srcArray[middle]) {
     high = middle - 1;
     } else {
     low = middle + 1;
     }
     }
     return -1;
     }
     */

}
