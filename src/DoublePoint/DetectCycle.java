package DoublePoint;


/**
 * leetcode 142
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int pos = -1;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode flag = head;
        for (int i = 0; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
            if (i == pos) {
                flag = tail;
            }
        }
        if (pos >= 0) {
            tail.next = flag;
        }
        DetectCycle a = new DetectCycle();
        System.out.println(a.detectCycle(head.next));
    }
}
