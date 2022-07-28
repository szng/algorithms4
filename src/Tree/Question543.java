package Tree;

public class Question543 {
    private int MaxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return MaxDiameter;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        MaxDiameter = Math.max(MaxDiameter, left + right);
        return Math.max(left, right) + 1;
    }
}
