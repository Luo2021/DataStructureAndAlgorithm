package luo.li.other;

import luo.li.other.common.ListNode;

/**
 * K 个一组翻转链表
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * @Author liluo
 * @create 2022/6/23 16:37
 */
public class Demo25 {

    public static void main(String[] args) {
        int k = 3;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = new Demo25().reverseKGroup(head,k);
        while(newHead!=null){
            System.out.print(newHead.val+",");
            newHead = newHead.next;
        }
    }

    //方法1：递归
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curHead = head;
        for(int i=0;i<k;i++){
            if(curHead==null)
                return head;
            curHead = curHead.next;
        }
        ListNode subList = reverseKGroup(curHead, k);
        // 反转链表中前k个节点
        ListNode newHead = reverseTopN(head, k);
        head.next = subList;
        return newHead;
    }

    public ListNode reverseTopN(ListNode head, int k) {
        ListNode pre = null;
        for(int i=0;i<k;i++){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
