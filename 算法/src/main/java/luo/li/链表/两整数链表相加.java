package luo.li.链表;

import luo.li.链表.common.LinkNode;

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
public class 两整数链表相加 {
    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(2);
        l1.next = new LinkNode(4);
        l1.next.next = new LinkNode(3);

        LinkNode l2 = new LinkNode(5);
        l2.next = new LinkNode(6);
        l2.next.next = new LinkNode(4);

        LinkNode head = new 两整数链表相加().addTwoNumbers(l1,l2);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {
        LinkNode newHead = new LinkNode(-1);
        LinkNode head = newHead;
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        //进位默认是0
        int carry = 0;
        while(l1!=null && l2!=null) {
            int a = (l1.val + l2.val + carry)%10;
            head.next = new LinkNode(a);
            carry = (l1.val + l2.val + carry)/10;
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }

        while(l1!=null) {
            int a = (l1.val + carry)%10;
            head.next = new LinkNode(a);
            carry = (l1.val + carry)/10;
            l1 = l1.next;
            head = head.next;
        }

        while(l2!=null) {
            int a = (l2.val + carry)%10;
            head.next = new LinkNode(a);
            carry = (l2.val + carry)/10;
            l2 = l2.next;
            head = head.next;
        }
        //最后进位
        if(carry != 0) {
            head.next = new LinkNode(carry);
        }
        return newHead.next;
    }
}

