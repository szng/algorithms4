package Search.Question;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question257 {
    private List<String> results;

    public List<String> binaryTreePaths(TreeNode root) {
        results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        backTracking(root, "");
        return results;
    }

    private void backTracking(TreeNode root, String path) {
        StringBuilder result = new StringBuilder(path);
        result.append(root.val);
        if (root.left == null && root.right == null) {
            results.add(result.toString());
            return;
        }
        result.append("->");
        if (root.left != null) {
            backTracking(root.left, result.toString());
        }
        if (root.right != null) {
            backTracking(root.right, result.toString());
        }

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.test(5);
        TreeNode.output(root);
        Question257 a = new Question257();
        List<String> results = a.binaryTreePaths(root);
        for (String result : results) {
            System.out.println(result);
        }
    }
}
