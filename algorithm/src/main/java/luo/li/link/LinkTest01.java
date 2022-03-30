package luo.li.link;

/**
 * 链表反转
 * @author luoli
 * @date 2022/3/30 22:07
 */
public class LinkTest01 {
    public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        head.next = new LinkNode(2);
        head.next.next = new LinkNode(3);
        head.next.next.next = new LinkNode(4);
        head.next.next.next.next = new LinkNode(5);
//        LinkNode reverseLinkNode1 = reverseLinkNode1(head);
//        while(reverseLinkNode1 != null) {
//            System.out.print(reverseLinkNode1.val+"->");
//            reverseLinkNode1 = reverseLinkNode1.next;
//        }

        LinkNode reverseLinkNode2 = reverseLinkNode2(head);
        while(reverseLinkNode2 != null) {
            System.out.print(reverseLinkNode2.val+"->");
            reverseLinkNode2 = reverseLinkNode2.next;
        }
    }

    //递归
    private static LinkNode reverseLinkNode1(LinkNode head) {
        if(head == null || head.next == null)
            return head;
        LinkNode newHead = reverseLinkNode1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //非递归
    private static LinkNode reverseLinkNode2(LinkNode head) {
        LinkNode newHead = null;
        LinkNode next = null;
        while(head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}

class LinkNode{
    int val;
    LinkNode next;
    public LinkNode (int val) {
        this.val = val;
    }
}
