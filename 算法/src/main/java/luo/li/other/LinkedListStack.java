package luo.li.other;

/**
 * @Author liluo
 * @create 2023/10/18 18:01
 */
public class LinkedListStack {
    TestLinkNode head = null;
    public TestLinkNode push(TestLinkNode node) {
        node.next = head;
        head = node;
        return head;
    }

    public TestLinkNode poll() {
        if(head == null){
            return head;
        }
        head = head.next;
        return head;
    }

}

class TestLinkNode {

    int val;
    TestLinkNode next;

    public TestLinkNode(int val) {
        this.val = val;
    }

    public TestLinkNode(int val, TestLinkNode next) {
        this.val = val;
        this.next = next;
    }
}
