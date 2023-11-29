package luo.li.链表;

import luo.li.链表.common.LinkNode;

/**
 * 链表反转
 * @author luoli
 * @date 2022/3/30 22:07
 */
public class 链表反转 {
    public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        head.next = new LinkNode(2);
        head.next.next = new LinkNode(3);
        head.next.next.next = new LinkNode(4);
        head.next.next.next.next = new LinkNode(5);
//        LinkNode reverseLinkNode = reverseLinkNode1(head);
        LinkNode reverseLinkNode = reverseLinkNode2(head);
        while(reverseLinkNode != null) {
            System.out.print(reverseLinkNode.val+"->");
            reverseLinkNode = reverseLinkNode.next;
        }
    }

    /**
     * 递归
     * @param head
     * @return
     */
    private static LinkNode reverseLinkNode1(LinkNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        LinkNode newHead = reverseLinkNode1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 非递归
     * @param head
     * @return
     */
    private static LinkNode reverseLinkNode2(LinkNode head) {
        LinkNode newHead = null;
        LinkNode next;
        while(head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}


