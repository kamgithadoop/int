package algorithm.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * allPermutation
 * longestPalinDrome 
 * pallindrome  aba, same characters forward and backword 
 * substring 
 *  all combination of string
 */

public class StringMatch {

	public String[] allPermutations(){
		return null;
	}
	
	public int patterMatchRabinCarp(String str, String pattern){
		RabinKarp rabinKarp = new RabinKarp(str.toCharArray(), pattern.toCharArray());
		return rabinKarp.matchPattern();
	}

	public int patterMatchNaive(String main, String patt){
		char[] str = main.toCharArray();
		char[] pattern = patt.toCharArray();
		int patternIndex = -1;
		boolean matchFound =false;
		for(int n=0; (n<str.length && (n + pattern.length - 1) < str.length) ; n++){
			
			if(str[n] == pattern[0]){
				matchFound = true;
				int pattIndex = 1;
				while(pattIndex <pattern.length){
					if(str[n+pattIndex] != pattern[pattIndex]){
						matchFound = false;
					}
					pattIndex++;
				}
			}
			if(matchFound){
				patternIndex = n;
				break;
			}
		}
		return patternIndex;
	}
	
	public boolean palinDrome(char[] chArray) {
        boolean isPalin = true;
        int len = chArray.length;
        int end =  chArray.length -1;
        for(int i=0; i < len/2 ; i++,end--){
        	if(chArray[i] != chArray[end]){
        		isPalin = false;
        		break;
        	}
        }
        return isPalin;
	}
	
	public String longestPalindrome() {
		String s = "";
		if (s.isEmpty()) {
			return null;
		}
	 
		if (s.length() == 1) {
			return s;
		}
	 
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}
	 
	// Given a center, either one letter or two letter, 
	// Find longest palindrome
	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	
	public String reverseVowel(String s) {
		char[] original = s.toCharArray();
		char[] vowel = new char[original.length];
		int j=0;
		for(int i=(original.length -1) ; i >= 0 ; i--){
			if(isVowel(original[i])){
				vowel[j++] = original[i];
			}
		}
		j=0;
		for(int i=0 ; i < original.length ; i++ ){
			if(isVowel(original[i])){
				original[i] = vowel[j++];
			}
		}
		return new String(original);
	}
	
	private boolean isVowel(char ch){
		return (ch =='a' || ch =='e'|| ch =='i'|| ch =='o'|| ch =='u');
	}
	public String reverseString2(String s) {
		char[] o = s.toCharArray();
		char[] r = new char[o.length];
		int k = 0;
		for (int i = o.length - 1; i >= 0; i--) {
			r[k++] = o[i];
		}
		return new String(r);
	}

	public String reverseString(String s) {
		if (s.length() == 1) {
			return s;
		}
		return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
	}
	
	/**
	 * matches if given grid is inside a grid
	 */
	public void gridMatch2D(String[]outerGrid, String[] innerGrid){
		for(int i=0;i < outerGrid.length; i++){
			String outStr = outerGrid[i];
			for(int j=0;j < innerGrid.length; i++){
				String innerStr = innerGrid[i];
		}
	}
	}
	
	public int titleToNumber_lc171(String s) {
        int num = 64;
        char[] a = s.toCharArray();
        if(a.length ==0 ){
            return 0;
        }
        if(a.length ==1 ){
            return (int)a[0] - 64;
        }
        if(a.length == 2 && startWithAA(a, 0 ,1)){
            return 27;
        }
        if(a.length == 2 && startWithAB(a, 0, 1 )){
            return 28;
        }
        int count = 0;
        for(int i =0; i < a.length ;i++){
            if(i == a.length -2 ){
               if(startWithAA(a, i, i+1)){
                   count = count + 27;
               }else if(startWithAA(a, i, i+1)){
                   count = count + 27;
               }else{
                   count = count + (int)a[i] -64;
               }
            }else {
               count = count + (int)a[i] -64;
            }
        }
        return count;
    }
    
    
    
    private boolean startWithAB(char[] a, int f, int s ){
        return (a[f] == 'A' && a[s] == 'B') ;
    }
    
    private boolean startWithAA(char[] a,int f, int s ){
        return (a[f] == 'A' && a[s] == 'A');
    }
    
	public String reverseWords(String s) {
        if(s.trim().equals("") ){
            return "";
        }
		int lastIndex = s.lastIndexOf(' ');
		if(lastIndex < 0 ){
			return s;
		}
		return s.substring(lastIndex) + reverseWords(s.substring(0,lastIndex ));
	}


	public Set<String> getPermutations(String s) {
		Set<String> permutations = new HashSet<String>();
		if (s == null) { 
			return null;
		} else if (s.length() == 0) { 
			permutations.add("");
			return permutations;
		}

		char first = s.charAt(0); 
		String remainder = s.substring(1); 
		Set<String> words = getPermutations(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				permutations.add(insertCharAt(word, first, j));
			}
		}
		return permutations;
	}

	public String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
}
