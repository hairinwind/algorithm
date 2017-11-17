package my.algorithm.tree;

/**
 * Given a Node object that has ID, parentID, and value fields, 
 * write a function that takes a list of Node objects 
 * and calculates the "total" for each Node in that list; 
 * a Node's "total" is the sum of all of its children's values + its own value.
 */
public class TreeSumWithAllChildren {
	public static int sum(TreeNode node) {
		if (node == null) return 0;
		if (node.left == null && node.right == null) {
			return node.value;
		}
		return node.value + sum(node.left) + sum(node.right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6); 
		root.right.left.right = new TreeNode(6); 
		
		System.out.println(sum(root));
	}
}

