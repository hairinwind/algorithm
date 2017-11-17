package my.algorithm.graph;

import java.util.HashMap;
import java.util.Map;

public class GraphClone {
	private Map<Integer, UndirectedGraphNode> map = new HashMap<>();
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
		
		if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node.label, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(cloneGraph(neighbor));
		}
		return clone;
	}
	
	public static void main(String[] args) {
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node3 = new UndirectedGraphNode(3);
		
		node1.neighbors.add(node0);
		node1.neighbors.add(node2);
		node0.neighbors.add(node1);
		node0.neighbors.add(node2);
		node2.neighbors.add(node0);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node1);
		
		GraphClone graphClone = new GraphClone();
		UndirectedGraphNode clone = graphClone.cloneGraph(node1);
		
		System.out.println(clone.label);
		for (UndirectedGraphNode neighbor : clone.neighbors) {
			System.out.println("-" + neighbor.label);
			for (UndirectedGraphNode neighbor1 : neighbor.neighbors) {
				System.out.println("--" + neighbor1.label + " ");
				if (neighbor1.label == 3) {
					for (UndirectedGraphNode neighbor2 : neighbor1.neighbors) {
						System.out.println("---" + neighbor2.label + " ");
					}
				}
			}
		}
		
	}
	
}
