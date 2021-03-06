package my.algorithm.graph;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 */
public class DFSGraph {
	public Map<Integer, UndirectedGraphNode> map = new LinkedHashMap<>();
	
	public void getUniqueNode(UndirectedGraphNode node) {
		if (node == null || map.containsKey(node.label)) return;
		map.put(node.label, node);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			getUniqueNode(neighbor);
		}
		return;
	}
	
	public static void main(String[] args) {
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node3 = new UndirectedGraphNode(3);
		UndirectedGraphNode node4 = new UndirectedGraphNode(4);
		
		node1.neighbors.add(node0);
		node1.neighbors.add(node2);
		node0.neighbors.add(node1);
		node0.neighbors.add(node3);
		node2.neighbors.add(node0);
		node2.neighbors.add(node1);
		node3.neighbors.add(node1);
		node3.neighbors.add(node4);
		
		DFSGraph graph = new DFSGraph();
		graph.getUniqueNode(node1);
		
		for (int nodeValue : graph.map.keySet()) {
			System.out.println(nodeValue);
		}
		
	}
}
