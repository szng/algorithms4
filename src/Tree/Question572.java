package Tree;

public class Question572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean result = helper(root, subRoot);
        if (root != null) {
            result = result || isSubtree(root.left, subRoot);
            result = result || isSubtree(root.right, subRoot);
        }
        return result;
    }

    public boolean helper(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }
}
