package Sort.Question;

/**
 * leetcode 147
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0, null);
        ListNode pre = dummyHead;
        ListNode tail = head;

        if (tail == null) {
            return head;
        }
        while (tail != null) {
            pre = dummyHead;
            while (pre.next != null) {
                if (pre.next.val >= tail.val) {
                    break;
                }
                pre = pre.next;
            }
            ListNode temp = tail;
            tail = tail.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummyHead.next;
    }

    public ListNode testCase() {
        ListNode head = new ListNode(-1, null);
        ListNode temp = null;
        for (int i = 0; i < 10; i++) {
            temp = new ListNode(i, null);
            temp.next = head.next;
            head.next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        InsertionSortList a = new InsertionSortList();
        ListNode head = a.testCase();
        head = a.insertionSortList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
