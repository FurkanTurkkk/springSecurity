package org.example;

import java.util.LinkedList;
/*
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
         */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(2);
        ListNode listNode1=new ListNode(4);
        ListNode listNode2=new ListNode(3);
        ListNode listNode3=new ListNode(5);
        ListNode listNode4=new ListNode(6);
        ListNode listNode5=new ListNode(4);

        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        System.out.println(addTwoNumbers(listNode,listNode3).val+" "+ addTwoNumbers(listNode,listNode3).next.val);

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }


}
