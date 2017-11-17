package my.algorithm.tree;

import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 * binary search tree
 * 二叉排序树或者是空树，或者是满足如下性质的二叉树：
 * 若它的左子树非空，则左子树上所有结点的值均小于根结点的值；
 * 若它的右子树非空，则右子树上所有结点的值均大于根结点的值；
 * 左、右子树本身又各是一棵二叉排序树。
 *
 */
public class PreorderTraversalBinarySearchTree {

	public static boolean canRepresentBST(int pre[]) {
        int n = pre.length;
		// Create an empty stack
        Stack<Integer> s = new Stack<Integer>();
 
        // Initialize current root as minimum possible
        // value
        int root = Integer.MIN_VALUE;
 
        // Traverse given array
        for (int i = 0; i < n; i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (pre[i] < root) {
                return false;
            }
 
            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.pop();
            }
 
            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            s.push(pre[i]);
        }
        return true;
	}
	
	public static void main(String[] args) {
        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        System.out.println(PreorderTraversalBinarySearchTree.canRepresentBST(pre1));
        
        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
        System.out.println(PreorderTraversalBinarySearchTree.canRepresentBST(pre2));
	}

}
