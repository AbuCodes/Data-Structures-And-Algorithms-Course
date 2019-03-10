import java.util.Scanner;
import java.util.Random;

//This our node class in here we store info of each nodes and pointers to left right and parent nodes
class Node {
	Node left, right, parent;
	int x;

	public Node(Node parent, Node left, Node right, int x) {
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.x = x;
	}
}

/** Class MedlableHeap **/
class MeldableHeap {
	private Random rand;
	private int n;
	private Node root;

	public MeldableHeap() {
		root = null;
		rand = new Random();
		n = 0;
	}

	/** Check if heap is empty **/
	public boolean isEmpty() {
		return root == null;
	}

	/** clear heap **/
	public void makeEmpty() {
		root = null;
		rand = new Random();
		n = 0;
	}

	/** function to get size **/
	public int getSize() {
		return n;
	}

	/** function to insert an element **/
	public void add(int x) {
		Node u = new Node(null, null, null, x);
		root = meld(u, root);
		root.parent = null;
		n++;
	}

	// This is the method that is in question
	// It is basically the same method that we see in the text book
	public int remove() {
		int x = root.x;
		root = meld(root.left, root.right);
		if (root != null)
			root.parent = null;
		n--;
		return x;
	}

	/** function to merge two nodes **/
	public Node meld(Node q1, Node q2) {
		if (q1 == null)
			return q2;
		if (q2 == null)
			return q1;

		if (q2.x < q1.x)
			return meld(q2, q1);

		if (rand.nextBoolean()) {
			q1.left = meld(q1.left, q2);
			q1.left.parent = q1;
		} else {
			q1.right = meld(q1.right, q2);
			q1.right.parent = q1;
		}
		return q1;
	}

	/** function to print heap **/
	public void displayHeap() {
		System.out.print("\nMeldable Heap : ");
		if (root == null) {
			System.out.print("Empty\n");
			return;
		}

		Node prev, w = root;
		while (w.left != null)
			w = w.left;

		while (w != null) {
			System.out.print(w.x + " ");
			prev = w;
			w = nextNode(w);
		}
		System.out.println();
	}

	/** function to get next node in heap **/
	private Node nextNode(Node w) {
		if (w.right != null) {
			w = w.right;
			while (w.left != null)
				w = w.left;
		} else {
			while (w.parent != null && w.parent.left != w)
				w = w.parent;
			w = w.parent;
		}
		return w;
	}
}

/** Class MeldableHeapTest **/
public class MeldableHeapTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Meldable Heap Test\n\n");

		/* Make object of MeldableHeap */
		MeldableHeap mh = new MeldableHeap();

		char ch;
		/* Perform Meldable Heap operations */
		do {
			System.out.println("\nMeldable Heap Operations\n");
			System.out.println("1. add");
			System.out.println("2. remove");
			System.out.println("3. size");
			System.out.println("4. check empty");
			System.out.println("5. clear");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				mh.add(scan.nextInt());
				break;
			case 2:
				System.out.println("Removed Element : " + mh.remove());
				break;
			case 3:
				System.out.println("Size = " + mh.getSize());
				break;
			case 4:
				System.out.println("Empty status = " + mh.isEmpty());
				break;
			case 5:
				mh.makeEmpty();
				System.out.println("Heap Cleared\n");
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			/* Display heap */
			mh.displayHeap();

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}