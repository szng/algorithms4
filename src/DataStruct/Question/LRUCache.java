package DataStruct.Question;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 146
 */
public class LRUCache {
    static class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private int size;
    private final Map<Integer, ListNode> data;
    private final ListNode head;
    private final ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new ListNode();
        tail = new ListNode();
        ListNode dummyNode = new ListNode();
        head.next = tail;
        tail.pre = head;
        data = new HashMap<>();
    }

    public int get(int key) {
        if (data.get(key) == null) {
            return -1;
        }

        return visit(key).value;
    }

    public void put(int key, int value) {
        if (data.get(key) != null) {
            visit(key).value = value;
            return;
        }
        if (size == capacity) {
            data.remove(tail.pre.key);
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
            --size;
        }
        ListNode node = new ListNode(key, value);
        data.put(key, node);
        ++size;
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    private ListNode visit(int key) {
        ListNode cur = data.get(key);
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;

        cur.next = head.next;
        head.next.pre = cur;
        head.next = cur;
        cur.pre = head;
        return cur;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.get(1);
        cache.put(2, 2);
        cache.get(2);
    }
}
