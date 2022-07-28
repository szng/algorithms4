package Tree;

import java.util.HashMap;
import java.util.Map;

public class Question105 {
    private Map<Integer, Integer> data = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            data.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, n - 1, 0);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right, int start) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = data.get(preorder[start]);
        root.left = helper(preorder, inorder, left, index - 1, start + 1);
        root.right = helper(preorder, inorder, index + 1, right, start + index - left + 1);
        return root;
    }
}
