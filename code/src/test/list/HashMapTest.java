package list;

import graph.Graph;
import list.HashMap;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class HashMapTest {
	private HashMap<String, String> map = new HashMap<String, String>(); 
	
	@Test
	public void map() {
		for(int i =1 ; i <= 5 ; i++){
			int k = (i+200);
			map.put(k +"key",k+"value");
		}
		
//		for(int i =1 ; i <= 100 ; i++){
//			int k = (i+200);
//			String key = k +"key";
//			System.out.println( key + " =  " + map.get(k +"key"));
//		}
		HashMap.Iterator<String> it = map.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println( key + " =  " + map.get(key));
		}
	}
	
	public static void main(String args[]) {
		   // create priority queue
		   PriorityQueue < Integer >  prq = new PriorityQueue < Integer > (); 
		       
		   // insert values in the queue
		   prq.offer(6);  
		   prq.offer(9);
		   prq.offer(5);
		   prq.offer(64);
		   prq.offer(6);
		      
		   System.out.println ( "Priority queue values are: "+ prq);
		      
		   // create comparator
		   Comparator comp = prq.comparator();
		   int i = 0;
		   while(!prq.isEmpty()){
			   System.out.print(prq.poll() + ", ");
			   if( i <= 5)
				   prq.offer(++i);
		   }
	}
}
