package LinkList;

import java.util.List;

public class Question143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode tail = head;
        while (tail.next.next != null) {
            tail = tail.next;
        }

        tail.next.next = head.next;
        head.next = tail.next;
        tail.next = null;
        reorderList(head.next.next);
    }

    public void reorderList2(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode dummyHead = new ListNode();
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        dummyHead.next = slow;
        while (slow.next != null) {
            fast = slow.next;
            slow.next = slow.next.next;
            fast.next = dummyHead.next;
            dummyHead.next = fast;
        }
        fast = dummyHead;
        while (head.next != null) {
            slow = head;
            head = head.next;
            slow.next = fast.next;
            fast.next = slow;
            fast = fast.next.next;
        }
        head = dummyHead.next;
    }

    public static void main(String[] args) {
        Test test = new Test();
        ListNode head = test.intial(5);
        Question143 a = new Question143();
        a.reorderList2(head);
        test.output(head);
    }
}
