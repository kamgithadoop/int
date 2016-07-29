package list;

public class LinkQueue<E> extends LinkList<E> {
	public LinkQueue(){
		super();
	}
	
	public void add(E value){
		this.addFirst(value);
	}
	
	public E poll(){
		return removeLast();
	}
	
	
	public E peek(){
		return this.getHeader().getPrev().getValue();
	}
}
