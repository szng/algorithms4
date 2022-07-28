package Tree;

/**
 * 先序遍历，满足值在pq中间，最先找到的一定是最近公共祖先
 * 左子树所有节点小于root，右子树所有节点大于root
 */
public class Question235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int small = p.val;
        int large = q.val;
        if (small > large) {
            int temp = small;
            small = large;
            large = temp;
        }
        return helper(root, small, large);
    }

    public TreeNode helper(TreeNode root, int left, int right) {
        if (root == null) {
            return null;
        }
        if (root.val < left) {
            return helper(root.right, left, right);
        } else if (root.val > right) {
            return helper(root.left, left, right);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int small = p.val;
        int large = q.val;
        if (small > large) {
            int temp = small;
            small = large;
            large = temp;
        }
        while (root != null && (root.val < small || root.val > large)) {
            if (root.val < small) {
                root = root.right;
            }
            if (root.val > large) {
                root = root.left;
            }
        }
        return root;
    }
}
