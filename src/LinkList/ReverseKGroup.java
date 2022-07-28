package LinkList;

/**
 * leetcode 25
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int i = 0;
        for (; i < k && cur != null; i++) {
            cur = cur.next;
        }
        if (cur == null && i < k) {
//            不需要排序的情况，刚好最后一个是null的话，把null当作一个节点，进入下一次递归
            return head;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = reverseKGroup(cur, k);
        for (int j = 0; j < k; j++) {
            cur = head;
            head = head.next;
            cur.next = dummyNode.next;
            dummyNode.next = cur;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Test test = new Test();
        ListNode node = test.intial(5);
        ReverseKGroup a = new ReverseKGroup();
        test.output(a.reverseKGroup(node, 2));
    }
}
