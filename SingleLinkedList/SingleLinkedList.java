import java.util.Scanner;

public class SingleLinkedList {
	private Node start;

	// This constructor will initializes our single linked list and sets the start
	// pointer to null
	public SingleLinkedList() {
		start = null;
	}

	// This method will add the given element to start of the list
	public void add(int x) {
		Node temp = new Node(x);
		temp.link = start;
		start = temp;
	}

	// This method will add the given element to end of the list
	public void addAtEnd(int x) {
		Node p;
		Node temp = new Node(x);

		if (start == null) {
			start = temp;
			return;
		}
		p = start;
		while (p.link != null) {
			p = p.link;
		}
		p.link = temp;
	}

	// This method for entices and purposes is for the user to be able to create
	// there List easily
	public void createList() {
		int i, n, x;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the number nodes : ");
		n = scan.nextInt();

		if (n == 0) {
			return;
		}

		for (i = 1; i <= n; i++) {
			System.out.println("Enter the element to be inserted : ");
			x = scan.nextInt();
			addAtEnd(x);
		}
	} // End of creatList()

	// This method will swap a node of value x with the node to the right of it by
	// only adjusting the links. It does so by traversing pointer r.next to find x,
	// if found it then sets pointer p next to r and q to the next of p and
	// Proceeds to swap the necessary links as shown by the code.
	public void swapTwoNodes(int x) {
		Node r, p, q;

		r = start;

		while (r.link.link != null) {

			// This is to take care of the edge case that might be when the selected node is
			// also the start of our list
			if (start.info == x) {
				p = r.link;
				q = p.link;
				start.link = p.link;
				p.link = start;
				start = p;
				break;
			} else if (r.link.info == x) {
				// Here we set p to the
				p = r.link;
				q = p.link;
				p.link = q.link;
				q.link = p;
				r.link = q;
				break;
			}
			r = r.link;
		}
	}

	// This method displayList() Traverses through our list and displays all the
	// elements in our list by setting pointer p to the next node at each iteration
	public void displayList() {
		Node p;
		if (start == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.print("List is : ");
		p = start;
		while (p != null) {
			System.out.print(p.info + " ");
			p = p.link;
		}
		System.out.println(" ");
	}
}
