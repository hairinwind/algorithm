package my.algorithm.tree;

/**
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
 * http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 */
public class TreeMaxPath {
	int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.value);
        return Math.max(left, right) + node.value;
    }
    
    public static void main(String args[]) {
    	TreeMaxPath treeMaxPath = new TreeMaxPath();
    	
    	TreeNode root = new TreeNode(10);
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(-25); 
		root.right.right.left = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		
		treeMaxPath.maxPathDown(root);
		System.out.println(treeMaxPath.maxValue);
    }
}

