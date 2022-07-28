package Tree;


/**
 * leetcode 236
 */
public class LowestCommonAncestor {
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (left != null && right != null) {
            result = root;
            return root;
        }
        if ((left != null || right != null) && (root == p || root == q)) {
            result = root;
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        if (root == p || root == q) {
            return root;
        }
        return null;
    }

    private boolean helper2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = helper2(root.left, p, q);
        boolean right = helper2(root.right, p, q);
        if ((left && right) || (root == p || root == q) && (left || right)) {
            result = root;
        }
        return left || right || root == p || root == q;
    }
}
