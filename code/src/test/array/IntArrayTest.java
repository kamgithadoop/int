package array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import org.junit.Test;

public class IntArrayTest {
	
	private IntArray array = new IntArray();

	@Test
	public void binarySearchOrderedArray() {
		int[] a = {2,4,6,7,8,9,33,44,56,77,88,99,100,111,121,132,144,155,160,170};
		System.out.println("size of array " + (a.length -1) +
						  " searched item index " + array.binarySearchOrderArray2(a, 160));
	}
	@Test
	public void getMaxIndex() {
		int[] a = {33303003,344,5,1,89,13344,67};
		System.out.println("size of array " + (a.length -1) +
						  " max value index " + array.getMaxIndex(a));
	}
	
	@Test
	public void bubbleSort(){
		//int[] a = {33303003,344,5,1,89,13344,67};
		int[] a = {4,7,1,88,33,1223,8,4,1,888,10001001,50,55,3};
		System.out.println("length before sort " + a.length);
		long st = System.currentTimeMillis();
		array.bubbleSort(a);
		System.out.println("time taken bubbleSort" + (System.currentTimeMillis()-st));
		array.display(a);		
		System.out.println("length after bubbleSort " + a.length);
		
		st = System.currentTimeMillis();
		array.bubbleSort2(a);
		System.out.println("time taken bubbleSort2" + (System.currentTimeMillis()-st));
		System.out.println("length after bubbleSort2 " + a.length);
	}

	@Test
	public void selectSort(){
		int[] a = {4,7,1,88,33,1223,8,4,1,888,10001001,50,55,3};
		System.out.println("length before sort " + a.length);
		long st = System.currentTimeMillis();
		array.selectSort(a);
		System.out.println("time taken bubbleSort" + (System.currentTimeMillis()-st));
		System.out.println("length after bubbleSort " + a.length);
	}

	@Test
	public void insertSort(){
		//int[] a = {4,7,1,88,33,1223,8,4,1,888,10001001,50,55,3};
		int[] a = {4,5,1,0,2};
		System.out.println("length before sort " + a.length);
		long st = System.currentTimeMillis();
		array.insertSort(a);
		System.out.println("time taken bubbleSort" + (System.currentTimeMillis()-st));
		System.out.println("length after bubbleSort " + a.length);
		array.display(a);
	}
	
	//Ascii A-65 Z-90
	//97 a 122 z
	@Test
	public void asciiArray(){
		Character[] a = new Character[26];
		for(int i=0;i<26;i++){
			a[i] = (char)(i+65);
		}
		for(int i=0;i<a.length;i++){
			System.out.println((char)a[i] );
		}		//array.insertSort(a);
		
		Character[] b = new Character[26];
		for(int i=0;i<26;i++){
			b[i] = (char)(i+97);
		}
		for(int i=0;i<b.length;i++){
			System.out.println((char)b[i] );
		}		//array.insertSort(a);
	//	System.out.println("time taken bubbleSort" + (System.currentTimeMillis()-st));
		//System.out.println("length after bubbleSort " + a.length);
		//array.display(a);
	}
	
	@Test
	public void bracketMatch(){
		String str = "a(b{c(d<e>f)g}h]i";
		array.bracketMatch(str.toCharArray());
		double x;
		double y;
		for (x=1; x<21; x++){
			y=3.7854* x;
			System.out.println(x+" gallons is " + y+" Liters");
			if(x%6==0 ){
				System.out.println();
			}
		}
	}
	
