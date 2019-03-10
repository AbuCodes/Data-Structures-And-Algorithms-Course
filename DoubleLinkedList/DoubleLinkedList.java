import java.util.Scanner;

public class DoubleLinkedList {
	private Node start;

	// This constructor initializes our double linked list.
	public DoubleLinkedList() {
		start = null;
	}

	// Method displayList loops through each node in our double linked list and
	// displays of each node. It traverses through the list by keeping reference
	// pointer p while setting while moving it self to the next link at each
	// Iteration of the loop
	public void displayList() {
		Node p;

		if (start == null) {
			System.out.println("List is empty");
		}

		p = start;
		System.out.println("List is :\n");
		while (p != null) {
			System.out.print(p.info + " ");
			p = p.next;
		}
		System.out.println();
	}// End of displayList()

	// This method is used when we initial don't have any elements in our list
	// It works by creating a new temp node and setting the setting the start
	// Reference pointer to it
	public void insertInEmptyList(int data) {
		Node temp = new Node(data);
		start = temp;
	}

	// This method inserts a new element at the end of the list by traversing
	// through the list in the same way the displayList() method does to find the
	// null value node and insert the new element at that point of reference
	public void insertAtEnd(int data) {
		Node temp = new Node(data);

		Node p = start;
		while (p.next != null) {
			p = p.next;
		}
		p.next = temp;
		temp.prev = p;
	}

	// This method swaps node x with with the node next to it by only adjusting
	// the links. it does so by traversing pointer a through our list to find
	// element x, if found it will set pointer b to the right of a and proceeds to
	// swap all the necessary links as shown in the code.
	public void swapElement(int x) {
		Node a, b;
		a = start;

		while (a.next != null) {

			if (a.info == x) {
				b = a.next;

				if (a.next == b) { // right next to each other
					a.next = b.next;
					b.prev = a.prev;

					if (a.next != null) {
						a.next.prev = a;
					}

					if (b.prev != null) {
						b.prev.next = b;
					}

					b.next = a;
					a.prev = b;
					System.out.println(a.info);
					System.out.println(start.info);

					// This element checks if the node we are swapping is start
					// and proceeds to set the pointer of the swapped value as our new starting
					// node.
					if (a.info == start.info) {
						start = b;
					}
				}
				break;
			}
			a = a.next;
		}
	}

	// The method createList() Is for simplicity when creating the list for the
	// user. It utilizes the methods we already created to make it easier for the
	// user when creating there new list.
	public void createList() {
		int i, n, data;

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter number of nodes to be inserted: ");
		n = scan.nextInt();

		if (n == 0) {
			return;
		}

		System.out.print("Enter the first element to be inserted: ");
		data = scan.nextInt();
		insertInEmptyList(data);

		for (i = 1; i < n; i++) {
			System.out.println("Enter the next item to be inserted: ");
			data = scan.nextInt();
			insertAtEnd(data);
		}
	}
}
