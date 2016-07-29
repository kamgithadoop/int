package algorithm.string;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class StringMatchTest {
	
	StringMatch stringMatch = new StringMatch();

	@Test
	public void patterMatchRabinCarp() {
		//16 * 4
		int index = stringMatch.patterMatchRabinCarp("1234567890123456", "6789");
		System.out.println("patterMatchRabinCarp " + index);
		index = stringMatch.patterMatchNaive("1234567890123456", "6789");
		System.out.println("patterMatchNaive " + index);
	}
	
	
	@Test
	public void palinDrome() {
		boolean isPalin = stringMatch.palinDrome(new char[]{'a','b','c','b','a'});
		System.out.println(isPalin);
	}

	@Test
	public void GridMatch2D() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int R = in.nextInt();
			int C = in.nextInt();
			String G[] = new String[R];
			for (int G_i = 0; G_i < R; G_i++) {
				G[G_i] = in.next();
			}
			int r = in.nextInt();
			int c = in.nextInt();
			String P[] = new String[r];
			for (int P_i = 0; P_i < r; P_i++) {
				P[P_i] = in.next();
			}

			boolean found = false;
			int[] index = new int[r];
			for (int P_i = 0; P_i < r; P_i++) {
				found = false;
				int lastIndex = 0;
				for (int G_i = 0; G_i < R; G_i++) {
					found = stringMatch.patterMatchNaive(G[G_i], P[P_i]) != -1;
					if (found) {
						 System.out.println("Pattern " + P[P_i] + " found in G[G_i]" + G[G_i] + found);
						 lastIndex =G_i; 
						//break;
					}
				}
				if (!found) {
					break;
				}else{
					index[P_i] = lastIndex;
				}
			}
			boolean foundInGrid = false;
			for (int i = 0; i < r; i++) {
				if (i != 0) {
					foundInGrid = (index[i] - index[i - 1]) == 1;
				}
			}
			if (foundInGrid) {
				System.out.println("YES");

			} else {
				System.out.println("NO");
			}
		}
	}
	
	@Test
	public void reverseVowel(){
		System.out.println(stringMatch.reverseVowel("leetcode"));
	}
	
	@Test
	public void reverseString2(){
		System.out.println(stringMatch.reverseString2("Kamlesh"));
	}
	
	@Test
	public void titleToNumber_lc171(){
		int ret = stringMatch.titleToNumber_lc171("AC");
		System.out.println(ret);
	}
	
	@Test
	public void reverseWords(){
		String rev = stringMatch.reverseWords("this is not right what do you say");
		System.out.println(rev);
	}
	
	
	@Test
	public void getPermutations(){
		String str = "abc";
		Set<String> per = stringMatch.getPermutations(str);
		System.out.println(per);
		
	}
}

