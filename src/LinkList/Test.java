package LinkList;

public class Test {
    public ListNode intial(int n) {
        ListNode dummy = new ListNode(0, null);
        while (n != 0) {
            ListNode temp = new ListNode(n--, null);
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }

    public void output(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
