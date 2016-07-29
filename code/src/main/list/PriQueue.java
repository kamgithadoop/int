package list;

import graph.Graph.Edge;
import graph.Graph.Vertex;

public class PriQueue {
	
	Vertex[] array ;
	
	private int curIn;
	
	private int size;
	
	public PriQueue(int size){
		array = new Vertex[size];
		this.size= size;
	}
	
	public Vertex poll(){
		sort();
		Vertex v = array[0];
		array[0] = null;
		size--;
		Vertex[] tarray = new Vertex[size];
		for(int i =1 ; i < array.length ; i++){
			tarray[i-1] = array[i];
		}
		array = tarray;
		return v;
	}
	
	private void sort(){
		for(int out=0 ; out < (array.length -1); out++){
			int min = out ;
			for(int in= out +1 ; in < (array.length -1);in++){
				if(array[in].key < array[min].key){
					min = in;
				}
			}
			Vertex temp = array[out];
			array[out] = array[min];
			array[min] = temp;
		}
	}
	
	
	public void add(Vertex a ){
		array[curIn++] = a;
	
	}
	
	public int size(){
		return size;
	}
	
	public boolean contains(Vertex ver){
		for(Vertex v : array){
			if(v == null) continue;
			if(v.equals(ver)){
				return true;
			}
		}
		return false;
	}
}
