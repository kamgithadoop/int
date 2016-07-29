package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import graph.Graph.Edge;
import graph.Graph.Vertex;
import list.DisjointSet;
import list.LinkDisjointSet;
import list.PriQueue;
import list.TreeDisjointSet;

public class WeightedGraph<T> {
	private Vertex[] vertices;
	private Edge[] edges;
	private int currentVIndex;
	private int currentEIndex;
	
	private static int MAX_VERTEX = 30;
	
	private DisjointSet<String> disjointSet;
	
	private List<LinkDisjointSet<T>> linkDisjointSet;

	private Map<T, TreeDisjointSet<T>> treeDisjointSets;
	
	public WeightedGraph() {
		vertices = new Vertex[MAX_VERTEX];
		edges = new Edge[MAX_VERTEX-1];
		currentVIndex=0;
		currentEIndex=0;
		disjointSet = new DisjointSet<String>();
		linkDisjointSet = new ArrayList<LinkDisjointSet<T>>();
		treeDisjointSets = new HashMap<T, TreeDisjointSet<T>>();
	}
	
	public WeightedGraph(int vertexSize, int EdgeSize) {
		vertices = new Vertex[vertexSize];
		edges = new Edge[EdgeSize];
		currentVIndex=0;
		currentEIndex=0;
		disjointSet = new DisjointSet<String>();
		linkDisjointSet = new ArrayList<LinkDisjointSet<T>>();
		treeDisjointSets = new HashMap<T, TreeDisjointSet<T>>();
	}
	
	public void addVertex(Vertex<T> ver) {
		vertices[currentVIndex++] =  ver;
	}

