package LinkList;

/**
 * leetcode 141
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
        HasCycle a = new HasCycle();
        System.out.println(a.hasCycle(node));
    }
}
