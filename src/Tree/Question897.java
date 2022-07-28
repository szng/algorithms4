package Tree;

/**
 * 右中左遍历，保留前一个节点
 */
public class Question897 {
    private TreeNode pre = null;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        increasingBST(root.right);
        root.right = pre;
        pre = root;
        TreeNode temp = root.left;
        root.left = null;
        TreeNode left = increasingBST(temp);
        if (left != null) {
            return left;
        } else {
            return root;
        }
    }

    //中序遍历，造一个头节点
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummyNode = pre;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        root.left = null;
        pre.right = root;
        pre = root;
        inorder(root.right);
    }
}
