package Tree;

public class Question404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    public int helper(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (left && root.left == null && root.right == null) {
            return root.val;
        }else {
            count += helper(root.left, true);
            count += helper(root.right, false);
        }
        return count;
    }
}
