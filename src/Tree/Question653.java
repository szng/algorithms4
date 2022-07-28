package Tree;

import java.util.ArrayList;
import java.util.List;


public class Question653 {
    private List<Integer> data = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        Integer[] result = data.toArray(new Integer[0]);

        int left = 0, right = result.length - 1;
        while (left < right) {
            int ans = result[left] + result[right];
            if (ans == k) {
                return true;
            } else if (ans > k) {
                --right;
            } else {
                ++left;
            }
        }
        return false;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        data.add(root.val);
        inorder(root.right);
    }
}
