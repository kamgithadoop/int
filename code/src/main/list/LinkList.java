package list;

import java.util.HashSet;
import java.util.Set;


public class LinkList<E> {
	
	private Link<E> header;

	private int size;
	
	public LinkList(){
		header = new Link<E>();
		size=0;
	}
	
	public E get(int in){
		if(size == 0){
			return null;
		}
		int cur = 0;
		Link<E> link = header.next;
		while(cur != in){
			link = link.getNext();
			cur++;
		}
		return link.getValue();
	}
	public void add(E val){
		addLast(val);
	}
	
	public void addFirst(E val){
		Link<E> newLink = new Link<E>(val,header.next, header);
		header.next.setPrev(newLink);
		header.next = newLink;
		size++;
	}

	public void addLast(E val){
		Link<E> newLink = new Link<E>(val,header, header.prev);
		header.prev.setNext(newLink);
		header.prev = newLink;
		size++;
	}

	public void remove(E val){
		if(size == 0){
			return ;
		}
		Link<E> link = header.next;
		while(!link.getValue().equals(val)){
			link = link.getNext();
		}
		link.getNext().setPrev(link.getPrev());
		link.getPrev().setNext(link.getNext());
		size--;
	}
	public E removeFirst(){
		if(size == 0){
			return null;
		}
		Link<E> oldFirst = header.next;
		oldFirst.next.prev = header;
		header.next = oldFirst.next;
		size--;
		return oldFirst.getValue();
	}

	
	public E removeLast(){
		if(size == 0){
			return null;
		}
		Link<E> oldLast = header.prev;
		header.prev = oldLast.prev;
		oldLast.prev.next = header;
		size--;
		return oldLast.value;
	}
	

	public Link<E> getHeader() {
		return header;
	}

	public void setHeader(Link<E> header) {
		this.header = header;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
	 public Link<E> reverseList(Link<E> head) {
        if(head == null || head.next == null){
            return head;
        }
        
        Link<E> current = head.next;
        Link<E> prev = head;
        while(current != null){
        	Link<E> next = current.next;
            current.next = prev;
            prev =current;
            current = next;
        }
        head.next = null;
        return current;
	}
    public Link<E> deleteDuplicates(Link<E> header) {
        Set<E> set = new HashSet<E>();
        Link<E> current = header;
        while(current.next != null){
            set.add(current.value);
            current = current.next;
        }
        Link<E> newCur = null;
        Link<E> preCur = null;
        Link<E> newHead= new Link<E>(set.iterator().next(), null, null);
        while(set.iterator().hasNext()){ 
        	E curVal = set.iterator().next();
        	newCur =  new Link<E>(curVal, null, null);
        	if(preCur != null){
        		preCur.next= newCur;
        	}else{
        		preCur = newHead;
        	}
        	preCur = newCur;
        }
        return newHead;
    }

	
	public static class Link<E>{
		private E value;
		private Link<E> next;
		private Link<E> prev;
		
		public Link(){
			next=this;
			prev =this;
		}

		public Link(E val, Link<E> nex){
			this.value = val;
			this.next = nex;
		}

		public Link(E val, Link<E> nex, Link<E> prev){
			this.value = val;
			this.next = nex;
			this.prev = prev;
		}

		public E getValue() {
			return value;
		}
		public void setValue(E value) {
			this.value = value;
		}
		public Link<E> getNext() {
			return next;
		}
		public void setNext(Link<E> next) {
			this.next = next;
		}
		public Link<E> getPrev() {
			return prev;
		}
		public void setPrev(Link<E> prev) {
			this.prev = prev;
		}
	}
	
	
	public Iterator<E> iterator(){
		return new Iterator<E>(this);
	}
	
}
