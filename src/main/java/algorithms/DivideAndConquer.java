package algorithms;

/**
 * 常见基于分治算法的实现
 * Created by bczhang on 2016/11/4.
 */
public class DivideAndConquer {
    /**
     * No 1
     * 普通的方法求一个数组中的最大值最小值
     * 时间复杂度是2n-2
     * @param a
     * @return
     */
    public static int[] normalGetMaxAndMin(int[] a){
        int result[]=new int[2];
        for(int i=2;i<a.length;i++){
            if(a[i]<result[0])
                result[0]=a[i];
            if(a[i]>result[1])
            result[1]=a[i];
        }
        return result;
    }

    /**
     * No 1
     * 基于分治法，同时求一个数组中的的最大值及最小值，
     * 时间复杂率是（3n-2）/2-2；注意java中值传递以及引用传递，如现在需要
     */
    public static void max_min(int []a,int left,int right,int []maxnum,int []minnum)
    {
        if (left==right)   //当只有一个元素时候，直接得出最大值和最小值
        {
            maxnum[0]=a[left];
            minnum[0]=a[right];
        }
        else if (left+1==right)//当数组中有两个元素时，直接判断哪个元素大，哪个元素小
        {
            if (a[left]>a[right])
            {
                maxnum[0]=a[left];
                minnum[0]=a[left];
            }
            else
            {
                maxnum[0]=a[right];
                minnum[0]=a[left];
            }
        }
        else     //当数组元素的个数大于2以上的操作。
        {
            int m=(left+right)/2;
            //int lmax=0,lmin=0,rmax=0,rmin=0;
            int lmax[]={0};
            int lmin[]={0};
            int rmax[]={0};
            int rmin[]={0};

            max_min(a,left,m,lmax,lmin);
            max_min(a, m+1, right, rmax, rmin);

            // maxnum=lmax>rmax?lmax:rmax;
            // minnum=lmin<rmin?lmin:rmin;
            if(lmax[0]>rmax[0])
            {
                maxnum[0]=lmax[0];
            }
            else
            {
                maxnum[0]=rmax[0];
            }
            if(lmin[0]<rmin[0])
            {
                minnum[0]=lmin[0];
            }
            else
            {
                minnum[0]=rmin[0];
            }
        }
        //System.out.println("最大值："+maxnum);
        //System.out.println("最小值: "+minnum);

    }

    /**
     * No 2
     * 基于迭代法，实现二分查找
     *@param sortArr  一个排好序的数组
     *@param target  待查找的数据
     *@return 找到返回此target，找不到返回0
     */
    public  static int  binarySearchByIteration(int sortArr[],int target){
        int mid ,low ,high;
        low=0;high=sortArr.length-1;

        while(low<=high){
            mid=(high+low)/2;
            if(sortArr[mid]<target){
                low=mid+1;
            }
            else if (sortArr[mid]>target){
                high=mid-1;
            } else return target;
        }
        return -1;
    }
    /**
     * No 2
     *
     * 基于递归法，实现二分查找
     *@param sortArr 已经排序好的数组
     *@param target 查找目标
     *@param high 数组上标
     *@param low 数组下标
     */
    public  static int  binarySearchByRecursion(int sortArr[],int target,int low ,int high){

        if(low>high)
            return -1;
        else{
            int  mid=(low+high)/2;
            if(target==sortArr[mid])
                return target;
            else  if(target<sortArr[mid])
                return binarySearchByRecursion(sortArr,target,low,mid-1);
            return binarySearchByRecursion(sortArr,target,mid+1,high);

        }

    }
    public static void main(String[]args){
        int a[]={4,5,45,956,445,2,364,4,0,2,12};
        int array[]={1,1,1,1,1,2,3};

        int []Max=new int[1];  //java对于实参传递，是采用值传递，所以要改成数组，不能直接使用变量去计算最大值和最小值。
        int []Min=new int[1];
        max_min(array,0,array.length-1,Max,Min);
        System.out.println("最大值： "+Max[0]);
        System.out.println("最小值： "+Min[0]);

        int result=binarySearchByRecursion(array,3,0,array.length);
        System.out.println(result);

    }
}
