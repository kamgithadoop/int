package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class IntArray {
	
	public int binarySearchOrderArray(int[] ordArray, int searchedItem){
		int startIndex = 0;
		int endIndex = ordArray.length -1;
		
		while(true){
			int newIndex = (startIndex+endIndex)/2;
			if(ordArray[newIndex] == searchedItem){
				return newIndex;
			}else if(ordArray[newIndex] > searchedItem){
				endIndex = newIndex;
			}else {
				startIndex = newIndex;
			}
		}
	}

	public int binarySearchOrderArray2(int[] ordArray, int searchedItem){
		int startIndex = 0;
		int endIndex = ordArray.length -1;
		int newIndex =(startIndex+endIndex)/2;
		while(ordArray[newIndex] != searchedItem){
			newIndex = (startIndex+endIndex)/2;
			if(ordArray[newIndex] > searchedItem){
				endIndex = newIndex;
			}else {
				startIndex = newIndex;
			}
		}
		return newIndex;
	}
	
	
	public int getMaxIndex(int[] unordArray){
		//{344,5,1,89,13344,67};
		int maxIndex = 0 ;
		for(int i =0 ; i< unordArray.length -1;i++){
			if(unordArray[maxIndex] <= unordArray[i]){
				maxIndex=i;
			}
		}
		return maxIndex;
	}
	/**
	 * Big O = O(N Square)
	 * @param unordArray
	 */
	public void bubbleSort(int[] unordArray){
		for(int j =0 ; j < unordArray.length -1; j++){
			for(int i =0 ; i < (unordArray.length -2 -j); i++){
				if(unordArray[i] > unordArray[i+1]){
					int temp = unordArray[i+1];
					unordArray[i+1] = unordArray[i];
					unordArray[i] = temp;
				}
			}
		}
	}
	public void selectSort(int[] unordArray){
		for(int out=0 ; out < unordArray.length -1; out++){
			int min = out ;
			for(int in= out +1 ; in < (unordArray.length -1);in++){
				if(unordArray[in] < unordArray[min]){
					min = in;
				}
			}
			int temp = unordArray[out];
			unordArray[out] = unordArray[min];
			unordArray[min] = temp;
		}
	}
	
	public void bubbleSort2(int[] unordArray){
		for(int j =unordArray.length -1 ; j > 1 ; j--){
			for(int i =0 ; i < j; i++){
				if(unordArray[i] > unordArray[i+1]){
					int temp = unordArray[i+1];
					unordArray[i+1] = unordArray[i];
					unordArray[i] = temp;
				}
			}
		}
	}
	
	public void insertSort(int[] unordArray){
		for(int out=1;out < unordArray.length;out++){
			int temp = unordArray[out];
			int in = out -1 ;
			while(in > -1 && temp < unordArray[in]){
				unordArray[in +1] = unordArray[in];
				unordArray[in] = temp;
				in = in -1;
			}
		}
	}
	
	public void display(int[] unordArray){
		for(int j =0 ; j < unordArray.length; j++){
			System.out.println(unordArray[j]);
		}
	}

	public void display2(Integer[] unordArray){
		for(int j =0 ; j < unordArray.length; j++){
			System.out.println(unordArray[j]);
		}
	}
	
	public void bracketMatch(char[] unordArray){
		int mid = unordArray.length/2;
		int rig = mid +1;
		int lef = mid -1;
		while(lef>=0 && (rig<=(unordArray.length -1))){
			int first =unordArray[lef];
			int second =unordArray[rig];
			
			if(unordArray[lef] == '('){
				second++;
			}
			if((second - first) !=2){
				System.out.println("no bracket matching " 
						+ rig + " " +unordArray[rig]  + " "
						 + lef + " " + unordArray[lef]);
				break;
			}
			lef = lef-2;
			rig = rig +2;
		}
		
	}
	
	public int[] stockPrice(int[] array){
		return getMaximumSubArray(array, 0, array.length -1);
	}
	
	private int[] getMaximumSubArray(int[] array, int low, int high){
		int[] maxArray = new int[3];
		if(high == low){
			maxArray[0] = low;
			maxArray[1] = high;
			maxArray[2] = array[low];
			return maxArray;
		}

		int mid = ((low + high)/2);
		int[] maxSubArrayLeft = getMaximumSubArray(array, low, mid);
		int[] maxSubArrayRight = getMaximumSubArray(array, mid+1, high);
		int[] maxSubArrayCross= getMaximumCrossSubArray(array, low, high);
		if(maxSubArrayLeft[2] >= maxSubArrayRight[2] && maxSubArrayLeft[2]  >= maxSubArrayCross[2]){
			maxArray[0] = maxSubArrayLeft[0];
			maxArray[1] = maxSubArrayLeft[1];
			maxArray[2] = maxSubArrayLeft[2];
		}else if(maxSubArrayRight[2] >= maxSubArrayLeft[2] && maxSubArrayRight[2]  >= maxSubArrayCross[2]){
			maxArray[0] = maxSubArrayRight[0];
			maxArray[1] = maxSubArrayRight[1];
			maxArray[2] = maxSubArrayRight[2];
		}else {
			maxArray[0] = maxSubArrayCross[0];
			maxArray[1] = maxSubArrayCross[1];
			maxArray[2] = maxSubArrayCross[2];
		}
		return maxArray;
	}
	
	private int[] getMaximumCrossSubArray(int[] array, int low, int high){
		int[] maxCrossArray = new int[3];
		int mid = ((low + high)/2);
		int leftSum = -10000;
		int sum = 0;
		int leftIndex = low;
		for(int i = mid ; i >= low ; i--){
			sum = sum + array[i];
			if(sum > leftSum){
				leftSum = sum;
				leftIndex =i;
			}
		}
		
		int rightSum = -10000;
		sum = 0;
		int rightIndex = high;
		for(int i = mid + 1 ; i <= high ; i++){
			sum = sum + array[i];
			if(sum > rightSum){
				rightSum = sum;
				rightIndex =i;
			}
		}
		maxCrossArray[0]=leftIndex;
		maxCrossArray[1]=rightIndex;
		maxCrossArray[2]=rightSum+leftSum;
		
		return maxCrossArray;
	}
	
	@Test
	public void test(){
		
        Scanner in = new Scanner(System.in);
        int t = 3;
        int[] c = new int[]{0,1,4};
        for(int a0 = 0; a0 < t; a0++){
            int intialH = 1 ;
            int cycle = c[a0];
       
            if(cycle==0){
                System.out.println(intialH);
                continue;
            }
            for(int i=1;i<=cycle;i++){
                if((i%2) == 0){
                   intialH = (intialH +1);
                }else{
                   intialH = (2*intialH) ;
                }
            }
            System.out.println(intialH);
        }
		 /*
		 Scanner in = new Scanner(System.in);
	        int n = 6;
	        float num = 6;
	        int arr[] = new int[]{-4, 3, -9, 0, 4, 1,};
	        float neg=0;
	        float zero=0;
	            
	        for(int arr_i=0; arr_i < n; arr_i++){
	            //arr[arr_i] = in.nextInt();
	            if(arr[arr_i] < 0){
	               neg++ ;
	            }else if(arr[arr_i] == 0){
	                zero++;
	            }
	        }
	        float z = (zero/num);
	        double nn = neg/num;
	        double p= (num-(neg+zero))/num;
	        System.out.println(p);
	        System.out.println(nn);
	        System.out.println(z);
	        */
	}
	
	public int growth(int cycle, int height){
		if(cycle ==0 ){
			return height;
		}else if(cycle ==1 ){
			return height *2;
		}else if(cycle==2){
			return height+1;
		}else {
			return (growth(cycle-1, height));
		}
	}
	
	/**
	 * Removes duplicates from given 
	 * sorted array
	 */
	public int[] removeDupsSortedArray(int[] arr){
		int prev = arr[0];
		for(int i=1; i< arr.length; i++){
			if(prev == arr[i]){
				arr[i]= Integer.MIN_VALUE;
				continue;
			}else{
				prev=arr[i];
			}
		}
		return arr;
	}
	
	/**
	 * Merges two sorted and overlappingg array of unequal size
	 * a {1,2,5,6,7,9,}           6 
	 * b {3,4,8,9,12,13,16,24}    8 
	 */
	public int[] mergeSortedArray(int[] first, int[] second){
	    if(first.length ==0 ||  second.length ==0){
            return first;
        }
	    int[] mergedArray = new int[first.length + second.length];
		int fCurIndex = 0;
		int sCurIndex =0;
		int newCurIndex =0;
		
		while(fCurIndex < first.length || sCurIndex < second.length){
			if(fCurIndex < first.length && 
					first[fCurIndex] < second[sCurIndex]){
				mergedArray[newCurIndex] =first[fCurIndex];
				fCurIndex++;
			}else{
				mergedArray[newCurIndex] =second[sCurIndex];
				sCurIndex++;
			}
			newCurIndex++;
		}
		System.arraycopy(mergedArray,0, first,0,mergedArray.length);
		return first;
        
	}
	/**
		Given an array of characters (not sorted), how do you find the most frequent character?
		Example:
		{a b a c d} - Answer 'a'
		{a b a b d} - Either 'a' or 'b' should work
		{a b c d e} - Any character in the array	 
	 * 
	 */
	
	public int[] frequentElement(char[] array){
		int a = 'a';
		int[] fre = new int[26];
		for(int i=0; i<array.length ;i++){
			fre[array[i] - a] = fre[array[i] - a] + 1;
		}
		return fre;
	}
	
	/**
	 *  Given a non-empty array of integers, return the k most frequent elements.
		For example,
		Given [1,1,1,2,2,3] and k = 2, return [1,2]. 
	 */
	public List<Integer> mostFrequentKElements_lc347(int[] nums, int k){
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}
	
	/**
	 * 
 	 * A MxN matrix is given. 
 	 * All rows and columns are sorted in ascending order. 
 	 * Search for a given number in this matrix efficiently.	
 	 * 
 	 */
	public int[] findNumberInMatrix(int[][] matrix, int find){
		int rowIndex = getRowIndexRecur(matrix, find, 0, matrix.length -1);
		int columnIndex = getColumnIndexRecur(matrix[rowIndex], find, 0, matrix[rowIndex].length -1);
		return new int[] {rowIndex, columnIndex};
	}
	
	private int getRowIndexRecur(int[][] matrix, int find, int start, int end){
		int newStart = start;
		int newEnd = end;
		if(end - start ==1){
			if(find >= matrix[start][0] && find <= matrix[end][0]){
				return start;
			}else{
				return end;
			}
		}
		int mid = (start+end)/2;
		if(find >= matrix[start][0] && find <= matrix[mid][0]){
			newEnd =  mid;
		}else{
			newStart = mid;
		}
		return getRowIndexRecur(matrix, find, newStart, newEnd);
	}
	
	private int getColumnIndexRecur(int[] columns, int find, int start, int end){
		if(end - start ==1){
			if(find == columns[start]){
				return start;
			}else{
				return end;
			}
		}
		int mid = (start+end)/2;
		int newStart = start;
		int newEnd = end;
		if(find >= columns[start] && find <= columns[mid]){
			newEnd = mid;
		}else{
			newStart =mid;
		}
		return getColumnIndexRecur(columns, find, newStart, newEnd);
	}
	
	
	/**
	 * find highest number in array
	 */
	public int highestNumber(int[] arr){
		int high = arr[0];
		for(int i=0; i<arr.length; i++){
			if(arr[i] > high){
				high = arr[i];
			}
		}
		return high;
	}
	
	/**
	 *  Given an array nums, write a function to move all 0's to the end of it while maintaining 
	 *  the relative order of the non-zero elements.
	 *  For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]. 
	 *  0,0,0,1,2,0,1
	 */
	public int[] moveZeroToEnd_lc283(int[] nums) {
		int zeroIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0){
				if(zeroIndex == -1 ){
					zeroIndex =i;
				}
			}else {
				if(zeroIndex != -1){
					nums[zeroIndex++] = nums[i];
					nums[i]=0;
				}
			}
		}
		return nums;
	}
	
	/**
	Given an array of integers and an integer k, find out whether there are two 
	distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k. 
	**/
	public int[] distinctIndices(int[] unordArray, int indexDiff){
		int[] index = new int[2];
		int i =0;
		boolean found = false;
		while(i < unordArray.length){
			int k = i +1 ;
			while(k < unordArray.length &&  k -i <= indexDiff){
				System.out.println(unordArray[i] + " " + unordArray[k]);
				if(unordArray[i] == unordArray[k]){
					index[0]=i;
					index[1] =k;
					found = true;
					break;
				}
				k++;
			}
			if(found){
				break;
			}
			i++;
		}
		return index;
	}

	//[1,0,1,1]
	
	public int[] distinctIndicesMap(int[] unordArray, int indexDiff){
		int[] index = new int[2];
		int i =0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		while(i < unordArray.length){
			Integer temp = map.get(unordArray[i]);
			if(temp != null && (i - temp) <= indexDiff){
				index[0] = temp;
				index[1] = i;
				break;
			}else {
				map.put(unordArray[i], i);
			}
			i++;
		}
		return index;
	}

	/*
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> sett = new HashSet<Integer>();
        for( int i =0 ; i < nums1.length ; i++) {
            
            for(int k =0; k < nums2.length ; k ++ ) {
                if(nums2[k] ==nums1[i]){
                	sett.add(nums2[k]);
                }
            }
        }
        int[] ret = new int[sett.size()];
        Iterator<Integer> it = sett.iterator();
        int i =0;
        while(it.hasNext()){
        	ret[i] = it.next();
        	i++;
        }
        return (int[])set.toArray();
    }
    */
	/*
	Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and the majority element always exist in the array.
	Boyer - Moore algorithm 
	*/
	public int majorityElement_lc169(int[] nums){
		int candidate=nums[0], count = 0;
        for(int num : nums){
            if(count==0){
                count =1;
                candidate=num;
            }else if(candidate==num){
                count++;
            }else {
            	count--;
            }
        }
        return candidate;
	}
	
	/**
	 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
	 * The algorithm should run in linear time and in O(1) space.
	 * Boyer - Moore algorithm 
	 */
	public List<Integer> majorityElement_lc229(int[] nums) {
		List<Integer> rst = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return rst;
		}
		int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
		for (int num : nums) {
			if (num == candidate1){
				count1++;
			}else if (num == candidate2){
				count2++;
			}else if (count1 == 0) {
				candidate1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num == candidate1){
				count1 ++;
			}
			if (num == candidate2){
				count2 ++;
			}
		}
		if (count1 > nums.length/3){
			rst.add(candidate1);
		}
		if (count2 > nums.length/3){
			rst.add(candidate2);
		}
		return rst;
	}

	
	public void rotateArray_lc189(int[] array , int k){
      if(array.length ==1){
            return ;
        }
        int[] newA = new int[array.length];
		int j  = k;
		for(int i=0 ; i< array.length ; i++){
			 j = k+i;
			if(j >= (array.length)){
				newA[j - (array.length)] = array[i];
			}else{
				newA[j] = array[i];
			}
		}
		array=newA;
	}
	
	/**
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
		Given nums = [2, 7, 11, 15], target = 9,
		Because nums[0] + nums[1] = 2 + 7 = 9,
		return [0, 1].
	 */
	public int[] twoSum_lc1(int[] nums, int target) {
		  HashMap<Integer,Integer> numPos = new HashMap<Integer, Integer>();
	        for(int i = 0; i < nums.length ; i++) {
	            Integer position = numPos.get(target-nums[i]);
	            if(position == null) {
	                numPos.put(nums[i],i);
	            } else {
	                return new int[]{ i, position };
	            }
	        }
	        return null;
    }
	
	
	public boolean isIsomorphic_lc205(String sString, String tString) {
		char[] s = sString.toCharArray();
		char[] t = tString.toCharArray();

		int length = s.length;
		if (length != t.length)
			return false;

		char[] sm = new char[256];
		char[] tm = new char[256];

		for (int i = 0; i < length; i++) {
			char sc = s[i];
			char tc = t[i];
			if (sm[sc] == 0 && tm[tc] == 0) {
				sm[sc] = tc;
				tm[tc] = sc;
			} else {
				if (sm[sc] != tc || tm[tc] != sc) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public int countPrimes_lc204(int n) {
		if (n <= 2) {
			return 0;
		}
		int c = 1;
		boolean isNotPrime[] = new boolean[n + 1];
		for (int i = 3; i * i <= n; i = i + 2) {
			if (isNotPrime[i]) {
				continue;
			}
			for (int j = i * i; j <= n; j = j + 2 * i) {
				isNotPrime[j] = true;
			}
		}

		for (int i = 3; i < n; i = i + 2) {
			if (!isNotPrime[i]) {
				c++;
			}
		}
		return c;
	}
	
	
	public int[][] spiral2DMatrix_lc59(int n){
		int[][] mat = new int[n][n];
		//outer square
		int startValue =0;
		int firstIndex =0;
		
		for(int i=n; i>=1; i = i-2){
			if( i == 1){
				mat[firstIndex][firstIndex] = startValue+1;
			}
			
			for(int k= 0 ; k<i ; k++){
				int lastIndex =(n -1 )- firstIndex;
				//first row
				mat[firstIndex][firstIndex + k] = startValue + k +1 ;
				//last row 
				mat[lastIndex][lastIndex - k] = startValue + ((2 * i) -1) + k;
				if( k > 0  && k < i -1){
					// last col
					mat[firstIndex+k][lastIndex] = startValue +  i + k ;
					//first col
					mat[lastIndex - k][firstIndex] =startValue + ((3 * i)-2) + k;
				}
			}
			startValue = startValue + (4 * i) -4;
			firstIndex++ ;
		}
		return mat;
	}
	
	/*
	 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
	 For example,
	 Given nums =
	  [0, 1, 3] return 2.
	 5,3,1,6,2 return 4 
	  nums is not sorted and should return liner time 
	  
	  The basic idea is to use XOR operation. 
	  We all know that a^b^b =a, which 
	  means two xor operations with the same number will eliminate the
	   number and reveal the original number. 
	   In this solution, I apply XOR operation to both the index and value of the array. 
	   In a complete array with no missing numbers, the index and value should
	    be perfectly corresponding( nums[index] = index), 
	  so in a missing array, what left finally is the missing number.
	 */
	public int missingNumber_lc268(int[] nums ){
		int res = nums.length;
	    for(int i=0; i<nums.length; i++){
	        res ^= i;
	        res ^= nums[i];
	    }
	    return res;
	}
	
	public int findDuplicate(int[] nums) {
	    int slow = 0, fast = 0;
	    do{
	        slow = nums[slow];
	        fast = nums[nums[fast]];
	    }while(slow != fast);
	    slow = 0;
	    while(slow != fast){
	        slow = nums[slow];
	        fast = nums[fast];
	    }
	    return slow;
	}
	
	
	public boolean isValidSudoku_lc36(char[][] board) {
		char[] row = new char[8];
		char[] col = new char[8];
		char[] grid = new char[8];
		for (int i = 0; i <= 8; i++) {
			row = new char[9];
			col = new char[9];
			grid = new char[9];
			// small grid
			for (int j = 0; j <= 8; j++) {

				int rind = board[i][j] - '1';
				if( rind != -3 ){
					// rows
					if (row[rind] == board[i][j]) {
						return false;
					} else {
						row[rind] = board[i][j];
					}
				}
				// columns
				int cind = board[j][i] - '1';
				if( cind != -3 ){
					if (col[cind] == board[j][i]) {
						return false;
					} else {
						col[cind] = board[j][i];
					}
				}
				int gr = 3*(i/3);
	            int gc = 3*(i%3);
				// smaller grid
				int gind = board[gr+ j/3][gc+ j%3] - '1';
				if( gind != -3 ){
					if (board[gr+ j/3][gc+ j%3] != '.' && grid[gind] == board[gr][gc+ j%3]) {
						return false;
					} else {
						grid[gind] = board[gr+ j/3][gc+ j%3];
					}
				}
			}
			
		}
		return true;
	}
	
	public boolean isPowerOf(int num, int k) {
		int i = k;
		while (i <= num) {
			i = i * k;
		}
		return (i/k == num);
	}
	
	public boolean isPowerOf2(int num, int k) {
		if(num == 1){
			return true;
		}
		if(num%k != 0){
			return false;
		}
		return isPowerOf2(num/k,k);
	}

	public int[] maxProfit_lc121(int[] prices) {
		int[] ret = new int[3];
		int maxCur = 0, maxSoFar = 0;
		ret[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			int sum =  prices[i] - prices[i - 1];
			maxCur = maxCur + sum;
			maxCur = Math.max(0, maxCur);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		ret[2] = maxSoFar;
		return ret;
	}
	
	 public int lengthOfLastWord(String s) {
	        char[] arr = s.trim().toCharArray();
	        if(arr.length == 1 && arr[0] != ' '){
	            return 1;
	        }
	        for(int i=arr.length -1 ;i >= 0;i--){
	            if(arr[i] == ' '){
	                if(i == arr.length -1){
	                    return 0;
	                }
	                return arr.length -i-1;
	            }
	        }
	        return 0;
	    }



	 public int[] intersectionOfArray_lc350(int[] nums1, int[] nums2) {
	        if(nums1.length==0||nums2.length==0)
	            return new int[0];
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        int p1=0;
	        int p2=0;
	        List<Integer> res=new ArrayList<Integer>();
	        while(p1<nums1.length && p2<nums2.length){
	            if(nums1[p1]==nums2[p2]){
	                res.add(nums1[p1]);
	                p1++;
	                p2++;
	            }
	            else if(nums1[p1]<nums2[p2])
	                p1++;
	            else 
	                p2++;
	        }
	        int[] t=new int[res.size()];
	        for(int i=0;i<res.size();i++)
	            t[i]=res.get(i);

	        return t;
	    }
	}



