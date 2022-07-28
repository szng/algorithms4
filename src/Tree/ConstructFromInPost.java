package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 106
 */
public class ConstructFromInPost {
    private Map<Integer, Integer> data = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            data.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, n - 1, n - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int left, int right, int root) {
        if (left > right) {
            return null;
        }
        int index = data.get(postorder[root]);
        TreeNode node = new TreeNode();
        node.val = postorder[root];
        node.left = buildTree(inorder, postorder, left, index - 1, root - (right - index) - 1);
        node.right = buildTree(inorder, postorder, index + 1, right, root - 1);
        return node;
    }
}
