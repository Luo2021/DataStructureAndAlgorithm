package luo.li.链表;

import luo.li.链表.common.LinkNode;

/**
 * @Author 19612
 * @Create 2023/11/29 17:12
 */
public class 获取链表倒数第k个元素 {

    public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        head.next = new LinkNode(2);
        head.next.next = new LinkNode(3);
        head.next.next.next = new LinkNode(4);
        head.next.next.next.next = new LinkNode(5);
//        LinkNode reverseLinkNode = reverseLinkNode1(head);
        LinkNode reverseLinkNode = getK(head, 3);
        if(reverseLinkNode != null) {
            System.out.print(reverseLinkNode.val);
        }else{
            System.out.print(reverseLinkNode);
        }
    }

    public static LinkNode getK(LinkNode p, int k) {
        if(p == null || k < 0) {
            return null;
        }
        LinkNode fast = p;
        LinkNode slow = p;
        for (int i = 0; i < k; i++) {
            if(fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
