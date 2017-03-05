package interview.JianZhiOffer66;

import java.util.Arrays;

/**
 * 题目：题目描述
 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by 宝超 on 2017/3/5.
 */
public class FindNumIn2array {
    public static boolean find(int target, int [][] array) {
        boolean res=false;
    for(int i=0;i<array.length;i++){
        if(!res)
       res= binarySearch(array[i],target);
    }
     return res;
    }

    /**
     *二分查找
     * @param arr 递增数组
     * @param a 待查找元素
     * @return 存在返回true,否则返回false
     */
    public static  boolean binarySearch(int[] arr,int a){
        int left=0;
        int right=arr.length-1;
        int mid=(left+right)/2;//更好的写法：（left+right）>>1;《算法》书上这一步是,实质一样：mid=left+(right-left)/2;
        while(left<=right){//循环结束条件不能是left<right
            if(a==arr[mid])
                return true;
         else if(a<arr[mid]){
             right=mid-1;
         }else if(a>arr[mid]){
             left=mid+1;
         }
            mid=(left+right)/2;
        }
        return false;
    }
    public static void main(String[] args){
        //test binarySearch
        int []a={3,4};
        boolean b= binarySearch(a,3);
        System.out.println(b);
        int[][] ar={{1,2},{3,4},{5,6}};
        System.out.println(find(3,ar));
    }

}
