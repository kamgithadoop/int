package books.lc;

import java.util.Map;
import java.util.Stack;

public class LeetCode {
	
	/*
		Given a string, find the length of the longest substring without repeating characters.
	*/
	public String longestSubNoRepeat(String str){
		char[] array = str.toCharArray();
		return "  ";
	}

	
	
	public int blub_switcher_319(int n){
		int count = 1 ;
		
		return  count;
	}

	/**
	 * Remove the minimum number of invalid parentheses in order to make the input string valid.
	 * "()())()" -> "()()()"
	 * @param st
	 * @return
	 */
	public String remInvalidParan_lc319(String st){
		char[] arr = st.toCharArray();
		Stack<Character> stck  = new Stack<Character>();
		int count = 0;
		for(int i =0 ; i < arr.length ; i++){
			if(arr[i] == ')'){
				stck.add(arr[i]);
			}else {
				count++;
			}
		}
		//"()())()"
		String ret = null;
		for(int i =0 ; i < arr.length ; i++){
			if(arr[i] != '('){
				continue;
			}
			char c= ' ';
			if(!stck.isEmpty()){
				c = stck.pop();
			}
			count--;
			if(count == stck.size()){
				ret = ret + arr[i] + c;
			}
		}
		return null;
	}
	
	/*
	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
	(you may want to display this pattern in a fixed font for better legibility)
		P   A   H   N
		A P L S I I G
		Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	*/
	public String zigZagConversion_lc6(String str, int rows){
		if(str == null || num == 0){
			return str;
		}
		char[] array = str.toCharArray();
		int len = array.length;
		int cols = (len/2);
		char[][] arr2d = new char[rows][cols];
		int cInd = 0; 
		int rInd = 0;
		int i = 0;
		while(i < array.length ){
			if(((rInd + 1)%2 != 0) && 
					(cInd != 0 && (cInd + 1)%2 == 0)){
				arr2d[rInd][cInd]=  ' ';
			}else{
				arr2d[rInd][cInd]= array[i];
				i++;
			}

			if(rInd + 1 == rows){
				cInd++;
				rInd=0;
			}else{
				rInd++;
			}
		}
		StringBuffer sbr = new StringBuffer();
		for(int k=0; k <rows;k++){
			for(int j=0 ;j < cols ; j++){
				if(arr2d[k][j] != ' '){
					sbr.append(arr2d[k][j]);
				}
			}
		}
		return sbr.toString().trim();
	}
}
