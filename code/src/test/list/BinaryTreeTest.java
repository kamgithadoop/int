package list;

import java.util.List;

import org.junit.Test;

import list.BinaryTree;
import list.BinaryTree.Node;

public class BinaryTreeTest {
	BinaryTree<String> tree = new BinaryTree<String>();
	
	@Test
	public void add(){
		tree.add("10", 10);
		tree.add("9", 9);
		tree.add("8", 8);
		tree.add("7", 7);
		tree.add("11", 11);
		tree.add("12", 12);
		tree.add("13", 13);
		tree.add("1", 1);
		tree.add("111", 111);
		tree.add("79", 79);
		tree.add("80", 80);
		tree.add("85", 85);
		tree.add("86", 86);
		tree.traverse();
		//System.out.println("Minumum value is " + tree.getMin());
		//System.out.println("Maximum value is " + tree.getMax());
		//Node<String> find = tree.find(11);
		//.out.println("find " + find);
		tree.delete(79);
		tree.traverse();
	}

	 @Test
	public void traverse(){
		 tree.add("4", 4);
		 tree.add("3", 3);
		 tree.add("2", 2);
		 tree.add("1", 1);
		 tree.add("5", 5);
		 tree.add("6", 6);
		 tree.add("7", 7);
			
		System.out.println(" in traverse ");
		printNodes(tree.inOrderTraverse());
		printNodes(tree.preOrderTraverse());
		printNodes(tree.postOrderTraverse());
	}
	
	private void printNodes(List<Node<String>> list){
		System.out.println();
		for(Node<String> n : list){
			System.out.print(n.getValue() +  "   ");
		}
		
	}
	

}
