package Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Question513 {
    private int CurrentVal;
    private int CurrentHeight = -1;

    public int findBottomLeftValue(TreeNode root) {
        int result = 0;

        if (root == null) {
            return result;
        }

        Queue<TreeNode> data = new LinkedList<>();
        data.offer(root);

        while (!data.isEmpty()) {
            int size = data.size();
            TreeNode left = data.peek();
            result = left.val;

            for (int i = 0; i < size; i++) {
                TreeNode Node = data.poll();
                if (Node.left != null) {
                    data.offer(Node.left);
                }
                if (Node.right != null) {
                    data.offer(Node.right);
                }
            }
        }
        return result;
    }

    public int findBottomLeftValue2(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.right != null) {
                queue.offer(p.right);
            }
            if (p.left != null) {
                queue.offer(p.left);
            }
            ret = p.val;
        }
        return ret;
    }

    public int findBottomLeftValue3(TreeNode root) {
        helper(root, 0);
        return CurrentVal;
    }

    public void helper(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (CurrentHeight < height) {
            CurrentHeight = height;
            CurrentVal = root.val;
        }
        helper(root.left, height + 1);
        helper(root.right, height + 1);
    }
}
