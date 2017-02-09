package utils;

import java.util.Random;

/**
 * Created by 宝超 on 2017/2/9.
 */
public class RandomArray {
    /**
     * get a random array,
     */
    static {
        new RandomArray();
    }
    public static int[] getRandArr(){
        int max=100;
        int min=-100;
        int []a=new int[20];
        int count=0;
        Random rand=new Random();
        while(count<a.length){
            int randomNum=rand.nextInt((max-min)+1)+min;
            a[count]=randomNum;
            count++;
        }
        return a;
    }
    /**
     *
     */
    public static int[] getRandArr(int max,int min,int nums){
        if(nums<0){throw
        new IllegalArgumentException();}

        int []a=new int[nums];
        int count=0;
        Random rand=new Random();
        while(count<a.length){
            int randomNum;
            if(max>min)
                randomNum=rand.nextInt((max-min)+1)+min;
            else   randomNum=rand.nextInt((min-max)+1)+min;
            a[count]=randomNum;
            count++;
        }
        return a;
    }
    public static void main(String [] args){
        for(int a:getRandArr(100,0,20))
        System.out.print(a+" ");
    }
}
