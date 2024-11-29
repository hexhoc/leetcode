package problems.binary_tree_general;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import util.TreeNode;

/**
 * 94. Binary Tree Inorder Traversal
 * #Binary tree
 * #Graph traversal
 */
public class _94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        var s = new _94_BinaryTreeInorderTraversal();
        /*
            1
           / \
          2   3
         / \   \
        4   5   6

        should return [4, 2, 5, 1, 3, 6]
        */

        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree5 = new TreeNode(5);
        TreeNode tree6 = new TreeNode(6);
        tree1.left = tree2;
        tree1.right = tree3;
        tree2.left = tree4;
        tree2.right = tree5;
        tree3.right = tree6;

        s.inorderTraversal(tree1);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        DFS(root, result);
        return result;
    }

    public void DFS(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        DFS(node.left,res);
        res.add(node.val);
        DFS(node.right, res);
    }
}
