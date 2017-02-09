package algorithms;

import utils.RandomArray;

import java.util.Arrays;

/**
 * Created by 宝超 on 2017/2/9.
 */
public class BinarySearch {
    /**
     * this class should not be instantiated
     */
    private BinarySearch(){}
    /**
     * return the index of specified key in the sorted array
     * @param a the sorted array,must be sorted  in ascending order
     * @param key key the search key
     * return index of key in array {@code a }if present;{@code -1} otherwise
     */
    public static int indexOf(int []a ,int key){
        int low=0;
        int high=a.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(key<a[mid]) high=mid-1;
            else if(key>a[mid]) low=mid+1;
            else  return mid;
        }
        return -1;
    }
    public  static void main(String[] args){
        int[]a=RandomArray.getRandArr();
        int key=a[0];
        Arrays.sort(a);
        System.out.println("the key is "+key);
        for(int aa:a){
            System.out.print(aa+" ");
        }
        System.out.println();

        System.out.println(indexOf(a,key)) ;
    }
}
