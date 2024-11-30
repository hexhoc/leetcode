package problems.binary_tree_general;

import static util.Assertions.assertEquals;

import util.TreeNode;

/*
101. Symmetric Tree
* Binary tree
* Graph traversal
*/
public class _101_SymmetricTree {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2_1 = new TreeNode(2);
        TreeNode tree2_2 = new TreeNode(2);
        TreeNode tree3_1 = new TreeNode(3);
        TreeNode tree3_2 = new TreeNode(3);
        TreeNode tree4_1 = new TreeNode(4);
        TreeNode tree4_2 = new TreeNode(4);
        tree1.left = tree2_1;
        tree1.right = tree2_2;
        tree2_1.left = tree3_1;
        tree2_1.right = tree4_1;
        tree2_2.left = tree4_2;
        tree2_2.right = tree3_2;

        var s = new _101_SymmetricTree();
        assertEquals(true, s.isSymmetric(tree1));
    }

    public boolean isSymmetric(TreeNode root) {
         return recursiveCompareNode(root.left, root.right);
    }

    private boolean recursiveCompareNode(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        if (node1.val == node2.val) {
            return recursiveCompareNode(node1.left, node2.right)
                && recursiveCompareNode(node1.right, node2.left);
        }
        return false;
    }
}
