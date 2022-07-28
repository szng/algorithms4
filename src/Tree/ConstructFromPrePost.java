package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 889
 */
public class ConstructFromPrePost {
    private Map<Integer, Integer> data = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            data.put(postorder[i], i);
        }
        return constructFromPrePost(preorder, postorder, 0, n - 1, 0);
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder, int left, int right, int start) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = preorder[start];
        int length = preorder.length;
        if (left == right) {
            return node;
        }
        Integer index = data.get(preorder[start + 1]);
        node.left = constructFromPrePost(preorder, postorder, left, index, start + 1);
        node.right = constructFromPrePost(preorder, postorder, index+1, right - 1, start + index - left + 2);
        return node;
    }
}
