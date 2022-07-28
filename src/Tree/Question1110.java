package Tree;

import java.util.*;

public class Question1110 {
    private Set<Integer> data = new HashSet<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return null;
        }
        for (int i : to_delete) {
            data.add(i);
        }
        root = helper(root);
        if (root != null) {
            result.add(root);
        }
        return result;
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = helper(root.left);
        root.right = helper(root.right);
        if (data.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            root = null;
        }
        return root;
    }
}
