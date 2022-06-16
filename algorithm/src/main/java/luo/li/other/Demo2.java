package luo.li.other;

import luo.li.other.common.ListNode;

/**
 *给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * @Author liluo
 * @create 2022/5/9 17:01
 */
public class Demo2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode head = new Demo2().addTwoNumbers(l1,l2);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode head = newHead;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        //进位默认是0
        int carry = 0;
        while(l1!=null && l2!=null) {
            int a = (l1.val + l2.val + carry)%10;
            head.next = new ListNode(a);
            carry = (l1.val + l2.val + carry)/10;
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }

        while(l1!=null) {
            int a = (l1.val + carry)%10;
            head.next = new ListNode(a);
            carry = (l1.val + carry)/10;
            l1 = l1.next;
            head = head.next;
        }

        while(l2!=null) {
            int a = (l2.val + carry)%10;
            head.next = new ListNode(a);
            carry = (l2.val + carry)/10;
            l2 = l2.next;
            head = head.next;
        }
        //最后进位
        if(carry != 0) {
            head.next = new ListNode(carry);
        }
        return newHead.next;
    }
}

