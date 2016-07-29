package algorithm.string;


/**
 * 
 * String pattern matching alogorithm
 * anagram
 * pallindrome 
 * substring 
 *
 */
public class RabinKarp {
	
	private int PRIME = 101;
	
	private int patternLength ;
	
	private int patternHash;

	private int[] hashArray;
	
	private char[] str;
	
	private char[] pattern;
	
	int counter;
	
	public RabinKarp(char[] str, char[] pattern){
		this.str = str;
		this.pattern=pattern;
		patternLength = pattern.length;
		hashArray = new int[str.length - patternLength +1];
		patternHash =(int) pattern[0];
		
		int strHash =0;
		for(int k=0; k<(str.length - patternLength+1); k++){
			if(k ==0){
				strHash = str[k];
				for(int j=1;j<patternLength;j++){
					strHash+=(str[j] * Math.pow(PRIME, j));
					patternHash +=  (pattern[j] * Math.pow(PRIME, j));
					counter++;
				}
				hashArray[k] = strHash;
			}else{
				hashArray[k] = getRollingHash(k) ;
				counter++;
			}
		}
	}
	
	private int getRollingHash(int k){
		int currentHash = hashArray[k-1]  - str[k-1];
		int lastIndex=k+patternLength-1;
		double hash = str[lastIndex] * Math.pow(PRIME, patternLength -1);
		return ((currentHash/PRIME) + (int)hash);
	}
	
	public int matchPattern(){
		int matchIndex =-1;
		for(int i=0; i < hashArray.length; i++){
			boolean match = false;
			if(hashArray[i] == this.patternHash){
				match = true;
				for(int k=i; k<patternLength; k++){
					if(str[k] != pattern[k-i]){
						match = false;
					}
				}
			}
			counter++;
			if(match){
				matchIndex = i;
				break;
			}
			
		}
		//System.out.println("counter match " +counter);
		return matchIndex;
	
	}
	
}
