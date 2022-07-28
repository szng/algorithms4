package LinkList;

/**
 * leetcode 148
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(0,null), slow = head, fast = head;
        if (head == null || head.next == null) {
            return head;
        }
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        ListNode cur = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left == null) {
            cur.next = right;
        } else {
            cur.next = left;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Test test = new Test();
        ListNode head = test.intial(5);
        test.output(head);
        SortList a = new SortList();
        head = a.sortList(head);
        test.output(head);
    }
}
