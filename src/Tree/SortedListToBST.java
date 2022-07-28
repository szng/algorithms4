package Tree;

import LinkList.ListNode;

/**
 * leetcode 109
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        TreeNode node = new TreeNode();
        node.val = slow.val;
        if (pre != null) {
            pre.next = null;
            node.left = sortedListToBST(head);
        }
        // pre == null即没有左子树了
        node.right = sortedListToBST(slow.next);
        return node;
    }
}
