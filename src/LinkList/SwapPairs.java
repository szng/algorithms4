package LinkList;

/**
 * leetcode 24
 * 第一次不在循环内,因为没有占位的头节点
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head, s;
        if (p != null && p.next != null) {
            s = p.next;
            p.next = s.next;
            s.next = p;
            head = s;
            while (p.next != null && p.next.next != null) {
                s = p.next.next;
                p.next.next = s.next;
                s.next = p.next;
                p.next = s;
                p = p.next.next;
            }
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode p = head, s;
        if (p == null || p.next == null) {
            return p;
        }
        ListNode tail = swapPairs2(p.next.next);
        s = p.next;
        p.next = tail;
        s.next = p;
        return s;
    }

    public static void main(String[] args) {
        Test test = new Test();
        ListNode head = test.intial(5);
        SwapPairs a = new SwapPairs();
        ListNode result = a.swapPairs2(head);
        test.output(result);
    }
}
