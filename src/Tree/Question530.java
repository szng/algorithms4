package Tree;


public class Question530 {
    private int pre = -1;
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinimumDifference(root.left);
        if (pre != -1) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}
