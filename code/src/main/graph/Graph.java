package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class Graph<T> {

	private Map<T, Vertex<T>> vertices;

	public Graph() {
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
			vertex2.addNeighbour(vertex1);
		}
	}

	public void bfs() throws Exception{
		System.out.println();
		System.out.println("dfs");

		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		Vertex<T> startVertex = vertices.get(vertices.keySet().iterator()
				.next());
		startVertex.visit();
		queue.offer(startVertex);
		while (!queue.isEmpty()) {
			Vertex<T> dVert =  queue.poll();
			Vertex<T> vert = getNotVisited(dVert);
			while(vert != null){
				vert.visit();
				queue.offer(vert);
				vert = getNotVisited(dVert);
			}
		}
	}
	
	public void revisit(){
		
	}

	/**
	 *  1) Rule visit and push to stack 
	 *  2) No unvisited neighbours pop from stack
	 *  3) Continue until no stack is empty.
	 */
	public void dfs() {
		System.out.println();

		System.out.println("bfs");
		Stack<Vertex<T>> stck = new Stack<Vertex<T>>();
		Vertex<T> startVertex = vertices.get(vertices.keySet().iterator()
				.next());
		System.out.print(startVertex.getData());
		startVertex.visit();
		stck.push(startVertex);
		while (!stck.isEmpty()) {
			Vertex<T> current  = stck.peek();
			Vertex<T> vert = getNotVisited(current);
			if (vert == null) {
				stck.pop();
			} else {
				vert.visit();
				System.out.print(current.getData());
				System.out.print(vert.getData() + "  ");
				//System.out.print(vert.getData() + " ");
				stck.push(vert);
			}
		}
	}

	public void mst() {
		System.out.println();

		System.out.println("mst");
		Stack<Vertex<T>> stck = new Stack<Vertex<T>>();
		Vertex<T> startVertex = vertices.get(vertices.keySet().iterator()
				.next());
		System.out.print(startVertex.getData());
		startVertex.visit();
		stck.push(startVertex);
		while (!stck.isEmpty()) {
			Vertex<T> current  =stck.peek();
			Vertex<T> vert = getNotVisited(current);
			if (vert == null) {
				stck.pop();
			} else {
				vert.visit();
				System.out.print(current.getData());
				System.out.print(vert.getData() + "  ");
				//System.out.print(vert.getData() + " ");
				stck.push(vert);
			}
		}
	}
	public Vertex<T> getNotVisited(Vertex<T> vert) {
		List<Vertex<T>> nebs = vert.getNeigbours();
		for (Vertex<T> neb : nebs) {
			if (neb.isVisited() == false) {
				return neb;
			}
		}
		return null;
	}

	public Map<T, Vertex<T>> getVertices() {
		return vertices;
	}

	public void setVertices(Map<T, Vertex<T>> vertices) {
		this.vertices = vertices;
	}
	
	public static class Edge<T>{
		public int weight;
		
		public Vertex<T> vertex1;
		
		public Vertex<T> vertex2;
		
		public Vertex<T> getVertex(Vertex<T> v){
			return (vertex2.getData().equals(v.getData()) ? vertex1 : vertex2);
		}
		
	}
	
	
	public static class Vertex<T>  {
		private T data;

		private boolean visited;
		
		private boolean deleted;
		
		public Vertex<T> parent;
		
		public long key;

		private List<Vertex<T>> neigbours;
		
		public List<Edge<T>> edges;
		public Vertex(){
			
		}
		public Vertex(T data) {
			this.data = data;
			this.neigbours = new LinkedList<Vertex<T>>();
			edges = new LinkedList<Edge<T>>();
			this.key = Long.MAX_VALUE;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public List<Vertex<T>> getNeigbours() {
			return neigbours;
		}
		
		public boolean hasNeigbours() {
			boolean hasNeigbours = false;
			if(neigbours == null){
				return false;
			}
			for(Vertex<T> vet : neigbours){
				if(!vet.isDeleted()){
					hasNeigbours = true;
					break;
				}
			}
			return hasNeigbours;
		}

		public void setNeigbours(List<Vertex<T>> neigbours) {
			this.neigbours = neigbours;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public void addNeighbour(Vertex<T> vertext) {
			neigbours.add(vertext);
		}

		public void addEdge(Edge<T> edge) {
			this.edges.add(edge);
		}

		public void visit() {
			visited = true;
		}
		public void delete() {
			deleted = true;
		}
		
		public boolean isDeleted(){
			return deleted;
		}

//		@Override
//		public int compareTo(Vertex<T> other) {
//			int ret = -1;
//			if(other.key == key){
//				ret = 0;
//			}else if( other.key < key) {
//				ret = 1;
//			}
//			return ret;
//		}
	}
}
