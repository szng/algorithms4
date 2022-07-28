package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode test(int n) {
        if (n == 0) {
            return null;
        }
        TreeNode result = new TreeNode(n);
        result.left = test(n - 1);
        result.right = test(n - 1);
        return result;
    }

    public static void output(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    return;
                }
                System.out.print(temp.val + " ");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.test(5);
        TreeNode.output(root);
    }
}
