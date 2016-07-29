package books.cracking;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import list.BinaryTree;
import list.BinaryTree.Node;
import list.LinkList.Link;

public class Problem {

	public boolean uniqueChars_1_1(String str) {
		char[] arr = str.toCharArray();
		int[] ascii = new int[256];
		for(int i=0; i < arr.length; i++){
			int index = arr[i] - 'a';
			if(ascii[index] != 0){
				return false;
			}
			ascii[index] = 1;
		}
		return true;
	}

	//abcdef
	public String removeDupChars_1_3(String str) {
		char[] arr = str.toCharArray();
		for(int i=0; i < arr.length; i++){
			boolean isDup =false;
			for(int j = i +1; j < arr.length ; j++){
				if(arr[i] == arr[j]){
					arr[j]= 127;
					isDup=true;
				}
			}
			if(isDup){		
				arr[i]=127;
			}
		}
		return new String(arr);
	}
	
	//asas dddd
	//abc cba
	//xvdc dcxf
	public boolean isAnagram_1_4(String str1, String str2){
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		if(arr1.length != arr2.length){
			return false;
		}
		int[] ascii = new int[256];
		for(int i=0; i < arr1.length; i++){
			int index = arr1[i] - 'a';
			ascii[index] = 1;
		}
		
		for(int i=0; i < arr2.length; i++){
			int index = arr2[i] - 'a';
			if(ascii[index] != 1 ){
				return false;
			}
		}
		return true;
	}
	
	public String replaceCharByString_1_5(String original, char reChar, String reString){
		int reStringLen = reString.length();
		int reCharCount = 0;
		char[] oChar = original.toCharArray();
		for(char ch : oChar){
			if(ch == reChar){
				reCharCount++;
			}
		}
		int newCount = original.length() - reCharCount + (reCharCount * reStringLen);
		char[] newStr = new char[newCount];
		int j =0;
		for(int i =0; i < newCount ; i++){
			if(oChar[j] == reChar){
				int k=1;
				while(k <= reStringLen){
					newStr[i + k-1] = reString.toCharArray()[k-1];
					k++;
				}
				i = i +k -2;
			}else{
				newStr[i] = oChar[j] ;
			}
			j++;
		}
		return new String(newStr);
	}
	
	
	public int[][] rotateMatrix_1_6(int[][] matrix){
		int n = matrix.length;
		int[][] rotate = new int[n][n];
		for( int r=0 ; r < n  ; r++){
			for( int c=0 ; c < n  ; c++){
				rotate[c][n -1 -r] = matrix[r][c];
			}
		}
		return rotate;
	}
	
	//TODO
	
	public int[][] rotateMatrixInplace_1_6(int[][] matrix){
		int n = matrix.length;
		//store the first row 
		int startIndex =0;
		int endIndex = n-1;
		for(int i=n ; i>1 ; i=i-2){
			int[] temp = new int[endIndex-startIndex+1];
			if(i ==2){
				int t = matrix[1][1];
				matrix[1][1] = matrix[2][1];
				matrix[2][1] = matrix[2][2];
				matrix[2][2] = matrix[1][2];
				matrix[1][2] = t;
				break;
			}
			for(int j=startIndex ; j<endIndex; j++){
				temp[j] = matrix[startIndex][j];
				//0 column to 0 row 
				matrix[startIndex][j] = matrix[endIndex-j][startIndex];
				//mn row to 0 column 
				matrix[endIndex-j][startIndex] = matrix[endIndex][endIndex-j];
				//mn column  to mn row 
				matrix[endIndex][endIndex-j] = matrix[j][endIndex];
				//0 row  to mn column
				matrix[j][endIndex]=temp[j];
			}
			startIndex++;
			endIndex = endIndex-startIndex;
		}
		return matrix;
	}
	
	public static void rotateMatrixInplace_1_6_2(int arr[][], int N) {
	    int layer = 0;
	    while(layer < N/2) {
	        int low = layer;
	        int high = N - 1 - layer;
	        for(int i = low; i < high; i++) {
	            int t = arr[low][i];
	            arr[low][i] = arr[i][high];
	            arr[i][high] = arr[high][N-i-1];
	            arr[high][N-i-1] = arr[N-i-1][low];
	            arr[N-i-1][low] = t;
	        }
	        layer++;
	    }
	}
	
