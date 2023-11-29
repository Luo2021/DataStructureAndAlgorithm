package luo.li.other;

import luo.li.other.common.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * @Author liluo
 * @create 2022/6/15 9:45
 */
public class Demo19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode newHead = new Demo19().removeNthFromEnd(head,2);
        while(newHead!=null){
            System.out.print(newHead.val+",");
            newHead = newHead.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode firstHead = head;
        ListNode secondHead = dummy;
        for(int i=1; i<=n; i++){
            firstHead = firstHead.next;
        }
        while(firstHead!=null){
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        secondHead.next = secondHead.next.next;
        return dummy.next;
    }
}
