/* This is the node constructor that defines each node for our Binary Tree.
 * data stores the value of our node
 * left is the pointer to the left child of given node
 * right is the pointer to the right child of given node	
 */
class Node {
	int data;
	Node left, right;

	// This constructor also sets left child and right child nodes to null
	// While also setting
	public Node(int n) {
		left = null;
		right = null;
		data = n;
	}
}

//In this class we define the methods that are:
//checkSearchTreeOrder()
//hasCorrectOrder()
class Bt {
	// Root of the Binary Tree
	Node root;
	
	// This method start the correct order recursive methods by giving it the
	// correct Min and Max values for initialization
	boolean checkSearchTreeOrder() {
		return hasCorrectOrder(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	//This checks for the correct order in our tree recursively
	boolean hasCorrectOrder(Node node, int min, int max) {
		// Empty tree is a BST
		if (node == null)
			return true;

		// If the node data violates the range, of what it should be
		if (node.data < min || node.data > max)
			return false;

		/*
		 * Recursive: If the maximum of data in the left subtree is smaller than current
		 * node, && If the maximum of data in the right subtree is greater than the node
		 */
		return (hasCorrectOrder(node.left, min, node.data - 1) && hasCorrectOrder(node.right, node.data + 1, max));
	}

}

public class BinaryTest {

	/* Driver program to test above functions */
	public static void main(String args[]) {

		// This is what our binary tree looks like and it does satisfy the search tree
		// order property
		Bt tree = new Bt();
		/*  
		 *          8 
		 *         / \ 
		 *        3   9 
		 *       / \   \ 
		 *      2   4   10
		 */
		tree.root = new Node(8);
		tree.root.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right = new Node(9);
		tree.root.left.left = new Node(2);
		tree.root.right.right = new Node(10);

		if (tree.checkSearchTreeOrder()) {
			System.out.println("The binary tree satisfies the search tree order property at every node");
		} else {
			System.out.println("The binary tree violates the search tree order property");
		}
	}

}