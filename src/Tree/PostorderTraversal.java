package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * leetcode 145
 */
public class PostorderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == pre) {
                root = stack.pop();
                result.add(root.val);
                pre = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        if (root == null) {
            return result;
        }
        TreeNode MorriesRight;
        TreeNode first = root;
        while (root != null) {
            MorriesRight = root.left;
            if (MorriesRight != null) {
                while (MorriesRight.right != null && MorriesRight.right != root) {
                    MorriesRight = MorriesRight.right;
                }
                if (MorriesRight.right == null) {
                    MorriesRight.right = root;
                    root = root.left;
                    continue;
                } else {
                    MorriesRight.right = null;
                    addPath(result, root.left);
                }
            }
            root = root.right;
        }
        addPath(result, first);
        return result;
    }

    private void addPath(List<Integer> result, TreeNode root) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        while (root != null) {
//            stack.push(root.val);
//            root = root.right;
//        }
//        while (!stack.isEmpty()) {
//            result.add(stack.pop());
//        }
        int count = 0;
        while (root != null) {
            result.add(root.val);
            ++count;
            root = root.right;
        }
        int left = result.size() - count, right = result.size() - 1;
        while (left < right) {
            int temp = result.get(left);
            result.set(left, result.get(right));
            result.set(right, temp);
            ++left;
            --right;
        }
    }
}
