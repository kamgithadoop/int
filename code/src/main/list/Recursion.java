package list;

import java.util.Stack;

import list.LinkStack.MyStack;

public class Recursion {
	
	
	public  void doTowers(int topN,	MyStack<Integer> from, MyStack<Integer> inter, MyStack<Integer> to)
		{
		if(topN==1){
			int val = from.pop();
			to.push(val);
			System.out.println(val +" from " + from.getName() + " to "+ to.getName());
		}
		else
		{
			doTowers(topN-1, from, to, inter); 
			int val = from.pop();
			to.push(val);
			System.out.println(val +" from " + from.getName() + " to "+ to.getName());
			doTowers(topN-1, inter, from, to); 
		}
	}
	
//	public void binarySearch(int[] ordArray,int start, int end, int searched){
//		int newIndex = (start+end)/2;
//		if(ordArray[newIndex] == searched){
//			return searched;
//		}else {
//			binarySearch()
//		}
//	}
	
	public void triangle(int maxCount){
		triangle(maxCount);
		//triangleNumberRecur(maxCount );
		System.out.println();
		int num = 0;
		for(int i=1;i<=maxCount;i++){
			if(i ==1){
				num = i;
			}else{
				num = num+i;
			}
			System.out.print(num + ",");
		}
	}
	
	
	public int triangle2(int n) {
		System.out.println("Entering: n=" + n);
		if (n == 1) {
			System.out.println("Returning 1");
			return 1;
		} else {
			int temp = n + (triangle2(n - 1));
			System.out.println("Returning " + temp);
			return temp;
		}
	}


	public int factorial(int n) {
		System.out.println("Entering: n=" + n);
		if (n == 1) {
			return 1;
		} else {
			int temp = n * factorial(n - 1);
			return temp;
		}
	}

	public int power(int num, int power) {
		if (power == 1) {
			return num;
		} else {
			int temp = num * power(num, power - 1);
			return temp;
		}
	}

	
	public int triangleNumberRecur(int number){
		if(number==1){
			System.out.print(number + ",");
			return 1;
		}else{
			int temp = number + triangleNumberRecur(number-1);
			System.out.print(temp + ",");
			return temp;
		}
	}
	
	
	
//	public int triangleNumberRecur(int number){
//		if(maxCount == count){
//			return startNumber;
//		}
//		System.out.print(startNumber + ",");
//		startNumber = startNumber+inter;
//		count++;inter++;
//		return  triangleNumberRecur(startNumber, inter, maxCount, count);
//	}

}
