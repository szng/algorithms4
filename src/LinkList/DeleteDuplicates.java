package LinkList;

/**
 * leetcode 83
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0, head), cur = head;
        if (cur == null || cur.next == cur) {
            return cur;
        }
        pre = pre.next;
        cur = cur.next;
        while (cur != null) {
            if (pre.val == cur.val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
