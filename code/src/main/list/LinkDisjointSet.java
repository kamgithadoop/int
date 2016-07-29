package list;

public class LinkDisjointSet<T> {
	private LinkDisjointNode<T> head;
	private LinkDisjointNode<T> tail;
	
	public LinkDisjointNode<T> getHead() {
		return head;
	}

	public void setHead(LinkDisjointNode<T> head) {
		this.head = head;
	}

	public LinkDisjointNode<T> getTail() {
		return tail;
	}

	public void setTail(LinkDisjointNode<T> tail) {
		this.tail = tail;
	}
	
	public void add(T value){
		LinkDisjointNode<T> newNode = new LinkDisjointNode<T>(this, null, value);
		if(head == null){
			head = newNode;
			tail = newNode;
		}else{
			tail.next = newNode; 
		}
	}
	
	public void union(LinkDisjointSet<T> disJoint2){
		this.tail.next = disJoint2.head;
		this.tail = disJoint2.tail;
		LinkDisjointNode<T> current = disJoint2.head;
		while(current != null){
			current.setParentSet(this);
			current = current.next;
		}
		disJoint2.head =null;
		disJoint2.tail=null;
	}
	
	public LinkDisjointSet<T> findSet(T value){
		LinkDisjointNode<T> current = this.head;
		while(current != null){
			if(current.getValue().equals(value)){
				return current.getParentSet();
			}
			current = current.next;
		}
		return null;
	}
	
	public static class LinkDisjointNode<T>{
		private LinkDisjointNode<T> next;
		
		private LinkDisjointSet<T> parentSet;

		private T value;
		
		public LinkDisjointNode(){
		}
		
		public LinkDisjointNode( LinkDisjointNode<T> next){
			this.next= next;
		}
		
		public LinkDisjointNode(LinkDisjointSet<T> parentSet, LinkDisjointNode<T> next, T value){
			this.parentSet = parentSet;
			this.next= next;
			this.value = value;
		}
		public LinkDisjointNode<T> getNext() {
			return next;
		}
		public void setNext(LinkDisjointNode<T> next) {
			this.next = next;
		}
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		
		public LinkDisjointSet<T> getParentSet() {
			return parentSet;
		}
		public void setParentSet(LinkDisjointSet<T> parentSet) {
			this.parentSet = parentSet;
		}
		
	}

}
