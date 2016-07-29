package list;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree<E> {
	
	private Node<E> root;
	
	private int size;
	
	enum TraversalType {
		IN_ORDER,
		PRE_ORDER,
		POST_ORDER
	}
	
	public  int height(Node<E> node){
		return getHeight(root);
	}
	
	public int getHeight(Node<E> node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
	
	public void traverse() {
		visit(this.root);
	}

	public List<Node<E>> inOrderTraverse() {
		List<Node<E>> list = new LinkedList<Node<E>>();
		visitAndAdd(this.root, list,TraversalType.IN_ORDER);
		return list;
	}
	
	public List<Node<E>> preOrderTraverse() {
		List<Node<E>> list = new LinkedList<Node<E>>();
		visitAndAdd(this.root, list,TraversalType.PRE_ORDER);
		return list;
	}

	
	public List<Node<E>> postOrderTraverse() {
		List<Node<E>> list = new LinkedList<Node<E>>();
		visitAndAdd(this.root, list,TraversalType.POST_ORDER);
		return list;
	}
	
	public void visitAndAdd(Node<E> current, List<Node<E>> list, TraversalType type){
		if(current != null){
			if(type == TraversalType.IN_ORDER){
				visitAndAdd(current.getLeft(),list, type);
				list.add(current);
				visitAndAdd(current.getRight(),list, type);
				
			}else if(type == TraversalType.PRE_ORDER){
				list.add(current);
				visitAndAdd(current.getLeft(),list, type);
				visitAndAdd(current.getRight(),list, type);
			}else{
				visitAndAdd(current.getLeft(),list, type);
				visitAndAdd(current.getRight(),list, type);
				list.add(current);
			}
		}
	}

	public Node<E> find(int key) {
		return find(root, key);
	}
	
	public void delete(int key) {
		delete(root, key);
	}
	
	public boolean isBalanced(){
		return checkBalanced(this.root) != -1;
	}
	
	public int checkBalanced(Node<E> node){
		if(node == null){
			return 0;
		}
		int leftH = checkBalanced(node.getLeft());
		if(leftH == -1){
			return -1;
		}
		int rightH = checkBalanced(node.getRight());
		if(rightH == -1){
			return -1;
		}
		
		if(Math.abs(leftH - rightH)  >1 ){
			return -1;
		}
		return (1 + Math.max(leftH, rightH));
	}
	

	private void delete(Node<E> root, int key){
		Node<E> current = root;
		Node<E> parent = root;
		while(current != null){
			if(current.getKey() == key){
				break;
			}else if(current.getKey() >  key){
				parent = current;
				current = current.getLeft();
			}else {
				parent = current;
				current = current.getRight();
			}
		}
		//Node to be deleted has no child
		if(current.getLeft() == null && current.getRight() == null){
			if(parent.getKey() > current.getKey()){
				parent.setLeft(null);
			}else{
				parent.setRight(null);
			}
			return;
		}
		// Node to be deleted has one child
		if(current.getLeft() == null || current.getRight() == null){
			if(parent.getKey() > current.getKey()){
				parent.setLeft(current.getLeft() != null ?current.getLeft() : current.getRight() );
			}else{
				parent.setRight(current.getLeft() != null ?current.getLeft() : current.getRight() );
			}
			return ;
		}
		
		// Node to be deleted has two child
		Node<E> leftMost = left(current.getRight());
		parent.setRight(leftMost);
		leftMost.setRight(current.getRight());
		leftMost.setLeft(current.getLeft());
		
	}

	
	private  Node<E> find(Node<E> current, int key){
		if(current == null){
			return null;
		}
		if(current.getKey()== key){
			return current;
		}else if(current.getKey() > key){
			return find(current.getLeft(), key);
		}else{
			return find(current.getRight(), key);
		}
	}
	public E getMin(){
		return left(root).getValue();
	}

	public E getMax(){
		return right(root).getValue();
	}

	public Node<E> right(Node<E> current){
		if(current.getRight() == null){
			return current;
		}
		System.out.println(current.getValue());
		return right(current.getRight());
	}

	public Node<E> left(Node<E> current){
		if(current.getLeft() == null){
			return current;
		}
		System.out.println(current.getValue());
		return left(current.getLeft());
	}

	
	public void visit(Node<E> current){
		if(current != null){
			visit(current.getLeft());
			System.out.println(current.getKey());
			visit(current.getRight());
		}
	}
	
	
	public Node<E> add(E value, int key){
		if(root == null || root.getKey() == key){
			root = new Node<E>(key, value, null, null);
			size++;
			return root;
		}
		Node<E> parent= (size ==1 ? root : getNode(root, key));
		Node<E> nNode = null;
		if(key > parent.getKey()){
			nNode = new Node<E>(key, value, parent.getRight(), null);
			parent.setRight(nNode);
		}else{
			nNode = new Node<E>(key, value, null, parent.getLeft());
			parent.setLeft(nNode);
		}
		size++;
		return nNode;
	}
	
	public Node<E> getNode(Node<E> current, int key){
		if(current == null){
			return null;
		}
		Node<E> retVal =null;
		if(current.getKey() > key){
			if(current.getLeft()==null || current.getLeft().getKey() < key){
				retVal =  current;
			}else {
				retVal = getNode(current.getLeft(), key);
			}
		}else if(current.getKey() < key){
			if(current.getRight()==null || current.getRight().getKey() > key){
				retVal =  current;
			}else{
				retVal = getNode(current.getRight(), key);
			}
		}
		return retVal;
	}


	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node<E> getRoot() {
		return root;
	}

	public void setRoot(Node<E> root) {
		this.root = root;
	}

	public static class Node<E>{
		
		private int key;
		private E value;
		private Node<E> right;
		private Node<E> left;
		
		public Node(int key, E val, Node<E> right , Node<E> left){
			this.key=key;
			this.value=val;
			this.right=right;
			this.left=left;
		}
		
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public E getValue() {
			return value;
		}
		public void setValue(E value) {
			this.value = value;
		}
		public Node<E> getRight() {
			return right;
		}
		public void setRight(Node<E> right) {
			this.right = right;
		}
		public Node<E> getLeft() {
			return left;
		}
		public void setLeft(Node<E> left) {
			this.left = left;
		}
	}
}
