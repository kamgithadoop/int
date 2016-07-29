package list;

import java.util.Stack;

public class LinkStack<E> extends LinkList<E> {
	
	private String name;
	
	public String getName() {
		return name;
	}


	public LinkStack(){
		super();
	}

	
	public LinkStack(String name){
		super();
		this.name = name;
	}

	public void push(E value){
		this.addLast(value);
	}
	
	public E pop(){
		return removeLast();
	}
	
	
	public E peek(){
		return this.getHeader().getPrev().getValue();
	}
	
	public static class MyStack<E> extends Stack<E>{
		
		private String name;
		
		public String getName() {
			return name;
		}


		public MyStack(){
			super();
		}

		
		public MyStack(String name){
			super();
			this.name = name;
		}
	}
	
}
