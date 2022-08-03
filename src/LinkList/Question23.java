package LinkList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        int MinVal, MinIndex;
        while (true) {
            MinVal = Integer.MAX_VALUE;
            MinIndex = -1;
            for (int i = 0; i < n; i++) {
                if (lists[i] != null && MinVal > lists[i].val) {
                    MinVal = lists[i].val;
                    MinIndex = i;
                }
            }
            if (MinIndex == -1) {
                break;
            }
            cur.next = lists[MinIndex];
            cur = cur.next;
            lists[MinIndex] = lists[MinIndex].next;
        }
        return dummyHead.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummyHead.next;
    }
}
