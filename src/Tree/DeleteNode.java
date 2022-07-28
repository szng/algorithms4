package Tree;

public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode dummyNode = new TreeNode();
        dummyNode.left = root;
        TreeNode cur = root, pre = dummyNode;
        while (cur != null) {
            if (cur.val < key) {
                pre = cur;
                cur = cur.right;
            } else if (cur.val > key) {
                pre = cur;
                cur = cur.left;
            } else {
                break;
            }
        }
        if (cur == null) {
            return dummyNode.left;
        }
        if (cur.left == null) {
            if (pre.left == cur) {
                pre.left = cur.right;
            } else {
                pre.right = cur.right;
            }
        } else if (cur.right == null) {
            if (pre.left == cur) {
                pre.left = cur.left;
            } else {
                pre.right = cur.left;
            }
        } else {
            TreeNode successor = cur;
            pre = successor;
            successor = successor.right;
            while (successor.left != null) {
                pre = successor;
                successor = successor.left;
            }
            cur.val = successor.val;
            if (pre == cur) {
                pre.right = successor.right;
            } else {
                pre.left = successor.right;
            }
        }
        return dummyNode.left;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode successor = root;
                successor = successor.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.right = deleteNode(root.right, successor.val);
                successor.left = root.left;
                successor.right = root.right;
                return successor;
            }

        }
        return root;
    }
}
