package LinkList;

/**
 * leetcode 328
 * 两种情况末尾是一样的，奇数把null当作一个节点
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = head.next;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Test test = new Test();
        ListNode head = test.intial(6);
        OddEvenList a = new OddEvenList();
        head = a.oddEvenList(head);
        test.output(head);
    }
}
