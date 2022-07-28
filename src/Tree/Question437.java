package Tree;

public class Question437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathStart(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int pathStart(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int count;
        if (targetSum == root.val) {
            count = 1;
        } else {
            count = 0;
        }
        count += pathStart(root.left, targetSum - root.val);
        count += pathStart(root.right, targetSum - root.val);
        return count;
    }
}
