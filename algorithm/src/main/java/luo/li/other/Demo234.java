package luo.li.other;

import luo.li.other.common.ListNode;

/**
 * @Author liluo
 * @create 2023/10/10 15:21
 */
public class Demo234 {

    public static void main(String[] args) {
        Demo234 demo234 = new Demo234();
        ListNode t1 = new ListNode(4);
        ListNode t2 = new ListNode(1);
        ListNode t3 = new ListNode(2);
        ListNode t4 = new ListNode(1);
        ListNode t5 = new ListNode(1);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;

        System.out.println(demo234.isPalindrome(t1));

    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = reverse(slow);
        while(p!=null && head != null) {
            if(p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }


    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        ListNode nextNode = null;
        while(head != null) {
            nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    public ListNode reverse2(ListNode head) {
       if(head == null || head.next == null) {
           return head;
       }
        ListNode newHead = reverse2(head.next);
       head.next.next = head;
       head.next = null;
       return newHead;
    }
}
