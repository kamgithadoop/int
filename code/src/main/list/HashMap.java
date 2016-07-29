package list;

public class HashMap<K, V>  {
	
	private HashNode<K,V>[] entries;
	
	private int size;
	
	private int threshold;
	
	private int capacity;
	
	public HashMap(){
		this(30);
	}
	
	public HashMap(int capacity){
		entries = new HashNode[capacity];
		threshold =(int) (0.75 *capacity);
		this.capacity = capacity;
	}
	
	
	public void put(K key, V value){
		if(size == threshold){
			//resize the array 
			resize();
		}
		int hashValue = key.hashCode();
		int index = hashValue % this.capacity;
		HashNode<K,V> oldValue = entries[index] ;
		if(oldValue != null){
			HashNode<K,V> current = oldValue;
			HashNode<K,V> prev = oldValue;
			while(current != null && !current.getKey().equals(key)){
				prev = current;
				current = current.getNext();
			}
			HashNode<K,V> newNode = new HashNode<K,V>(key, value, current);
			prev.setNext(newNode);
		}else{
			entries[index] = new HashNode<K,V>(key, value, null);
			size++;
		}
	}
	
	private void resize(){
		int newCapacity = capacity*2;
		HashNode<K,V>[] newEntries = new HashNode[newCapacity];
		for(HashNode<K,V> entry : this.entries){
			K key = entry.getKey(); 
			int index = key.hashCode()% newCapacity;
			newEntries[index] = entry;
		}
		this.entries =newEntries;
	}
	public V get(K key){
		int hashValue = key.hashCode();
		int index = hashValue % capacity;
		HashNode<K,V> value = entries[index] ;
		if(value != null){
			while(value != null && !value.getKey().equals(key)){
				value = value.getNext();
			}
			return value.getValue();
		}else{
			return null;
		}
	}
	
	public HashNode<K,V>[] getEntries() {
		return entries;
	}

	public void setEntries(HashNode<K,V>[] entries) {
		this.entries = entries;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public static class Iterator<K> {
		private HashMap map;
		private int curIndex;
		private HashNode curNode;
		
		public Iterator(HashMap map){
			this.map = map;
			this.curIndex=0;
			this.curNode=map.getEntries()[0];
		}
		
		public boolean hasNext(){
			boolean hasNext=  (curIndex  > (map.getEntries().length -1)) ||
					(curNode != null && curNode.getNext() != null);
			return hasNext;
		}
		
		public K next(){
			K key= (K)curNode.getKey();
			if(curNode.getNext() != null){
				curNode = curNode.getNext();
			}else{
				while((curNode=map.getEntries()[curIndex++]) == null){
									
				}
			}
			return key;
		}
		
		
		public int getCurIndex() {
			return curIndex;
		}

		public void setCurIndex(int curIndex) {
			this.curIndex = curIndex;
		}

	
	}
	public static class HashNode<K,V> {
		private K key;
		private V value;
		private HashNode<K,V> next;
		
		public HashNode(K key, V value, HashNode<K,V> next){
			this.key=key;
			this.value=value;
			this.next=next;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public HashNode<K, V> getNext() {
			return next;
		}

		public void setNext(HashNode<K, V> next) {
			this.next = next;
		}
		
	}
	
	public Iterator<K> iterator(){
		return new Iterator<K>(this);
	}

}
