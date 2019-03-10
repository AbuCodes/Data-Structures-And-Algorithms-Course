/* This is the node constructor that defines each node for our Binary Tree.
 * data stores the value of our node
 * lchild is the pointer to the left child of given node
 * rchild is the pointer to the right child of given node	
 */
class Node {
	int data;
	Node lchild, rchild;

	// This constructor also sets left child and right child nodes to null
	// While also setting
	public Node(int n) {
		data = n;
		lchild = null;
		rchild = null;
	}
}

/*
 * In this class we define the methods in our binary tree such as: insert();
 * postOrderNumbers(); preOrderNumber(); inOrderNumber();
 */
class Bt {
	Node root;

	// When a new Bt object is created this constructor sets the root to null
	Bt() {
		root = null;
	}
	
	//This method will insert numbers postOrder
	void postOrderNumbers(Node p) {
		if (p == null) {
			return;
		}
		postOrderNumbers(p.lchild);
		postOrderNumbers(p.rchild);
		System.out.print(p.data + " ");
	}
	
	//This method will insert numbers inOrder
	void inOrderNumber(Node p) {
		if (p == null) {
			return;
		}
		inOrderNumber(p.lchild);
		System.out.print(p.data + " ");
		inOrderNumber(p.rchild);
	}
	
	//This method will insert numbers preOrder
	void preOrderNumber(Node p) {
		if (p == null) {
			return;
		}
		System.out.print(p.data + " ");
		preOrderNumber(p.lchild);
		preOrderNumber(p.rchild);
	}

	// This method initializes the postOrderNumbers method by pointing it to root
	void postOrderNumbers() {
		postOrderNumbers(root);
	}

	// This method initializes the inOrderNumber method by pointing it to root
	void inOrderNumber() {
		inOrderNumber(root);
	}

	// This method initializes the preOrderNumber method by pointing it to root
	void preOrderNumber() {
		preOrderNumber(root);
	}
}

// This is our driver class for our binary tree
public class BinaryTree {

	public static void main(String[] args) {
		Bt tree = new Bt();
		tree.root = new Node(10);
		tree.root.lchild = new Node(20);
		tree.root.rchild = new Node(30);
		tree.root.lchild.lchild = new Node(40);
		tree.root.lchild.rchild = new Node(50);
		System.out.println("Preorder for binary tree is ");
		tree.preOrderNumber();
		System.out.println("\nInorder for binary tree is ");
		tree.inOrderNumber();
		System.out.println("\nPostorder for binary tree is ");
		tree.postOrderNumbers();
	}
}
