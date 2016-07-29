package list;

import java.util.Stack;

import org.junit.Test;

import list.LinkStack;
import list.LinkStack.MyStack;
import list.Recursion;

public class RecursionTest {

	Recursion recursion = new Recursion();
	
	@Test
	public void triangle(){
		//recursion.triangleNumber(2);
	}
	
	@Test
	public void factorial(){
		System.out.println(recursion.factorial(9));
	}
	
	@Test
	public void power(){
		System.out.println(recursion.power(3, 3));
		
	}
	
	
	@Test
	public void doTowers(){
		MyStack<Integer> source = new MyStack<Integer>("Source");
		for(int i =3 ;i >= 1 ; i--){
			source.push(i);
		}
		MyStack<Integer> inter = new MyStack<Integer>("Inter");
		MyStack<Integer> dest = new MyStack<Integer>("Dest");
		recursion.doTowers(3, source, inter , dest);
		System.out.println(dest);
		System.out.println(inter);
		System.out.println(dest);
	}
	
}
