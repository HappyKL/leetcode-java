package com.ict.kang.top100;

import com.ict.kang.list.ListNode;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-21 23:34
 * @description :
 * @modified :
 */
public class AddTwoNumbers {

    /**
     * @Date 2019-09-22 00:09
     * @Description 自己写的冗余代码较多
     * @Return com.ict.kang.list.ListNode
     **/
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int jinVal = 0;
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode ptr = head;
        jinVal = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            ListNode listNode = new ListNode((l1.val + l2.val + jinVal) % 10);
            ptr.next = listNode;
            ptr = listNode;
            jinVal = (l1.val + l2.val + jinVal) / 10;

            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {
            ListNode listNode = new ListNode((l1.val + jinVal) % 10);
            ptr.next = listNode;
            ptr = listNode;
            jinVal = (l1.val + jinVal) / 10;
            l1 = l1.next;

        }
        while (l2 != null) {
            ListNode listNode = new ListNode((l2.val + jinVal) % 10);
            ptr.next = listNode;
            ptr = listNode;
            jinVal = (l2.val + jinVal) / 10;
            l2 = l2.next;

        }

        if (jinVal != 0) {
            ListNode listNode = new ListNode(jinVal);
            ptr.next = listNode;
        }

        return head;
    }

    /**
     * @Date 2019-09-22 00:09
     * @Description 官方题解 比较简洁
     * @Return
     **/
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
