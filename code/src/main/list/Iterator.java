package list;

import list.LinkList.Link;

public class Iterator<E> {
	
	private LinkList<E> list;
	
	private int size ;
	
	private int cursor;

	private Link<E> current ;
	
	public Iterator(LinkList<E> l){
		list = l;
		size = l.getSize();
		cursor= 0;
		current = list.getHeader();
	}
	
	public boolean hasNext(){
		return (cursor != list.getSize());
	}
	
	public E next(){
		cursor++;
		current =  current.getNext();
		return current.getValue();
	}
}
