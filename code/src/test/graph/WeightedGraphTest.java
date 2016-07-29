package graph;

import java.util.PriorityQueue;

import org.junit.Test;

import graph.Graph.Edge;
import graph.Graph.Vertex;
import graph.WeightedGraph;

public class WeightedGraphTest {
	
	
	@Test
	public void mstKruskal1(){
		boolean s = true;
		do {
			System.out.println();
			s=false;
		}while(s);
	}

	@Test
	public void mstKruskal(){
		WeightedGraph<String> wGraph = createWGraph();
		long st = System.currentTimeMillis();
		Edge<String>[] edges = wGraph.mstKruskal();
		System.out.println("time taken " + (System.currentTimeMillis() -st ));
		for(Edge<String> edge :edges){
			if(edge == null){
				continue;
			}
			System.out.println(edge.vertex1.getData() + 
					        edge.vertex2.getData()
					     + "(" + edge.weight + ")");
		}
	}
	
	@Test
	public void mstKruskalLink(){
		WeightedGraph<String> wGraph = createWGraph();
		long st = System.currentTimeMillis();
		Edge<String>[] edges = wGraph.mstKruskalLink();
		System.out.println("time taken " + ( System.currentTimeMillis()-st));
		for(Edge<String> edge :edges){
			if(edge == null){
				continue;
			}
			System.out.println(edge.vertex1.getData() + 
					        edge.vertex2.getData()
					     + "(" + edge.weight + ")");
		}
	}
	
	@Test
	public void mstKruskalTree(){
		WeightedGraph<String> wGraph = createWGraph();
		long st = System.currentTimeMillis();
		Edge<String>[] edges = wGraph.mstKruskalTree();
		System.out.println("time taken " + ( System.currentTimeMillis()-st));
		for(Edge<String> edge :edges){
			if(edge == null){
				continue;
			}
			System.out.println(edge.vertex1.getData() + 
					        edge.vertex2.getData()
					     + "(" + edge.weight + ")");
		}
	}
	
	@Test 
	public void mstPrims(){
		WeightedGraph<String> wGraph = createWGraph();
		long st = System.currentTimeMillis();
		 wGraph.mstPrims();
		System.out.println("time taken " + ( System.currentTimeMillis()-st));
	}
	
	@Test
	public void spBellmanFord(){
		WeightedGraph<String> dGraph = this.createDiCyGraphNeg();
		dGraph.spBellmanFord();
	}
	
	@Test
	public void spDijkstra(){
		WeightedGraph<String> dGraph = this.createDiCyGraph();
		dGraph.spDijkstra();
	}
	
	private WeightedGraph createWGraph(){
		WeightedGraph<String> wGraph = new WeightedGraph<String>();
		Vertex<String> a  = new Vertex<String>("a");
		Vertex<String> b  = new Vertex<String>("b");
		Vertex<String> c  = new Vertex<String>("c");
		Vertex<String> d  = new Vertex<String>("d");
		Vertex<String> e  = new Vertex<String>("e");
		Vertex<String> f  = new Vertex<String>("f");
		Vertex<String> g  = new Vertex<String>("g");
		Vertex<String> h  = new Vertex<String>("h");
		Vertex<String> i  = new Vertex<String>("i");
		wGraph.addVertex(a);
		wGraph.addVertex(b);
		wGraph.addVertex(c);
		wGraph.addVertex(d);
		wGraph.addVertex(e);
		wGraph.addVertex(f);
		wGraph.addVertex(g);
		wGraph.addVertex(h);
		wGraph.addVertex(i);
		
		wGraph.addEdge(a, b, 4);
		wGraph.addEdge(b, c, 8);
		wGraph.addEdge(c, d, 7);
		wGraph.addEdge(d, e, 9);
		wGraph.addEdge(e, f, 10);
		wGraph.addEdge(f, g, 2);
		wGraph.addEdge(g, h, 1);
		wGraph.addEdge(h, a, 8);
		wGraph.addEdge(b, h, 11);
		wGraph.addEdge(i, h, 7);
		wGraph.addEdge(d, f, 14);
		wGraph.addEdge(c, i, 2);
		wGraph.addEdge(f, c, 4);
		wGraph.addEdge(g, i, 6);
		return wGraph;
	}



	private WeightedGraph createDiCyGraphNeg(){
		WeightedGraph<String> wGraph = new WeightedGraph<String>(5,10);
		Vertex<String> s  = new Vertex<String>("s");
		Vertex<String> t  = new Vertex<String>("t");
		Vertex<String> x  = new Vertex<String>("x");
		Vertex<String> y  = new Vertex<String>("y");
		Vertex<String> z  = new Vertex<String>("z");
		
		wGraph.addVertex(s);
		wGraph.addVertex(t);
		wGraph.addVertex(x);
		wGraph.addVertex(y);
		wGraph.addVertex(z);
		
		wGraph.addDirectedEdge(s, t, 6);
		wGraph.addDirectedEdge(s, y, 7);

		wGraph.addDirectedEdge(t, x, 5);
		wGraph.addDirectedEdge(t, z, -4);
		wGraph.addDirectedEdge(t, y, 8);

		wGraph.addDirectedEdge(x, t, -2);
		
		wGraph.addDirectedEdge(z, x, 7);
		wGraph.addDirectedEdge(z, s, 2);

		wGraph.addDirectedEdge(y, x, -3);
		wGraph.addDirectedEdge(y, z, 9);
		
		return wGraph;
	}

	private WeightedGraph createDiCyGraph(){
		WeightedGraph<String> wGraph = new WeightedGraph<String>(5,10);
		Vertex<String> s  = new Vertex<String>("s");
		Vertex<String> t  = new Vertex<String>("t");
		Vertex<String> x  = new Vertex<String>("x");
		Vertex<String> y  = new Vertex<String>("y");
		Vertex<String> z  = new Vertex<String>("z");
		
		wGraph.addVertex(s);
		wGraph.addVertex(t);
		wGraph.addVertex(x);
		wGraph.addVertex(y);
		wGraph.addVertex(z);
		
		wGraph.addDirectedEdge(s, t, 10);
		wGraph.addDirectedEdge(s, y, 5);

		wGraph.addDirectedEdge(t, x, 1);
		wGraph.addDirectedEdge(t, y, 2);

		wGraph.addDirectedEdge(x, z, 4);
		
		wGraph.addDirectedEdge(z, x, 6);
		wGraph.addDirectedEdge(z, s, 7);

		wGraph.addDirectedEdge(y, x, 9);
		wGraph.addDirectedEdge(y, t, 3);
		wGraph.addDirectedEdge(y, z, 2);
		
		return wGraph;
	}
}
