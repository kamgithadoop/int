package array;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitOperationTest {

	BitOperation bitOperation = new BitOperation();;
	
	/**
	 * 
	 *  1   2  3  4  5  6  7  8 
	 *  128 64 32 16 8  4  2  1 
	 */
	@Test
	public void test() {
//		int x = 128;
//		int y = 64;
//		System.out.println(Integer.toBinaryString(x));
//		System.out.println(Integer.toBinaryString(y));
//		System.out.println((x|y));
//		System.out.println((x&y));
//		System.out.println((x^y));
//		System.out.println((x>>1));
//		System.out.println((x<<1));
		
		//1110100
		//01110100    
		//00000001
		//00000001
//		//00000110
//		System.out.println(Integer.toBinaryString(x));
//		System.out.println(Integer.toBinaryString(-2));
//		System.out.println(Integer.toBinaryString(-2>>>1));
//		int y = x^2;
//		//01110100
//		System.out.println(Integer.toBinaryString(y));
		int x =116;
		char[] ch = String.valueOf(x).toCharArray();
				
 		for(int i=0;i<ch.length;i++){
 			int num = ch[i] -48;
 			System.out.println(num);
 		}

 		System.out.println(9%Math.sqrt(9.0) == 0.0);
	}
	
	@Test
	public void lonelyinteger() {
		int[] arr = new int[]{2,3,4,5,5,2,3,4,8};
		System.out.println(bitOperation.lonelyinteger(arr));
		int[][] a = new int[3][4];
		System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[1].length);
		System.out.println(a[2].length);
	}
	
	//9 00001001
	//3 00000011
	
	//2 00000010
	//3 00000011
	//4 00000100
	//5 00000101
	//5 00000101
	//2 00000010	
	//3 00000011
	//8 00001000
	//4 00000100
	
	//^ 
	@Test
	public void findSquareRoot(){
		int x = 144;
		if((x%2)==0){
			// prime number
			int cont=0;
			int temp =x;
			while((temp%2)==0){
				temp = temp%2;
				cont++;
			}
			System.out.println(cont*2);
		}else{
			
		}
		
	}
}
