package list;

import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.Test;

public class DisjointSetTest {
	/**
		3 6
		Q 1
		M 1 2
		Q 2
		M 2 3
		Q 3
		Q 2
	 **/

	@Test
	public void mergingCommunityTemp() {
		Scanner sc = new Scanner(System.in);
		int nPeople = sc.nextInt();
		System.out.println(nPeople);
		int nQuery = sc.nextInt();
		for (int i = 1; i <= nQuery; i++) {
			String str = sc.next();
			if (str.startsWith("Q")) {
				Integer key = sc.nextInt();
				System.out.println(key);
			} else {
				int val1 = sc.nextInt();
				int val2 = sc.nextInt();
				System.out.println(val1);
				System.out.println(val2);
			}
		}
	}
	
	@Test
	public void mergingCommunity() {
		Scanner sc = new Scanner(System.in);
		int nPeople = sc.nextInt();
		System.out.println(nPeople);
//		DisjointSet<Integer> dSet = new DisjointSet<Integer>();
//		for (int i = 1; i <= nPeople; i++) {
//			dSet.addToSet(i, i);
//		}
		int nQuery = sc.nextInt();
		String str = sc.nextLine();
		StringTokenizer token = new StringTokenizer(str, " ");
		while(token.hasMoreTokens()){
			System.out.println(token.nextToken());
		}
		for (int i = 1; i <= nQuery; i++) {

//			if (type.startWith("Q")) {
				Integer key = sc.nextInt();
//				System.out.println(dSet.getSetSize(key));
				System.out.println(key);
//			} else {
				int val1 = sc.nextInt();
				int val2 = sc.nextInt();
				System.out.println(val1);
				System.out.println(val2);
//				Integer key1 =  dSet.findSet(val1);
//				Integer key2 =  dSet.findSet(val2);
//				dSet.union(key1, key2);
//			}
		}
	}

}
