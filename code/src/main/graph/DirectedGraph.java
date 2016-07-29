package graph;

import java.util.HashMap;
import java.util.Map;

import graph.Graph.Vertex;

public class DirectedGraph<T> {
	
	private Map<T, Vertex<T>> vertices;
	
	
	
	public DirectedGraph() {
		vertices = new HashMap<T, Vertex<T>>();
	}
	
	public void addVertex(T data) {
		vertices.put(data, new Vertex<T>(data));
	}

	public void addEdge(T d1, T d2) {
		Vertex<T> vertex1 = vertices.get(d1);
		Vertex<T> vertex2 = vertices.get(d2);
		if (vertex1 != null && vertex2 != null) {
			vertex1.addNeighbour(vertex2);
		}
	}
	
	
	// Checks if two notes are connected 
	// This can be done by eith dfs or bfs search of graph 
	
	public boolean areConnected(T d1, T d2){
		Vertex<T> vertex1 = vertices.get(d1);
		Vertex<T> vertex2 = vertices.get(d2);
		return false;
	}

	public void topo(){
		Vertex[] arr = new Vertex[vertices.size()];
		boolean noSucc = false;
		int index = arr.length;
		while (index !=0) {
			for (Vertex<T> vet : vertices.values()) {
				if(vet.isDeleted()){
					continue;
				}
				if (!vet.hasNeigbours()) {
					vet.delete();
					index = index -1;
					arr[index] = vet;
				}
			}
		}
		for(int i =0; i < arr.length ; i++){
			System.out.print(arr[i].getData() + ",");
		}
		//BAEDGCFH
	}

	public Map<T, Vertex<T>> getVertices() {
		return vertices;
	}

	public void setVertices(Map<T, Vertex<T>> vertices) {
		this.vertices = vertices;
	}


}
