package books.cracking;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import list.BinaryTree;
import list.BinaryTree.Node;
import list.LinkList.Link;

public class ProblemTest {

	Problem problem = new Problem();
	@Test
	public void uniqueChars_1_1() {
		String str = "abcdef";
		System.out.println(problem.uniqueChars_1_1(str));
		str = "abcdefc";
		System.out.println(problem.uniqueChars_1_1(str));
	}

	@Test
	public void removeDupChars_1_3() {
		String str = "abcdef";
		System.out.println(problem.removeDupChars_1_3(str));
		str = "abcdaefc";
		System.out.println(problem.removeDupChars_1_3(str));
	}
	
	@Test
	public void isAnagram_1_4() {
		String str1 = "abc";
		String str2 = "xyz";
		System.out.println(problem.isAnagram_1_4(str1, str2));
		str1 = "abc";
		str2 = "xyzs";
		System.out.println(problem.isAnagram_1_4(str1, str2));
		str1 = "vbnmc";
		str2 = "ncmvb";
		System.out.println(problem.isAnagram_1_4(str1, str2));
	}
	
	@Test
	public void replaceCharByString_1_5(){
		String original = "abc";
		char reChar ='b';
		String reString = "xyzxyz";
		System.out.println(problem.replaceCharByString_1_5(original, reChar, reString));
		original = "abc";
		reChar ='z';
		reString = "xyzxyz";
		System.out.println(problem.replaceCharByString_1_5(original, reChar, reString));
	}
	
	@Test 
	public void rotateMatrix_1_6(){
		int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
		int[][] newMatrix = problem.rotateMatrix_1_6(matrix);
		System.out.println(newMatrix);
	}

	@Test 
	public void rotateMatrixInplace_1_6(){
		int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
		//int[][] matrix = new int[][]{{1,2}, {4,5}};
		int[][] newMatrix = problem.rotateMatrixInplace_1_6(matrix);
		printMatrix(newMatrix);
		
		int[][] matrix1 = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
		int[][] newMatrix1 = problem.rotateMatrixInplace_1_6(matrix1);
		printMatrix(newMatrix1);
		int[][] matrix2 = new int[][]{{1,2,3,4,5,6}, 
									  {7,8,9,10,11,12}, 
									  {13,14,15,16,17,18},
									  {19,20,21,22,23,24},
									  {25,26,27,28,29,30},
									  {31,32,33,34,35,36},
									  };
		problem.rotateMatrixInplace_1_6(matrix2);
		printMatrix(matrix2);
	}
	
	public void printMatrix(int[][] matrix){
		System.out.println();
		for(int i=0 ; i < matrix.length ; i++){
			System.out.println();
			for(int j=0 ; j< matrix[0].length; j++){
				System.out.print(matrix[i][j]+",");
			}
		}
	}
	
	@Test
	public void replaceMatrixWithZero_1_7(){
		int[][] matrix = new int[][]{{0,2,3,1}, {4,5,0,2}, {7,8,9,4}};
		printMatrix(matrix);
		problem.replaceMatrixWithZero_1_7(matrix);
		printMatrix(matrix);
	}
	
	@Test 
	public void removeMiddleNode_2_3(){
		Link<String> head = null;
		Link<String> next = null;
		Link<String>  middle = null;
		for(int i=1;i <= 10;i++){
			Link<String> current = new Link<String>(i+"",next,null);
			next = current;
			if( i == 10){
				head = current;
			}
			if( i == 5){
				middle = current;
			}
		}
		problem.removeMiddleNode_2_3(middle);
		printLinkedList(head);
	}
	
	@Test 
	public void addLinkedList_2_4(){
		Link<Integer> tail1 = new Link<Integer>(5,null);
		Link<Integer> middle1 = new Link<Integer>(1,tail1);
		Link<Integer> head1 = new Link<Integer>(3,middle1);

		Link<Integer> tail2 = new Link<Integer>(2,null);
		Link<Integer> middle2 = new Link<Integer>(9,tail2);
		Link<Integer> head2 = new Link<Integer>(5,middle2);
		Link<Integer> newHead = problem.addLinkedList_2_4(head1, head2);
		printLinkedList(newHead);
	}

	private void printLinkedList(Link head){
		while(head != null){
			System.out.println(head.getValue());
			head = head.getNext();
		}
	}
	
	@Test
	public void findLinkedListCycleStart_2_5(){
		Link<Integer> head = null;
		Link<Integer> next = null;
		Link<Integer> cycle = null;
		Link<Integer> tail = null;
		for(int i=1; i<=10; i++){
			Link<Integer> current = new Link<Integer>(i,next,null);
			next = current;
			head = current;
			if(i==7){
				cycle = current;
			}
			if(i==1){
				tail = current;
			}
		}
		tail.setNext(cycle);;
		Link<Integer> newlist = problem.findLinkedListCycleStart_2_5(head);
	}
	
	@Test 
	public void createBTreeMinHeight_4_3(){
		int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
		Node<Integer> root = problem.createBTreeMinHeight_4_3(array);
		
		System.out.println(root);
		Map<Integer, List<Node<Integer>>> map = problem.createListfromBTree_4_4(root);
		for(Integer in : map.keySet()){
			List<Node<Integer>> list = map.get(in);
			System.out.println();
			for(Node<Integer> n : list){
				System.out.println( n.getValue() + ",");
			}
		}
	}
	
	@Test 
	public void coinChange_lc322(){
		int[] coins = new int[]{1, 2, 5};
		int amount = 11;
		int num = problem.coinChange_lc322(amount, coins);
		System.out.println(num);
	}
}

