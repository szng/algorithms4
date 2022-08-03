package Tree;

import java.util.*;

public class Question103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        boolean reversed = false;
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Integer> deque = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (reversed) {
                    deque.offerFirst(node.val);
                }else {
                    deque.offerLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ArrayList<Integer> list = new ArrayList<>(deque);
            deque.clear();
            results.add(list);
            reversed = !reversed;
        }
        return results;
    }
}
