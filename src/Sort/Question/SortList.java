package Sort.Question;

/**
 * leetcode 148
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SortList {
    public ListNode solution(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int sz = 1; sz < length; sz = sz + sz) {
            ListNode pre = dummyHead;
            head = dummyHead.next;
            while (head != null) {
                ListNode head1 = head;
                for (int i = 1; i < sz && head.next != null; i++) {
                    head = head.next;
                }
                ListNode head2 = head.next;
                head.next = null;
                head = head2;
                for (int i = 1; i < sz && head != null && head.next != null; i++) {
                    head = head.next;
                }
                if (head != null) {
                    ListNode next = head.next;
                    head.next = null;
                    head = next;
                }
                pre.next = merge(head1, head2);
                while (pre.next != null) {
                    pre = pre.next;
                }

            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0, null);
        ListNode temp = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 == null) {
            temp.next = head2;
        }
        if (head2 == null) {
            temp.next = head1;
        }
//        temp = dummyHead.next;
//        while (temp != null) {
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
//        System.out.println();
        return dummyHead.next;
    }

    public ListNode testCase() {
        ListNode head = new ListNode(-1, null);
        ListNode temp = null;
        for (int i = 0; i < 100; i++) {
            temp = new ListNode(i, null);
            temp.next = head.next;
            head.next = temp;
        }
//        temp = head;
//        while (temp != null) {
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
//        System.out.println();
        return head;
    }
    public static void main(String[] args) {
        SortList a = new SortList();
        ListNode TestCase = a.testCase();
        ListNode head = a.solution(TestCase);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}