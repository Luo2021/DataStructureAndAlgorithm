package luo.li.other;

/**
 * @Author liluo
 * @create 2023/10/18 19:10
 */
public class Test {

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        TestLinkNode node1 = new TestLinkNode(1);
        TestLinkNode node2 = new TestLinkNode(2);
        TestLinkNode node3 = new TestLinkNode(3);
        linkedListStack.push(node1);
        linkedListStack.push(node2);
        linkedListStack.push(node3);
        linkedListStack.poll();
        linkedListStack.poll();
        linkedListStack.poll();
    }
}
