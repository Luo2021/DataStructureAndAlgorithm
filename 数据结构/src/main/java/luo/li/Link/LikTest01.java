package luo.li.Link;

/**
 * 有⼀个链表，奇数位升序偶数位降序，如何将链表变成升序？
 *
 * @Author liluo
 * @create 2023/7/14 17:03
 */
public class LikTest01 {

    public static void main(String[] args) {

        LinkNode head = new LinkNode(1);
        LinkNode head2 = new LinkNode(8);
        LinkNode head3 = new LinkNode(3);
        LinkNode head4 = new LinkNode(6);
        LinkNode head5 = new LinkNode(5);
        LinkNode head6 = new LinkNode(4);
        LinkNode head7 = new LinkNode(7);
        LinkNode head8 = new LinkNode(2);
        LinkNode head9 = new LinkNode(9);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;
        head7.next = head8;
        head8.next = head9;
        LinkNode[] nodes = getLists(head);
        nodes[1] = reverseNode2(nodes[1]);
        LinkNode newHead = CombineList(nodes[0], nodes[1]);
        while(newHead != null) {
            System.out.print(newHead.val +"->");
            newHead = newHead.next;
        }
    }

    /**
     * 按照奇偶位拆分成两个链表
     * @param head
     * @return
     */
    private static LinkNode[] getLists(LinkNode head) {
        LinkNode head1 = null;
        LinkNode head2 = null;
        LinkNode cur1 = null;
        LinkNode cur2 = null;
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                if (cur1 == null) {
                    cur1 = head;
                    head1 = cur1;
                } else {
                    cur1.next = head;
                    cur1 = cur1.next;
                }
            } else {
                if (cur2 == null) {
                    cur2 = head;
                    head2 = cur2;
                } else {
                    cur2.next = head;
                    cur2 = cur2.next;
                }
            }
            count++;
            head = head.next;
        }
        cur1.next = null;
        cur2.next = null;
        LinkNode[] nodes = new LinkNode[]{head1, head2};
        return nodes;
    }

    /**
     * 链表翻转递归写法
     * @param head
     * @return
     */
    private static LinkNode reverseNode(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode newHead = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 链表翻转非递归写法
     * @param head
     * @return
     */
    private static LinkNode reverseNode2(LinkNode head) {
        LinkNode newHead = null;
        while (head != null) {
            LinkNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 合并两个有序链表
     * @param head1
     * @param head2
     * @return
     */
    public static LinkNode CombineList(LinkNode head1, LinkNode head2) {
        LinkNode head = new LinkNode(-1);
        LinkNode cur = head;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            }else{
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        if(head1 == null) {
            cur.next = head2;
        }
        if(head2 == null) {
            cur.next = head1;
        }
        return head.next;
    }
}


class LinkNode{
    int val;
    LinkNode next;
    public LinkNode (int val) {
        this.val = val;
    }
}


