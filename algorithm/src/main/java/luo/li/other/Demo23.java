package luo.li.other;

import luo.li.other.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * @Author liluo
 * @create 2022/6/22 10:06
 */
public class Demo23 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        ListNode[] lists = new ListNode[3];
        lists[0] = node1; lists[1] = node2; lists[2] = node3;
        ListNode newHead = new Demo23().mergeKLists(lists);
        while(newHead!=null){
            System.out.print(newHead.val+",");
            newHead = newHead.next;
        }

    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode dumy = head;
        //定义一个小顶堆，使用优先级队列
       PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
           @Override
           public int compare(ListNode o1, ListNode o2) {
               return o1.val - o2.val;
           }
       });

       for(ListNode node:lists){
           if(node!=null){
               queue.offer(node);
           }
       }

       while(!queue.isEmpty()){
           ListNode listNode = queue.poll();
           head.next = listNode;
           head = head.next;
           if(listNode.next != null){
               queue.offer(listNode.next);
           }
       }
       return dumy.next;
    }
}
