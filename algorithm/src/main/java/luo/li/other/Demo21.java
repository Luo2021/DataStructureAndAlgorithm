package luo.li.other;
import luo.li.other.common.ListNode;

/**
 * 合并两个有序链表
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * @Author liluo
 * @create 2022/6/16 11:02
 */
public class Demo21 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode newHead = new Demo21().mergeTwoLists(list1,list2);
        while(newHead!=null){
            System.out.print(newHead.val+",");
            newHead = newHead.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode dump = head;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        while(list1!=null&&list2!=null){
            if(list1.val <= list2.val) {
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            head = head.next;
        }
        if(list1!=null){
            head.next = list1;
        }
        if(list2!=null){
            head.next = list2;
        }
        return dump.next;
    }
}