	public void replaceMatrixWithZero_1_7(int arr[][]){
		int r = arr.length;
		int c = arr[0].length;
		int[] row = new int[r];
		int[] col = new int[c];
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(arr[i][j] == 0){
					row[i] =1;
					col[j] =1;
				}
			}
		}
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(row[i]==1 ||col[j] ==1 ){
					arr[i][j] =0;
				}
			}
		}
	}
	
	public void removeMiddleNode_2_3(Link<String> middle){
		Link<String> nextToMiddle = middle.getNext();
		middle.setValue(nextToMiddle.getValue());
		middle.setNext(nextToMiddle.getNext());
		
		
	}
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public Link<Integer> addLinkedList_2_4(Link<Integer> list1, Link<Integer> list2){
		Link<Integer> newPrev = null;
		Link<Integer> newHead = null;
		Link<Integer> head1 = list1;
		Link<Integer> head2 = list2;
		int carry = 0;
		while(head1 != null && head2 != null){
			Link<Integer> newList = new Link<Integer>();
			newList.setNext(newPrev);;
			int val = head1.getValue() + head2.getValue();
			if(val >= 10 ){
				newList.setValue(val -10 + carry);
				carry = 1;
			}else{
				newList.setValue(val + carry);
			}
			head1 = head1.getNext();
			head2 = head2.getNext();
			newPrev = newList;
			if(head1 == null && head2 == null){
				newHead = newList;
			}
		}
		return newHead;
	}
	
	
	public Link<Integer> findLinkedListCycleStart_2_5(Link<Integer> head) {
		Link<Integer> n1 = head;
		Link<Integer> n2 = head;

		// Find meeting point
		while (n2.getNext() != null) {
			n1 = n1.getNext();
			n2 = n2.getNext().getNext();
			if (n1 == n2) {
				break;
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (n2.getNext() == null) {
			return null;
		}

		/*
		 * Move n1 to Head. Keep n2 at Meeting Point. Each are k steps /* from
		 * the Loop Start. If they move at the same pace, they must meet at Loop
		 * Start.
		 */
		n1 = head;
		while (n1 != n2) {
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
		// Now n2 points to the start of the loop.
		return n2;
	}
	
	/**
	 * 1,2,3,4,5,6
	 * @param array
	 * @return
	 */
	
	public  Node<Integer> createBTreeMinHeight_4_3(int[] array){
		 return addToTree(array, 0, array.length - 1);
	}
	
	@SuppressWarnings("unchecked")
	public Node<Integer> addToTree(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node<Integer> n = new Node<Integer>(arr[mid], arr[mid], null, null);
		n.setLeft(addToTree(arr, start, mid - 1));
		n.setRight(addToTree(arr, mid + 1, end));
		return n;
	}
		
	public  Map<Integer, List<Node<Integer>>> createListfromBTree_4_4(Node<Integer> root){
		 Map<Integer, List<Node<Integer>>> map = new HashMap<Integer, List<Node<Integer>>>();
		 List<Node<Integer>> list = new LinkedList<Node<Integer>>();
		 list.add(root);
		 map.put(1, list);
		  populateLinkedList(root.getRight(), root.getLeft(), map, 2);
		  return map;
	}
	
	private void populateLinkedList(Node<Integer> right,Node<Integer> left,  Map<Integer, List<Node<Integer>>> map,int index){
		if(right == null && left==null){
			return;
		}
		List<Node<Integer>> list = map.get(index);
		
		if(list == null){
			 list = new LinkedList<Node<Integer>>();
			 map.put(index, list);
		}
		if(right != null){
			list.add(right);
			populateLinkedList(right.getRight(), right.getLeft(),map,index+1);
		}
		if(left != null){
			list.add(left);
			populateLinkedList(left.getRight(), left.getLeft(),map,index+1);
		}
	}
	
	
	public int coinChange_lc322(int amount, int[] coins) {
		int[] change = new int[amount + 1];
		Arrays.fill(change, -1);
		change[0] = 0;

		for (int i = 1; i <= amount; i++) {
			boolean flag = false;
			int min = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i >= coin && change[i - coin] != -1) {
					flag = true;
					min = Math.min(min, change[i - coin]);
				}
			}
			if (flag) {
				change[i] = 1 + min;
			}
		}
		return change[amount];
	}
 }
