package Tree;

import java.util.ArrayDeque;

public class Question112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayDeque<Integer> sum = new ArrayDeque<>();
        queue.offer(root);
        sum.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int temp = sum.poll();
            if (node.left == null && node.right == null && targetSum == temp) {
                return true;
            }
            if (node.left != null) {
                queue.offer(node.left);
                sum.offer(temp + node.left.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                sum.offer(temp + node.right.val);
            }
        }
        return false;
    }
}
