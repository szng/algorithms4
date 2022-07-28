package LinkList;

/**
 * leetcode 160
 * 把末尾空指针也当作一个节点，可以分辨没有重合的场景
 * 即重合的是null
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa != null ? pa.next : headB;
            pb = pb != null ? pb.next : headA;
        }
        return pa;
    }
}
