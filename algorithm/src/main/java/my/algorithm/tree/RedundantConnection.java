package my.algorithm.tree;

import java.util.HashSet;
import java.util.Set;

public class RedundantConnection {
	public Set<Integer> nodeSet = new HashSet<>();
	
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int[] result = new int[2];
		return result;
    }
	
	public static void main(String[] args) {
		RedundantConnection rc = new RedundantConnection();
		
		int[][] edges = new int[][]{{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
		
		
	}
}
