package Mathmethica;

import java.util.Random;

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

public class Question382 {
    private ListNode num;
    Random r;
    public Question382(ListNode head) {
        num = head;
        r = new Random();
    }

    public int getRandom() {
        ListNode pre = num;
        int count = 1;
        int result = pre.val;
        while (pre != null) {
            if (r.nextInt(count++) == 0) {
                result = pre.val;
            }
            pre = pre.next;
        }
        return result;
    }
}

