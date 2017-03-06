package interview.JianZhiOffer66;

import java.util.ArrayList;

/**
 *   public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *    输入一个链表，从尾到头打印链表每个节点的值。
 *
 *    暴露问题，链表的操作
 * Created by 宝超 on 2017/3/5.
 */
public class ReversePrintList {


    public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList res=new ArrayList<Integer>();

        return res;

    }
    public static ListNode reverseList(ListNode head){
        ListNode p=head;
        ListNode newHead=head.next;
        while(newHead.next==null){
            newHead.next=p;
            p=newHead;
            newHead=newHead.next;
        }
        return newHead;
    }
    public static void main(String[] args){
        ListNode head=new ListNode();
        ListNode tail=new ListNode();
        tail=head;
        int i=0;
        while (i<10){
            ListNode p=new ListNode(i);
            tail.next=p;
            tail=p;
            i++;
        }

       head= reverseList(head);
        for(;head.next!=null;) {
            System.out.println(head.val);
            head=head.next;
        }
    }

}
