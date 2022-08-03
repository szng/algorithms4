package LinkList;

public class Question92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        head = dummyHead;
        for (int i = 1; i < left && head != null; i++) {
            head = head.next;
        }
        ListNode tail = head.next;
        ListNode cur;
        for (int i = left; i < right; i++) {
            cur = tail.next;
            tail.next = cur.next;
            cur.next = head.next;
            head.next = cur;
        }
        return dummyHead.next;
    }
}
