package Tree;

import java.util.*;

public class Question144 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        preorder(root);
        return result;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            result.add(node.val);
            if (node.right != null) {
                queue.push(node.right);
            }
            if (node.left != null) {
                queue.push(node.left);
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root, MorrisRight = null;
        while (cur != null) {
            MorrisRight = cur.left;
            if (MorrisRight != null) {
                while (MorrisRight.right != null && MorrisRight.right != cur) {
                    MorrisRight = MorrisRight.right;
                }
                if (MorrisRight.right == null) {
                    MorrisRight.right = cur;
                    result.add(cur.val);
                    cur = cur.left;
                    continue;
                } else {
                    MorrisRight.right = null;
                }
            } else {
                result.add(cur.val);
            }
            cur = cur.right;
        }
        return result;
    }
}
