package my.algorithm.tree;

/**
 * Full Binary Tree means no node has only one child node
 *
 */
public class FullBinaryTree {
	public static boolean isFull(TreeNode node) {
		if (node == null) return false;
		return isFull(node.left) == isFull(node.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.right = new TreeNode(40);
        root.left.left = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.left.left.left = new TreeNode(80);
        root.right.right = new TreeNode(70);
        root.left.left.right = new TreeNode(90);
        root.left.right.left = new TreeNode(80);
        root.left.right.right = new TreeNode(90);
        root.right.left.left = new TreeNode(80);
        root.right.left.right = new TreeNode(90);
        root.right.right.left = new TreeNode(80);
        root.right.right.right = new TreeNode(90);
        
        System.out.println(isFull(root));
	}
}
