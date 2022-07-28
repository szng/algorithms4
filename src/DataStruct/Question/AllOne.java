package DataStruct.Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 432
 */
public class AllOne {
    class ListNode {
        Set<String> keys;
        int value;
        ListNode pre;
        ListNode next;

        public ListNode() {
        }

        public ListNode(String key, int value) {
            this.keys = new HashSet<>();
            this.keys.add(key);
            this.value = value;
        }

        public ListNode insert(ListNode node) {  // 在 this 后插入 node
            node.pre = this;
            node.next = this.next;
            node.pre.next = node;
            node.next.pre = node;
            return node;
        }

        public void remove() {
            this.pre.next = this.next;
            this.next.pre = this.pre;
        }

    }

    private Map<String, ListNode> map;
    private ListNode root;

    public AllOne() {
        map = new HashMap<>();
        root = new ListNode();
        root.next = root;
        root.pre = root;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            ListNode cur = map.get(key);
            ListNode next = cur.next;
            if (next == root || next.value > cur.value + 1) {
                map.put(key, cur.insert(new ListNode(key, cur.value + 1)));
            } else {
                next.keys.add(key);
                map.put(key, next);
            }
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                cur.remove();
            }
        } else {
            if (root.next == root || root.next.value > 1) {
                map.put(key, root.insert(new ListNode(key, 1)));
            } else {
                root.next.keys.add(key);
                map.put(key, root.next);
            }
        }
    }

    public void dec(String key) {
//        if (map.get(key) == null) {
//            return;
//        }
        ListNode node = map.get(key);
        if (node.value == 1) {
            map.remove(key);
        }else{
            ListNode pre = node.pre;
            if (pre == root || pre.value < node.value - 1) {
                map.put(key, node.pre.insert(new ListNode(key, node.value - 1)));
            } else {
                pre.keys.add(key);
                map.put(key, pre);
            }
        }

        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            node.remove();
        }
    }

    public String getMaxKey() {
        if (root.pre == root) {
            return "";
        }
        return root.pre.keys.iterator().next();
    }

    public String getMinKey() {
        if (root.next == root) {
            return "";
        }
        return root.next.keys.iterator().next();
    }
}
