package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * leetcode 94
 */
public class InorderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        TreeNode node = null;
        while (root != null) {
            if (root.left != null) {
                node = root.left;
                while (node.right != null && node.right != root) {
                    node = node.right;
                }
                if (node.right == null) {
                    node.right = root;
                    root = root.left;
                    continue;
                } else {
                    node.right = null;
                }
            }
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
