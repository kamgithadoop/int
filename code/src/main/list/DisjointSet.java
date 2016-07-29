package list;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class DisjointSet<T> {
	
	public Map<T, Set<T>> disjSet;
	
	public DisjointSet(){
		disjSet = new HashMap<T, Set<T>>();
	}
	
	public void addToSet(T key, T value){
		Set<T> set = disjSet.get(key);
		if(set == null){
			set = new HashSet<T>();
			disjSet.put(key, set);
		}
		set.add(value);
	}
	
	public void union(T key1, T key2){
		Set<T> set1 = disjSet.get(key1);
		Set<T> set2 = disjSet.get(key2);
		if(set1 != null && set2 != null){
			Set<T> set = new HashSet<T>();
			set.addAll(set1);
			set.addAll(set2);
			disjSet.put(key1, set);
			disjSet.remove(key2);
		}
	}
	
	public T findSet(T str){
		T setKey = null;
		for(T key : disjSet.keySet()){
			Set<T> set = disjSet.get(key);
			if(set != null && set.contains(str)){
				setKey = key;
			}
		}
		return setKey;
	}
	
	public int getSetSize(T str) {
		int size = 0;
		T setKey = null;
		for (T key : disjSet.keySet()) {
			Set<T> set = disjSet.get(key);
			if (set != null && set.contains(str)) {
				size = set.size();
			}
		}
		return size;
	}
}