	@Test
	public void readFile() throws Exception{
		FileReader fileReader = new FileReader("C:\\tmp\\account.csv");
		BufferedReader br = new BufferedReader(fileReader);

		String strLine;

		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
			System.out.println(" Line = " + strLine);
			StringTokenizer st = new StringTokenizer(strLine,",");
			int i =0;
			while(st.hasMoreTokens()){
				switch (i)
				{
					case 0:
						System.out.print(" Cust ID=" + st.nextToken());
						break;
					case 1:
						System.out.print(" F Name=" + st.nextToken());
						break;
					case 2:
						System.out.print(" L Name=" + st.nextToken());
						break;
					case 3:
						System.out.print(" Acc Num=" + st.nextToken());
						break;
					case 4:
						System.out.print(" Acc Type=" + st.nextToken());
						break;
					case 5:
						System.out.print(" Acc Balance=" + st.nextToken());
						break;
					
				}
				i++;
			}
			System.out.println();
			System.out.println();
		}
		//Close the input stream
		br.close();
	}
	
	@Test
	public void stockPrice(){
		int[] stockPrices = new int[] {13, -3,-25,20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		int[] stock = this.array.stockPrice(stockPrices);
		System.out.println(stock);
	}
	
	/**
	 * Merges two sorted and overlappingg array of unequal size
	 * a {1,2,5,6,7,9,}           6 
	 * b {3,4,8,9,12,13,16,24}    8 
	 */
	@Test
	public void mergeSortedArray(){
		/*
		int[] first  = {1,2,5,6,7,9,} ; 
		int[] second  = {3,4,8,9,12,13,16,24};
		*/
		int[] first  = {2,01,2,5,6,7,9,} ; 
		int[] second  = {3,4,8,9,12,13,16,24}; 

		int[] merged = array.mergeSortedArray(first, second);
		System.out.println(merged);
	}
	
	@Test
	public void  removeDupsSortedArray(){
		int[] arr = new int[] {-1,-1,2,2,2,2,4,5,6,7,7,90};
		arr = array.removeDupsSortedArray(arr);
		System.out.println();
	}
	
	@Test
	public void frequentElement(){
		char[] arr = new char[] {'f','b','b','a','h','z'};
		int[] a = array.frequentElement(arr);
		System.out.println(a);
	}
	
	@Test 
	public void mostFrequentKElements_lc347(){
		int[] nums = new int[]{2,4,5,6,2,5,5};
		List<Integer> freq = array.mostFrequentKElements_lc347(nums, 2);
		System.out.println(freq);
	}
	
	@Test
	public void findNumberInMatrix(){
		int[][] matrix = new int[5][4];
		matrix[0] = new int[]{2,4,7,9};
		matrix[1] = new int[]{14,20,23,26};
		matrix[2] = new int[]{40,45,47,49};
		matrix[3] = new int[]{54,56,57,59};
		matrix[4] = new int[]{62,64,68,69,70};
		int[] find = array.findNumberInMatrix(matrix,70);
		System.out.println(find);
	}
	
	@Test
	public void highestNumber(){
		int high = array.highestNumber(new int[]{2,14,7,90});
		System.out.println(high);
	}
	
	@Test
	public void moveZeroToEnd_lc283(){
		long st = System.currentTimeMillis();
		//int[] retVal = array.moveZeroToEnd_lc283(new int[]{0, 1, 0, 3,0, 12,9,7,0,9,8,5,5,5,5,-1,5,55,0});
		int[] retVal = array.moveZeroToEnd_lc283(new int[]{1,3,0,4,5,0,0});
		System.out.println(System.currentTimeMillis() );
		//int[] retVal = array.moveZeroToEnd(new int[]{0,0,1});
		System.out.println(retVal);
	}
	
	@Test
	public void distinctIndices(){
		long st = System.currentTimeMillis();
		int[] retVal = array.distinctIndicesMap(new int[]{1,0,1,1},1);
		System.out.println(System.currentTimeMillis() -st );
		//int[] retVal = array.moveZeroToEnd(new int[]{0,0,1});
		System.out.println(retVal);
	}
	
	@Test
	public void xor(){
		System.out.println(2^3);
	}
	
	@Test
	public void majorityElement_lc169(){
		//int retVal = array.majorityElement_lc169(new int[]{2,3,4,1,1,1,1});
		int retVal = array.majorityElement_lc169(new int[]{2,1,2});
		System.out.println(retVal);
	}
	
	@Test
	public void majorityElement_lc229(){
		List<Integer> retVal = array.majorityElement_lc229(new int[]{2,2,4,2,1,4,7,4,2});
		System.out.println(retVal);
	}
	
	@Test 
	public void rotateArray_lc189(){
		int[] retVal = 	new int[]{1,2};
		array.rotateArray_lc189(retVal, 1);
		System.out.println(retVal);
	}
	
	@Test 
	public void twoSum_lc1(){
		int[] retVal = array.twoSum_lc1(new int[]{3,2,4}, 6);
		System.out.println(retVal);
	}
	
	@Test
	public void countPrimes_lc204(){
		int count = array.countPrimes_lc204(21);
		System.out.println(count);
	}

	@Test 
	public void spiral2DMatrix_lc59(){
		int[][] spiralMat= array.spiral2DMatrix_lc59(20);
		for(int i=0;i<spiralMat.length;i++){
			for(int j=0;j<spiralMat[i].length;j++){
				StringBuffer sBuffer = new StringBuffer(spiralMat[i][j] +"");
				while(sBuffer.length() != 6){
					sBuffer.append(" ");
				}
				System.out.print(sBuffer);
			}
			System.out.println();
		}
		System.out.println(spiralMat);
	}
	
	@Test
	public void  missingNumber_lc268(){
		int[] nums = new int[] {0,1,4,5,6,3};
		int missing = array.missingNumber_lc268(nums);
		System.out.println(missing);
	}
	
	@Test
	public void  findDuplicate(){
		int[] nums = new int[] {6,5,1,2,4,3,5};
		int missing = array.findDuplicate(nums);
		System.out.println(missing);
	}
	
	@Test
	public void floorCeil(){
		double n = 10.22d;
		System.out.println(Math.ceil(n) + "  " + Math.floor( n));
		 n = 10d;
			System.out.println(Math.ceil(n) + "  " + Math.floor( n));
	}
	
	@Test
	public void test() {
	    Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for(int i=0; i < num; i++){
        	boolean isFunny = true;
            char[] array = scanner.next().toCharArray();
            int mid = array.length/2;
            int k=0, j=array.length-1;
            while(k <= mid -2){
            	int d1 = array[k] -array[ k +1];
            	int d2 = array[j] -array[ j - 1];
            	if(Math.abs(d1) != Math.abs(d2)){
            		isFunny = false;
            	}
            	k++;
            	j--;
            	
            }
            System.out.println(isFunny ? "Funny" : "Not Funny");

        }
	}
	
	@Test
	public void isValidSudoku_lc36(){
		char[][] a  = new char[][]{
									{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
									{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
									{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
									{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
									{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
									{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
									{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
									{'.', '.', '.', '1', '9', '5', '.', '.', '.'},
									{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
									{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
								   };
		boolean issud = this.array.isValidSudoku_lc36(a);
	}
	
	
	@Test
	public void isPowerOf(){
		System.out.println(" 32 2 " + array.isPowerOf2(32,2));
		System.out.println(" 32 3 " + array.isPowerOf2(32,3));
		System.out.println(" 64 4 " + array.isPowerOf2(64,4));
	}
	
	@Test 
	public void maxProfit_lc121(){
		int[] prices = new int[]{2,50,4,1,8};
		int[] s = (array.maxProfit_lc121(prices));
		System.out.println(s);
	}
	
	@Test
	public void lengthOfLastWord(){
		String s = "b a ";
		System.out.println(array.lengthOfLastWord(s));
	}
}
