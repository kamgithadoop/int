package list;

import graph.DirectedGraph;
import graph.Graph;

import org.junit.Test;

public class GraphTest {
	@Test
	public void graph() throws Exception {
		createGraph().bfs();
		createGraph().dfs();
	}
	
	
	@Test
	public void dGraph() throws Exception {
		createDGraph().topo();
	}
	
	private Graph<String> createGraph(){
		Graph<String> graph = new Graph<String>();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		
		graph.addEdge("A", "B");
		graph.addEdge("A", "F");
		graph.addEdge("A", "G");

		graph.addEdge("B", "C");
		graph.addEdge("B", "A");
		
		graph.addEdge("C", "D");
		graph.addEdge("C", "B");
		
		graph.addEdge("D", "E");
		graph.addEdge("D", "H");
		graph.addEdge("D", "C");
		graph.addEdge("G", "H");
		return graph;
	}
	
	
	private DirectedGraph<String> createDGraph(){
		DirectedGraph<String> graph = new DirectedGraph<String>();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		
		graph.addEdge("A", "D");
		graph.addEdge("A", "E");
		graph.addEdge("A", "G");

		graph.addEdge("B", "E");
		
		graph.addEdge("C", "F");
		
		graph.addEdge("D", "G");
		graph.addEdge("E", "G");

		graph.addEdge("G", "H");
		graph.addEdge("F", "H");
		return graph;
	}
	
	private DirectedGraph<String> createGraph2(){
		DirectedGraph<String> graph = new DirectedGraph<String>();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		
		
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("A", "E");

		graph.addEdge("B", "A");
		graph.addEdge("B", "C");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");

		graph.addEdge("C", "A");
		graph.addEdge("C", "B");
		graph.addEdge("C", "D");
		graph.addEdge("C", "E");

		graph.addEdge("B", "A");
		graph.addEdge("B", "C");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");

		return graph;
	}
}
