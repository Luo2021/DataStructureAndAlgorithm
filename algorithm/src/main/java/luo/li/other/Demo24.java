package luo.li.other;

import luo.li.other.common.ListNode;

/**
 * 两两交换链表中的节点
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * @Author liluo
 * @create 2022/6/23 10:27
 */
public class Demo24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = new Demo24().swapPairs2(head);
        while(newHead!=null){
            System.out.print(newHead.val+",");
            newHead = newHead.next;
        }
    }
    //方法一：递归
    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    //方法二：迭代
    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}
