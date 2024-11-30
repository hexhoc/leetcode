package problems.binary_tree_general;

import static util.Assertions.assertEquals;

import util.TreeNode;

/*
104. Maximum Depth of Binary Tree
 */
public class _104_MaximumDepthOfBinaryTree {
    /*
        1
       / \
      2   3
     / \   \
    4   5   6

    should return [4, 2, 5, 1, 3, 6]
    */
    public static void main(String[] args) {
        var s = new _104_MaximumDepthOfBinaryTree();

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

        assertEquals(3, s.maxDepth(tree1));

        tree1 = new TreeNode(1);
        tree2 = new TreeNode(2);
        tree1.left = tree2;

        assertEquals(2, s.maxDepth(tree1));
    }

    public int maxDepth(TreeNode root) {
        return recurseMaxDepth(root, 1);
    }

    public int recurseMaxDepth(TreeNode node, int currentDepth) {
        if (node == null) {
            return currentDepth - 1;
        } else {
            return Math.max(
                recurseMaxDepth(node.left, currentDepth + 1),
                recurseMaxDepth(node.right, currentDepth + 1));
        }
    }
}
