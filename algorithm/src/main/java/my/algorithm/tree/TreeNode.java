package my.algorithm.tree;

public class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		this.value = x;
	}
	public String toString() {
		return String.valueOf(this.value);
	}
}
