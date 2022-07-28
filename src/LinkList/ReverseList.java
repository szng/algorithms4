package LinkList;

/**
 * leetcode 206
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode pre) {
        if (head == null) {
            return pre;
        }
        ListNode next = head.next;
        head.next = pre;
        return reverseList(next, head);
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode dummy = new ListNode(0, null);
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = reverseList4(head.next);
        head.next.next = head;
        head.next = null;
        return dummy;
    }

    public static void main(String[] args) {
        Test test = new Test();
        ListNode head = test.intial(5);
        test.output(head);
        ReverseList a = new ReverseList();
        test.output(a.reverseList(head));
    }
}
