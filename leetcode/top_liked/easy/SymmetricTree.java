package top_liked.easy;

import util.TreeNode;

/*
101. Symmetric Tree
#Binary tree
#Graph traversal
 */
public class SymmetricTree {

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

        var s = new SymmetricTree();
        System.out.println(s.isSymmetric(tree1));
    }

    public boolean isSymmetric(TreeNode root) {
        return compareNode(root.left, root.right);
    }

    public boolean compareNode(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }

        if (leftNode == null || rightNode == null
                || leftNode.val != rightNode.val) {
            return false;
        }

        return compareNode(leftNode.left, rightNode.right)
                && compareNode(leftNode.right, rightNode.left);
    }
}
