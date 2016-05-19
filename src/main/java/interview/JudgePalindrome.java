package interview;

/**
 * Created by bczhang on 2016/5/19.
 *To determine whether a string is a palindrome
 */
public class JudgePalindrome {

    public static void main(String[] args){
        System.out.println(myJudge("m"));
    }

    /**
     * O(n),O(1)
     * 从两头开始判断，只需要维护首尾部的两个指针
     * @param str
     * @return
     */
    public static  boolean myJudge(String str){
        char[] arr=str.toCharArray();
        int size=arr.length;
        boolean result=true;
        for(int i=0;i<arr.length/2;i++)
        {
            if(arr[i]!=arr[size-i-1]){
                result=false;
            break;
            }

        }
        System.out.println(arr.length/2);
        return result;
    }
    /*
    另一种相似的做法，先定位到中间然后从中间向两头依次判断。
    时间复杂度和空间复杂度没变，但处理一些特殊的字符串会高效
     */

    /*
    举一反三，
     问题一：如何判断一个单链表是不是回文的？
     问题二：如何判断一个栈是不是回文的

     问题一分析：分析：对于单链表结构，可以用两个指针从两端或者中间遍历并判断对应字符是否相等。
    但这里的关键就是如何朝两个方向遍历。由于单链表是单向的，
    所以要向两个方向遍历的话，可以采取经典的快慢指针的方法，即先位到链表的中间位置，
    再将链表的后半逆置，最后用两个指针同时从链表头部和中间开始同时遍历并比较即可。
    问题二分析：对于栈的话，只需要将字符串全部压入栈，然后依次将各字符出栈，这样得到的就是原字符串的逆置串，
    分别和原字符串各个字符比较，就可以判断了。
     */
}
