package Tree;

/**
 * 找到两个违反大小顺序的相邻组合，将第一个组合中的第一个数和第二个组合中的第二个数交换
 */

public class Question99 {
    private TreeNode mistake1;
    private TreeNode mistake2;
    private TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        in_order(root);
        int temp = mistake1.val;
        mistake1.val = mistake2.val;
        mistake2.val = temp;
    }

    public void in_order(TreeNode root) {
        if (root == null) {
            return;
        }
        in_order(root.left);
        if (pre != null && pre.val > root.val) {
            mistake2 = root;
            if (mistake1 == null) {
                mistake1 = pre;
            }
        }
        pre = root;
        in_order(root.right);
    }
}
