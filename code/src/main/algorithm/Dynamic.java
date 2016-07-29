package algorithm;

import java.util.List;
import java.util.Stack;

public class Dynamic {

	public void fibonacciTopDown(int size){
		int[] memo = new int[size];
		int i = 0;
		for(int mem : memo){
			memo[i++] = -100;
		}
		memo[0]=0;memo[1]=1;memo[2]=1;
		int feb = fibonacci(size,memo);
		System.out.println(memo );
	}
	
	private int fibonacci(int n, int[] memo){
		if(n == 0){
			return 0;
		}
		if(n <= 2){
			return 1;
		}
		if(memo[n-1] >= 0){
			return memo[n-1];
		}
		int f = fibonacci(n-1,memo) + fibonacci(n-2,memo);
		memo[n-1]=f;
		return f;
	}

	public void fibonacciBottomUp(int n){
		int[] memo = new int[n];
		int j = 0;
		for(int mem : memo){
			memo[j++] = -100;
		}
		memo[0]=0;memo[1]=1;memo[2]=1;
		for(int i=3; i< n; i++){
			memo[i] = memo[i-1]+memo[i-2];
		}
		System.out.println(memo );
	}

	
	public void cutRodTopDown(int size, Integer[] price){
		int[] memorized = new int[size];
		int i = 0;
		for(int mem : memorized){
			memorized[i++] = -100;
		}
		int revenue = memorizedCutRod(size, price,memorized );
		System.out.println(revenue );
	}
	
	public void cutRodBottomUp(int size, Integer[] price){
		int[] memorized = new int[size];
		int i = 0;
		for(int mem : memorized){
			memorized[i++] = 0;
		}
		Integer[][]  revenue = cutRodBottomUp1(size, price);
		System.out.println(revenue );
	}
	

	private Integer[][] cutRodBottomUp1(int n, Integer price[])
	{
		Integer[] val = new Integer[n+1];
		Integer[] items = new Integer[n+1];
	   val[0] = 0;
	   int i, j;
	 
	   // Build the table val[] in bottom up manner and return the last entry
	   // from the table
	   for (i = 1; i<=n; i++)
	   {
	       int max_val = 0;
	       for (j = 0; j < i; j++)
	    	   if(max_val < (price[j] + val[i-j-1])){
	    		   max_val = price[j] + val[i-j-1];
	    		   items[i-1] = j;
	    	   }
	       val[i] = max_val;
	   }
	 
	   Integer[][] o = new Integer[2][2];
	   o[0] = val;
	   o[1] = items;
	  
	   return o ;
	}	
	
	/**
	 * 

	 *
	 **/
	
	
	private int memorizedCutRod(int size, Integer[] price, int[] memorized){
		int max =0;
		if(size == 0){
			max = 0; 
			return max;
		}
		if(memorized[size-1] >= 0){
			return memorized[size-1];
		}
	
		for(int i=0; i < size ; i++){
			max = Math.max(max, price[i]+ memorizedCutRod((size -(i+1)),price, memorized));
		}
		memorized[size-1] = max;
		return max;
	}
	
	

}
