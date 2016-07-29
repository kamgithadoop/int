package algorithm;

import algorithm.Dynamic;

import org.junit.Test;

public class DynamicTest {

	Dynamic dy = new Dynamic();
	@Test
	public void cutRodTopDown(){
		Integer[] prices = getPrices();
		dy.cutRodTopDown(5, prices);
		
	}
	
	@Test
	public void cutRodBottomUp(){
		Integer[] prices = getPrices();
		dy.cutRodBottomUp(5, prices);
		
	}

	@Test
	public void fibonacciTopDown(){
		dy.fibonacciTopDown(8);
	}
	@Test
	public void fibonacciBottomUp(){
		dy.fibonacciBottomUp(8);
	}

	private Integer[] getPrices(){
		Integer[] p = {1,5,8,9,10,17,17,20,24,30};
		return p;
				
	}
}
