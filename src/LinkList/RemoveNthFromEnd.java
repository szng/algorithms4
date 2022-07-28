package LinkList;

/**
 * leetcode 19
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode tail = pre;
        head = pre;
        while (n > 0) {
            if (tail.next == null) {
                return null;
            }
            tail = tail.next;
            --n;
        }
        while (tail.next != null) {
            pre = pre.next;
            tail = tail.next;
        }
        pre.next = pre.next.next;
        return head.next;
    }

    public static void main(String[] args) {
        Test test = new Test();
        ListNode head = test.intial(5);
        RemoveNthFromEnd a = new RemoveNthFromEnd();
        head = a.removeNthFromEnd(head, 5);
        test.output(head);
    }
}
