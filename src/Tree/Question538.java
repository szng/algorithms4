package Tree;

public class Question538 {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return ;
        }
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }
}
