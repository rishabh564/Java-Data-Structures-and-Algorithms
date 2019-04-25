package trees.binarySearchTree;

public class BinarySearchTree<Key extends Comparable<Key>, T> {
	
	Node<Key, T> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public void put(Key key, T payload) {
		if(this.root  == null) 
			this.root = new Node<Key, T>(key, payload, null, null, null);
		else if(this.root.key.equals(key))
			this.root.payload = payload;
		else 
			this.put(key, payload, this.root);
	}
	
	private void put(Key key, T payload, Node<Key, T> node) {
		if(node.key.equals(key))
			node.payload = payload;
		else {
			int comp = node.key.compareTo(key);
			if(comp > 0) {
				if(node.hasLeftChild())
					this.put(key, payload, node.leftChild);
				else
					node.leftChild = new Node<Key, T>(key, payload, node, null, null);
			}
			else {
				if(node.hasRightChild())
					this.put(key, payload, node.rightChild);
				else
					node.rightChild = new Node<Key, T>(key, payload, node, null, null);
			}
		}
	}
	
	public T get(Key key) {
		if(this.root == null)
			return null;
		else if(this.root.key.equals(key))
			return this.root.payload;
		else {
			return this.get(key, this.root);
		}
	}
	
	private T get(Key key, Node<Key, T> node) {
		int comp = node.key.compareTo(key);
		if(comp > 0) {
			if(node.hasLeftChild())
				return this.get(key, node.leftChild);
			else
				return null;
		}
		else {
			if(node.hasRightChild())
				return this.get(key, node.rightChild);
			else
				return null;
		}
	}
	
	public  boolean contains(Key key) {
		return false;
	}
	
	public void inorder() {
		if(this.root != null)
			this.inorder(this.root);
	}
	
	private void inorder(Node<Key, T> node) {
		if(node.hasLeftChild())
			this.inorder(node.leftChild);
		System.out.println(node.payload);
		if(node.hasRightChild())
			this.inorder(node.rightChild);
	}
	
	
}