	@SuppressWarnings("rawtypes")
	public void addDirectedEdge(Vertex<T> v1, Vertex<T> v2, int weight) {
		Edge ed = new Edge();
		ed.vertex1 = v1;
		ed.vertex2 = v2 ;
		ed.weight = weight;
		v1.addNeighbour(v2);
		v1.addEdge(ed);
		edges[currentEIndex++] = ed;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public void addEdge(Vertex<T> v1, Vertex<T> v2, int weight) {
		Edge ed = new Edge();
		ed.vertex1 = v1;
		ed.vertex2 = v2 ;
		ed.weight = weight;
		v1.addNeighbour(v2);
		v2.addNeighbour(v1);
		v1.addEdge(ed);
		v2.addEdge(ed);
		edges[currentEIndex++] = ed;
	}
	
	public  Edge<T>[] mstKruskal(){
		populateDisjointSet();
		Edge[] mst = new Edge[currentEIndex+1];
		sort(edges, currentEIndex+1);
		int index = 0;
		for(Edge<T> ed : edges){
			if(ed == null){
				continue;
			}
			Vertex<T> v1 = ed.vertex1;
			Vertex<T> v2 = ed.vertex2;

			String str1 = (String)v1.getData();
			String str2 = (String)v2.getData();
			String setKey1 = (String)disjointSet.findSet(str1);
			String setKey2 = (String)disjointSet.findSet(str2);
			if(!(setKey1.equals(setKey2))){
				mst[index++] = ed;
				disjointSet.union(setKey1,setKey2);
			}
		}
		return mst;
	}
	@SuppressWarnings("unchecked")
	public  Edge<T>[] mstKruskalTree(){
		this.populateTreeDisjointSet();
		Edge[] mst = new Edge[currentEIndex+1];
		sort(edges, currentEIndex+1);
		int index = 0;
		for(Edge<T> ed : edges){
			if(ed == null){
				continue;
			}
			Vertex<T> v1 = ed.vertex1;
			Vertex<T> v2 = ed.vertex2;

			T str1 = v1.getData();
			T str2 = v2.getData();
			TreeDisjointSet<T> set1 =treeDisjointSets.get(str1) ;
			TreeDisjointSet<T> set2 = treeDisjointSets.get(str2);
			TreeDisjointSet<T> parent1 = set1.findSet(set1);
			TreeDisjointSet<T> parent2 = set2.findSet(set2);
			if(!(parent1.getValue().equals(parent2.getValue()))){
				mst[index++] = ed;
				parent1.union(parent2);
			}
		}
		return mst;
	}
	
	@SuppressWarnings("unchecked")
	public  Edge<T>[] mstKruskalLink(){
		populateLinkDisjointSet();
		Edge[] mst = new Edge[currentEIndex+1];
		sort(edges, currentEIndex+1);
		int index = 0;
		for(Edge<T> ed : edges){
			if(ed == null){
				continue;
			}
			Vertex<T> v1 = ed.vertex1;
			Vertex<T> v2 = ed.vertex2;

			T str1 = v1.getData();
			T str2 = v2.getData();
			LinkDisjointSet<T> set1 = null;
			LinkDisjointSet<T> set2 = null;
			for(LinkDisjointSet<T> set : linkDisjointSet){
				if(set1 != null && set2 != null){
					break;
				}
				if(set1 == null){
					set1 = set.findSet(str1);
				}
				if(set2 == null){
					set2 = set.findSet(str2);
				}
			}
			if(!(set1.getHead().getValue().equals(set2.getHead().getValue()))){
				mst[index++] = ed;
				set1.union(set2);
			}
		}
		return mst;
	}
	
	@SuppressWarnings("unchecked")
	private void populateTreeDisjointSet(){
		for(Vertex<T> vert : vertices){
			if(vert == null){
				continue;
			}
			TreeDisjointSet<T> treeDisjointSet = new TreeDisjointSet<T>(vert.getData());
			treeDisjointSets.put(vert.getData(), treeDisjointSet);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void populateLinkDisjointSet(){
		for(Vertex<T> vert : vertices){
			if(vert == null){
				continue;
			}
			LinkDisjointSet<T> linkDisjointSet = new LinkDisjointSet<T>();
			linkDisjointSet.add(vert.getData());
			this.linkDisjointSet.add(linkDisjointSet);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void populateDisjointSet(){
		for(Vertex<T> vert : vertices){
			if(vert == null){
				continue;
			}
			this.disjointSet.addToSet((String)vert.getData(),(String)vert.getData());
		}
	}
	private void sort(Edge[] edges, int length){
		for(int out=0 ; out < (length -1); out++){
			int min = out ;
			for(int in= out +1 ; in < (length -1);in++){
				if(edges[in].weight < edges[min].weight){
					min = in;
				}
			}
			Edge<T> temp = edges[out];
			edges[out] = edges[min];
			edges[min] = temp;
		}
	}
	
	public void spBellmanFord(){
		vertices[0].key=0;
		boolean shortestPath=true;
		for(int i = 0; i < vertices.length -2; i++){
			for(Edge<T> ed : edges){
				relaxEdge(ed);
			}
		}
		for(Edge<T> edge : edges){
			Vertex<T> start = edge.vertex1;
			Vertex<T> end = edge.vertex2;
			if(end.key > edge.weight + start.key){
				shortestPath=false;
			}
		}
		if(!shortestPath){
			System.out.println("Shortest path not possible");
		}else{
			for(Vertex<T> v : this.vertices){
				if(v == null) continue;
				System.out.println((v.parent == null ? "" : v.parent.getData())
						+ "" + v.getData() + "(" + v.key + ")");
			}
		}
	}
	
	private boolean relaxEdge(Edge<T> edge){
		if(edge == null){
			return false;
		}
		Vertex<T> start = edge.vertex1;
		Vertex<T> end = edge.vertex2;
		if(end.key > edge.weight + start.key){
			end.key = edge.weight + start.key;
			end.parent = start;
			return true;
		}else{
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void mstPrims(){
		this.vertices[0].key= 0l;
		PriQueue pQueue = new PriQueue(9);
		for(Vertex<T> v : this.vertices){
			if(v != null){
				pQueue.add(v);
			}
		}
		List<Edge<T>> mst = new LinkedList<Edge<T>>();
		while(pQueue.size() != 0){
			Vertex<T> current = pQueue.poll();
			if(current.edges != null ){
				for(Edge<T> edge : current.edges){
					Vertex<T> neigh = edge.getVertex(current);
					if(pQueue.contains(neigh) && edge.weight < neigh.key ){
						neigh.key = edge.weight;
						neigh.parent =current;
					}
				}
			}
		}
	
		for(Vertex<T> v : this.vertices){
			if(v == null || v.parent == null) continue;
			System.out.println(v.parent.getData()
					+ "" + v.getData() + "(" + v.key + ")");
		}
	}
	
	/**
	DIJKSTRA.G;w; s/
		INITIALIZE-SINGLE-SOURCE.G; s
		S = 0  ;
		Q = G.V
		while Q != 0 ;
			u = EXTRACT-MIN.Q
			S =  S + u 
			for each vertex v in G:Adj(u)
 				RELAX(u,v,w)
 	*/
	
	public void spDijkstra(){
		this.vertices[0].key= 0l;
		//PriQueue pQueue = new PriQueue(5);
		PriorityQueue<Vertex<T>> pQueue = new PriorityQueue<Vertex<T>>(5, comp); 
		for(Vertex<T> v : this.vertices){
			if(v != null){
				pQueue.add(v);
			}
		}
		Set<Vertex<T>> set = new HashSet<Vertex<T>>();
		while(pQueue.size() != 0){
			Vertex<T> current = pQueue.poll();
			set.add(current);
			if(current.edges != null ){
				for(Edge<T> edge : current.edges){
					if(this.relaxEdge(edge)){
						pQueue.remove(edge.vertex2);
						pQueue.add(edge.vertex2);
					}
				}
			}
		}
	 
		Vertex<T> x = null;
		for(Vertex<T> v : this.vertices){
			if(v == null || v.parent == null) continue;
			System.out.println(v.parent.getData()
					+ "" + v.getData() + "(" + v.key + ")");
			if(v.getData().equals("x")){
				x = v;
			}
		}
		
		while(x != null){
			if(x.parent != null){
				System.out.println(x.parent.getData() + "" + x.getData());
			}
			x = x.parent;
		}
		
	}

	private Comparator comp = new Comparator<Vertex<T>>(){
		@Override
		public int compare(Vertex<T> o1,   Vertex<T> o2){
			return new Long(o1.key).compareTo(new Long(o2.key));
		}
	};

}
