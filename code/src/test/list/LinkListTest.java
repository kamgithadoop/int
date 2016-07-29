package list;

import list.Iterator;
import list.LinkList;
import list.LinkList.Link;
import list.LinkQueue;
import list.LinkStack;

import org.junit.Test;

public class LinkListTest {

	@Test
	public void linkList() {
		LinkList<String> list = new LinkList<String>();
		for(int i=1;i<=10;i++){
			list.add(""+i);
		}
		list.addFirst("100");
		list.addLast("1000");
		for(int i=0;i<list.getSize();i++){
			System.out.println(list.get(i));
		}
		System.out.println("$$$$$$$$");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	
	@Test
	public void linkStack() {
		LinkStack<String> stack = new LinkStack<String>();
		for(int i=1;i<=10;i++){
			stack.push(""+i);
		}
		stack.push("111");
		stack.push("112");
		System.out.println(stack.peek());
		int size = stack.getSize();
		for(int i=0;i<size;i++){
			System.out.println(stack.pop());
		}
	}
	
	
	@Test
	public void linkQueue() {
		LinkQueue<String> stack = new LinkQueue<String>();
		for(int i=1;i<=10;i++){
			stack.add(""+i);
		}
		stack.add("111");
		stack.add("112");
		System.out.println(stack.poll());
		int size = stack.getSize();
		for(int i=0;i<size;i++){
			System.out.println(stack.poll());
		}
	}
	
	@Test 
	public void linkPuzzle5_5LinkList(){
		int size= 10;
		int increment=3;
		Link<String> first=null;
		Link<String> prev=null;
		Link<String> next=null;
		for(int i=1; i<= size; i++){
			Link<String> newLink=new Link<String>(i+"", next, prev);
			if(first == null){
				first=newLink;
			}else{
				prev.setNext(newLink);
			}
			prev = newLink;
		}
		prev.setNext(first);
		first.setPrev(prev);
		//remove(first, increment);
	}

	
	@Test 
	public void linkPuzzle5_5Array(){
		int size= 10;
		int increment=3;
		Integer[] intA = new Integer[size];
		for(int i=0; i<size; i++){
			intA[i] = i+1;
		}
		removeArray(intA, increment, 0);
	}
	
	private Integer[] removeArray(Integer[] intA, int increment, int index ){
		if(intA.length == 1){
			System.out.println("re maing " + intA[0]);
			return intA;
		}
		int startIndex = 0;
		for(int i=index; i<intA.length;i++){
			if(i == increment){
				System.out.println("removing  "  + intA[i]);
				intA[i] =null;
				startIndex = i+1;
				break;
			}
		}
		return removeArray(intA, increment, startIndex);
	}
	
	@Test
	public void reverseList(){
		Link<String> tail = new Link<String>("2",null, null);		
		Link<String> header = new Link<String>("1",tail, null);	
		reverseList(header);
		
	}
	
	public Link<String> reverseList(Link<String> head) {
		if (head == null || head.getNext() == null) {
			return head;
		}

		Link<String> current = head.getNext();
		Link<String> prev = head;
		while (current != null) {
			Link<String> next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head.setNext(null);
		return current;
	}
	 
	
}
