package interview;

import static java.lang.Float.NaN;

/**
 * Created by bczhang on 2016/5/21.
 */
public class BinaryTreeSearch {
    public static boolean binarySearch(int [] arr,int n){
        int mid;
        int left=0;
        int right=arr.length-1;
        mid=(left+right)/2;
        boolean result=false;
        for(int i=0;i<arr.length;i++){
            if(arr[mid]==n){
                result= true;
            }
            else if(arr[mid]>n){
                left=mid;
            }else if(arr[mid]<n){
                right=mid;
            }
        }
        return result;
    }
    public static void main(String []args){
 Double d1=0.04545;
        double d2=d1;
        String str="中国人的额";
        System.out.print(str.length());
    }

}
